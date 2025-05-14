package com.warhammer.alfa.config.translation.translators;

import java.util.Locale;

import com.warhammer.alfa.config.translation.TranslatorUtil;

import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import com.warhammer.alfa.config.translation.Translator;

@Component
@Order(3)
public class ArrayTranslator implements Translator {

    private final TranslatorUtil translatorUtil;

    ArrayTranslator(@Lazy TranslatorUtil translatorUtil) {
        this.translatorUtil = translatorUtil;
    }

    @Override
    public Object translate(Object content, Locale locale) {
        Object[] array = (Object[]) content;
        Object[] translatedArray = new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            Class<?> clazz = array[i].getClass();
            translatedArray[i] = translatorUtil.getSpecificTranslatorForClass(clazz).translate(array[i], locale);
        }
        return translatedArray;
    }

    @Override
    public Class<?> translateClass() {
        return Object[].class;
    }
}