package com.oopsguy.kaptcha.kapchaspringbootautoconfigure;

import com.oopsguy.kaptcha.kapchaspringbootautoconfigure.constant.KaptchaConst;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * ConfigurationProperties for kaptcha
 *
 * @author Oopsguy
 */
@ConfigurationProperties(
        prefix = KaptchaConst.AUTO_CONFIG_PREFIX
)
public class KaptchaProperties extends BaseProperties {

    private Map<String, SingleKaptchaProperties> servlets = new HashMap<>();

    public Map<String, SingleKaptchaProperties> getServlets() {
        return servlets;
    }

    public void setServlets(Map<String, SingleKaptchaProperties> servlets) {
        this.servlets = servlets;
    }

    public static class SingleKaptchaProperties extends BaseProperties {
        private Session session = new Session();

        private String servlet;

        public static class Session {
            private String key;

            private String date;

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }
        }

        public Session getSession() {
            return session;
        }

        public void setSession(Session session) {
            this.session = session;
        }

        public String getServlet() {
            return servlet;
        }

        public void setServlet(String servlet) {
            this.servlet = servlet;
        }
    }

}
