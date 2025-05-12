package com.warhammer.alfa.config.translators;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import com.warhammer.alfa.config.TranslationInterceptor;
import com.warhammer.alfa.config.Translator;

@Component
public class ArrayTranslator implements Translator {

    @Lazy
    @Autowired
    private TranslationInterceptor translationInterceptor;

    @Override
    public Object translate(Object content, Locale locale) {
        Object[] array = (Object[]) content;
        Object[] translatedArray = new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            translatedArray[i] = translationInterceptor.translateResponseBody(array[i], locale);
        }
        return translatedArray;
    }

    @Override
    public Class<?> translateClass() {
        return Object[].class;
    }
}