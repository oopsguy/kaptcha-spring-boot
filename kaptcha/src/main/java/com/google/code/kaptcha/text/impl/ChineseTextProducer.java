/**
 *    Copyright 2015-2018 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.google.code.kaptcha.text.impl;

import com.google.code.kaptcha.text.TextProducer;

import java.security.SecureRandom;

/**
 * TextProducer Implementation that will return Chinese characters..
 */
public class ChineseTextProducer implements TextProducer {
    private String[] simplifiedChineseTexts = new String[]{
            "包括焦点", "新道消点", "服分目搜", "索姓名電", "子郵件信", "主旨請回", "電子郵件", "給我所有", "討論區明", "發表新文", "章此討論", "區所有文", "章回主題",
            "樹瀏覽搜"
    };

    /**
     * @return random Chinese text
     */
    public String getText() {
        // For safety, use SecureRandom instead of Random class
        return simplifiedChineseTexts[new SecureRandom().nextInt(simplifiedChineseTexts.length)];
    }
}
