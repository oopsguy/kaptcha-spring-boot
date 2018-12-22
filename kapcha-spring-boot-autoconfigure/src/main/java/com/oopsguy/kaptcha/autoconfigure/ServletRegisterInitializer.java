package com.oopsguy.kaptcha.autoconfigure;

import com.google.code.kaptcha.servlet.KaptchaServlet;
import com.oopsguy.kaptcha.autoconfigure.util.ConfigUtils;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.util.Map;
import java.util.Properties;

/**
 * Register kaptcha servlets configured in properties
 *
 * @author Oopsguy
 */
public class ServletRegisterInitializer implements ServletContextInitializer {

    private final static String KAPTCHA_SERVLET_BEAN_NAME_SUBFFIX = "KapthcaServlet";

    @Resource
    private KaptchaProperties kaptchaProperties;

    @Resource(name = "kaptchaProps")
    private Properties kaptchaProps;

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        Map<String, KaptchaProperties.SingleKaptchaProperties> servlets = kaptchaProperties.getItems();

        if (servlets == null || servlets.isEmpty()) {
            return;
        }

        servlets.forEach((name, props) -> {
            if (StringUtils.isEmpty(props.getPath())) {
                return;
            }

            ServletRegistration.Dynamic serviceServlet = servletContext.addServlet(name + KAPTCHA_SERVLET_BEAN_NAME_SUBFFIX, new KaptchaServlet());
            serviceServlet.addMapping(props.getPath());
            serviceServlet.setAsyncSupported(true);
            Properties subProps = ConfigUtils.kaptchaPropertiesToProperties(props);

            for (Map.Entry<Object, Object> en : kaptchaProps.entrySet()) {
                boolean isSkip = subProps.containsKey(en.getKey()) && !StringUtils.isEmpty(String.valueOf(subProps.get(en.getKey())))
                        || StringUtils.isEmpty(en.getValue());
                if (isSkip) {
                    continue;
                }
                subProps.setProperty(String.valueOf(en.getKey()), String.valueOf(en.getValue()));
            }

            for (Map.Entry<Object, Object> en : subProps.entrySet()) {
                serviceServlet.setInitParameter(String.valueOf(en.getKey()), String.valueOf(en.getValue()));
            }
        });
    }

}
