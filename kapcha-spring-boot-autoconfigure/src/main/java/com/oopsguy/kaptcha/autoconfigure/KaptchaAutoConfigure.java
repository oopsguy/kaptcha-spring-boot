package com.oopsguy.kaptcha.autoconfigure;

import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import com.oopsguy.kaptcha.autoconfigure.util.ConfigUtils;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.Properties;

/**
 * Spring Boot Auto Configuration for kaptcha
 *
 * @author Oopsguy
 */
@Configuration
@EnableConfigurationProperties(KaptchaProperties.class)
public class KaptchaAutoConfigure {

    @Bean(name = "kaptchaProps")
    protected Properties kaptchaProps(KaptchaProperties kaptchaProperties) {
        return ConfigUtils.kaptchaPropertiesToProperties(kaptchaProperties);
    }

    @Bean
    @DependsOn({"kaptchaProps"})
    public Producer defaultKaptcha(Properties kaptchaProps) {
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        Config config = new Config(kaptchaProps);
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }

    @Bean
    @DependsOn({"kaptchaProps"})
    public ServletContextInitializer webConfig() {
        return new ServletRegisterInitializer();
    }

}
