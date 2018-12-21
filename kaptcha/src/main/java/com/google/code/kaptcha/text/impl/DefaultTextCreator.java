package com.google.code.kaptcha.text.impl;

import com.google.code.kaptcha.text.TextProducer;
import com.google.code.kaptcha.util.Configurable;

import java.security.SecureRandom;

/**
 * {@link DefaultTextCreator} creates random text from an array of characters
 * with specified length.
 */
public class DefaultTextCreator extends Configurable implements TextProducer {
    /**
     * @return the random text
     */
    public String getText() {
        int length = getConfig().getTextProducerCharLength();
        char[] chars = getConfig().getTextProducerCharString();
        SecureRandom rand = new SecureRandom();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < length; i++) {
            text.append(chars[rand.nextInt(chars.length)]);
        }

        return text.toString();
    }
}
