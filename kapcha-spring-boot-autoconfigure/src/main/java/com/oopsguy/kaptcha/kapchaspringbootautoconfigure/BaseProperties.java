package com.oopsguy.kaptcha.kapchaspringbootautoconfigure;

/**
 * Kaptcha base properties
 *
 * @author Oopsguy
 */
public abstract class BaseProperties {

    private Border border = new Border();

    private Noise noise = new Noise();

    private Obscurificator obscurificator = new Obscurificator();

    private Producer producer = new Producer();

    private TextProducer textProducer = new TextProducer();

    private Background background = new Background();

    private Word word = new Word();

    private Image image = new Image();

    public static class Border {
        private Boolean enabled = true;

        private String color;

        private Integer thickness;

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
        private String color;

        private String impl;

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
        private String impl;

        public String getImpl() {
            return impl;
        }

        public void setImpl(String impl) {
            this.impl = impl;
        }
    }

    public static class Producer {
        private String impl;

        public String getImpl() {
            return impl;
        }

        public void setImpl(String impl) {
            this.impl = impl;
        }
    }

    public static class TextProducer {
        private String impl;

        private Char character = new Char();

        private Font font = new Font();

        public static class Char {
            private String string;

            private Integer length;

            private Integer space;

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

        public static class Font {
            private String[] names = new String[]{};

            private String color;

            private Integer size;

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
        private String impl;

        public String getImpl() {
            return impl;
        }

        public void setImpl(String impl) {
            this.impl = impl;
        }
    }

    public static class Background {
        private String impl;

        private String colorFrom;

        private String colorTo;

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
        private Integer width;

        private Integer height;

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
