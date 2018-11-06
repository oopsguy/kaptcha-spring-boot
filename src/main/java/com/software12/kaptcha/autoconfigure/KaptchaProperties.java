package com.software12.kaptcha.autoconfigure;

import com.software12.kaptcha.constant.KaptchaConst;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(
        prefix = KaptchaConst.AUTO_CONFIG_PREFIX
)
public class KaptchaProperties {

    private Session session = new Session();

    private Servlet servlet = new Servlet();

    private Border border = new Border();

    private Noise noise = new Noise();

    private Obscurificator obscurificator = new Obscurificator();

    private Producer producer = new Producer();

    private TextProducer textProducer = new TextProducer();

    private Background background = new Background();

    private Word word = new Word();

    private Image image = new Image();

    public static class Servlet {
        private Boolean enabled = false;

        private String path = "/kaptcha";

        public Boolean getEnabled() {
            return enabled;
        }

        public void setEnabled(Boolean enabled) {
            this.enabled = enabled;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }
    }

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

    public static class Border {
        private Boolean enabled = true;

        private String color = "0,0,0";

        private Integer thickness = 1;

        public Boolean getEnabled() {
            return enabled;
        }

        public void setEnabled(Boolean enabled) {
            this.enabled = enabled;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public Integer getThickness() {
            return thickness;
        }

        public void setThickness(Integer thickness) {
            this.thickness = thickness;
        }
    }

    public static class Noise {
        private String color = "0,0,0";

        private String impl = "com.google.code.kaptcha.impl.DefaultNoise";

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getImpl() {
            return impl;
        }

        public void setImpl(String impl) {
            this.impl = impl;
        }
    }

    public static class Obscurificator {
        private String impl = "com.google.code.kaptcha.impl.WaterRipple";

        public String getImpl() {
            return impl;
        }

        public void setImpl(String impl) {
            this.impl = impl;
        }
    }

    public static class Producer {
        private String impl = "com.google.code.kaptcha.impl.DefaultKaptcha";

        public String getImpl() {
            return impl;
        }

        public void setImpl(String impl) {
            this.impl = impl;
        }
    }

    public static class TextProducer {
        private String impl = "com.google.code.kaptcha.text.impl.DefaultTextCreator";

        private Char character = new Char();

        private Font font = new Font();

        static class Char {
            private String string = "abcde2345678gfynmnpwx";

            private Integer length = 5;

            private Integer space = 2;

            public String getString() {
                return string;
            }

            public void setString(String string) {
                this.string = string;
            }

            public Integer getLength() {
                return length;
            }

            public void setLength(Integer length) {
                this.length = length;
            }

            public Integer getSpace() {
                return space;
            }

            public void setSpace(Integer space) {
                this.space = space;
            }
        }

        static class Font {
            private String[] names = new String[]{"Arial", "Courier"};

            private String color = "0,0,0";

            private Integer size = 40;

            public String[] getNames() {
                return names;
            }

            public void setNames(String[] names) {
                this.names = names;
            }

            public String getColor() {
                return color;
            }

            public void setColor(String color) {
                this.color = color;
            }

            public Integer getSize() {
                return size;
            }

            public void setSize(Integer size) {
                this.size = size;
            }
        }

        public String getImpl() {
            return impl;
        }

        public void setImpl(String impl) {
            this.impl = impl;
        }

        public Char getCharacter() {
            return character;
        }

        public void setCharacter(Char character) {
            this.character = character;
        }

        public Font getFont() {
            return font;
        }

        public void setFont(Font font) {
            this.font = font;
        }
    }

    public static class Word {
        private String impl = "com.google.code.kaptcha.text.impl.DefaultWordRenderer";

        public String getImpl() {
            return impl;
        }

        public void setImpl(String impl) {
            this.impl = impl;
        }
    }

    public static class Background {
        private String impl = "com.google.code.kaptcha.impl.DefaultBackground";

        private String colorFrom = "192,192,192";

        private String colorTo = "255,255,255";

        public String getImpl() {
            return impl;
        }

        public void setImpl(String impl) {
            this.impl = impl;
        }

        public String getColorFrom() {
            return colorFrom;
        }

        public void setColorFrom(String colorFrom) {
            this.colorFrom = colorFrom;
        }

        public String getColorTo() {
            return colorTo;
        }

        public void setColorTo(String colorTo) {
            this.colorTo = colorTo;
        }
    }

    public static class Image {
        private Integer width = 200;

        private Integer height = 50;

        public Integer getWidth() {
            return width;
        }

        public void setWidth(Integer width) {
            this.width = width;
        }

        public Integer getHeight() {
            return height;
        }

        public void setHeight(Integer height) {
            this.height = height;
        }
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Servlet getServlet() {
        return servlet;
    }

    public void setServlet(Servlet servlet) {
        this.servlet = servlet;
    }

    public Border getBorder() {
        return border;
    }

    public void setBorder(Border border) {
        this.border = border;
    }

    public Noise getNoise() {
        return noise;
    }

    public void setNoise(Noise noise) {
        this.noise = noise;
    }

    public Obscurificator getObscurificator() {
        return obscurificator;
    }

    public void setObscurificator(Obscurificator obscurificator) {
        this.obscurificator = obscurificator;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public TextProducer getTextProducer() {
        return textProducer;
    }

    public void setTextProducer(TextProducer textProducer) {
        this.textProducer = textProducer;
    }

    public Background getBackground() {
        return background;
    }

    public void setBackground(Background background) {
        this.background = background;
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
