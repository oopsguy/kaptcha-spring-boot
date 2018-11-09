package com.google.code.kaptcha.impl;

import com.google.code.kaptcha.NoiseProducer;
import com.google.code.kaptcha.util.Configurable;

import java.awt.image.BufferedImage;

/**
 * Imlemention of NoiseProducer that does nothing.
 *
 * @author Yuxing Wang
 */
public class NoNoise extends Configurable implements NoiseProducer {
    /**
     */
    public void makeNoise(BufferedImage image, float factorOne,
                          float factorTwo, float factorThree, float factorFour) {
        //Do nothing.
    }
}
