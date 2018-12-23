package com.oopsguy.kaptcha.autoconfigure;

import com.oopsguy.kaptcha.autoconfigure.constant.KaptchaConst;
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

    private Map<String, SingleKaptchaProperties> items = new HashMap<>();

    public Map<String, SingleKaptchaProperties> getItems() {
        return items;
    }

    public void setItems(Map<String, SingleKaptchaProperties> items) {
        this.items = items;
    }

    public static class SingleKaptchaProperties extends BaseProperties {
        private Session session = new Session();

        private String path;

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

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }
    }

}
