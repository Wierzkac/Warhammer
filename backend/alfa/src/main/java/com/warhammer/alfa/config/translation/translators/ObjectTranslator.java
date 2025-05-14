package com.warhammer.alfa.config.translation.translators;

import java.lang.reflect.Field;
import java.util.Locale;

import com.warhammer.alfa.config.translation.TranslatorUtil;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import com.warhammer.alfa.config.translation.Translator;

@Component
@Order()
public class ObjectTranslator implements Translator {

    private final TranslatorUtil translatorUtil;

    ObjectTranslator(@Lazy TranslatorUtil translatorUtil) {
        this.translatorUtil = translatorUtil;
    }

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
                Class<?> clazz = value.getClass();
                field.set(copy, translatorUtil.getSpecificTranslatorForClass(clazz).translate(value, locale));
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