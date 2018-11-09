package com.software12.kaptcha.util;

import com.google.code.kaptcha.Constants;
import com.software12.kaptcha.autoconfigure.BaseProperties;

import java.util.Properties;

/**
 * Utilities for config file
 *
 * @author Oopsguy
 */
public class ConfigUtils {

    private static String nullToString(Object value) {
        if (value != null) {
            return String.valueOf(value);
        }
        return "";
    }

    public static Properties kaptchaPropertiesToProperties(BaseProperties kaptchaProperties) {
        Properties properties = new Properties();

        Boolean border = kaptchaProperties.getBorder().getEnabled();
        properties.setProperty(Constants.KAPTCHA_BORDER, (border == null ? "" : (Boolean.FALSE.equals(border) ? "no" : "yes")));
        properties.setProperty(Constants.KAPTCHA_BORDER_COLOR, nullToString(kaptchaProperties.getBorder().getColor()));
        properties.setProperty(Constants.KAPTCHA_BORDER_THICKNESS, nullToString(kaptchaProperties.getBorder().getThickness()));

        properties.setProperty(Constants.KAPTCHA_NOISE_COLOR, nullToString(kaptchaProperties.getNoise().getColor()));
        properties.setProperty(Constants.KAPTCHA_NOISE_IMPL, nullToString(kaptchaProperties.getNoise().getImpl()));

        properties.setProperty(Constants.KAPTCHA_OBSCURIFICATOR_IMPL, nullToString(kaptchaProperties.getObscurificator().getImpl()));

        properties.setProperty(Constants.KAPTCHA_PRODUCER_IMPL, nullToString(kaptchaProperties.getProducer().getImpl()));

        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_IMPL, nullToString(kaptchaProperties.getTextProducer().getImpl()));
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_CHAR_STRING, nullToString(kaptchaProperties.getTextProducer().getCharacter().getString()));
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_CHAR_LENGTH, nullToString(kaptchaProperties.getTextProducer().getCharacter().getLength()));
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_CHAR_SPACE, nullToString(kaptchaProperties.getTextProducer().getCharacter().getSpace()));
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_FONT_NAMES, String.join(",", kaptchaProperties.getTextProducer().getFont().getNames()));
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_FONT_COLOR, nullToString(kaptchaProperties.getTextProducer().getFont().getColor()));
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_FONT_SIZE, nullToString(kaptchaProperties.getTextProducer().getFont().getSize()));

        properties.setProperty(Constants.KAPTCHA_WORDRENDERER_IMPL, nullToString(kaptchaProperties.getWord().getImpl()));

        properties.setProperty(Constants.KAPTCHA_BACKGROUND_IMPL, nullToString(kaptchaProperties.getBackground().getImpl()));
        properties.setProperty(Constants.KAPTCHA_BACKGROUND_CLR_FROM, nullToString(kaptchaProperties.getBackground().getColorFrom()));
        properties.setProperty(Constants.KAPTCHA_BACKGROUND_CLR_TO, nullToString(kaptchaProperties.getBackground().getColorTo()));

        properties.setProperty(Constants.KAPTCHA_IMAGE_WIDTH, nullToString(kaptchaProperties.getImage().getWidth()));
        properties.setProperty(Constants.KAPTCHA_IMAGE_HEIGHT, nullToString(kaptchaProperties.getImage().getHeight()));

        return properties;
    }

}
