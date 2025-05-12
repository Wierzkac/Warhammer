package com.warhammer.alfa.config.translators;

import java.lang.reflect.Field;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import com.warhammer.alfa.config.TranslationInterceptor;
import com.warhammer.alfa.config.Translator;

@Component
public class ObjectTranslator implements Translator {

    @Lazy
    @Autowired
    private TranslationInterceptor translationInterceptor;

    @Override
    public Object translate(Object content, Locale locale) {
        if (content == null) {
            return null;
        }
        Class<?> contentClass = content.getClass();
        try {
            // Create a copy of the object to avoid modifying the original
            Object copy = contentClass.getDeclaredConstructor().newInstance();

            for (Field field : contentClass.getDeclaredFields()) {
                field.setAccessible(true);
                Object value = field.get(content);
                field.set(copy, translationInterceptor.translateResponseBody(value, locale));
            }
            return copy;
        } catch (Exception e) {
            // If we can't create a copy or access fields, return original
            return content;
        }
    }

    @Override
    public Class<?> translateClass() {
        return Object.class;
    }
}