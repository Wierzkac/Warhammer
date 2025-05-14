package com.warhammer.alfa.config.translation.translators;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import com.warhammer.alfa.config.translation.TranslatorUtil;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import com.warhammer.alfa.config.translation.Translator;

@Component
@Order(5)
public class MapTranslator implements Translator {

    private final TranslatorUtil translatorUtil;

    MapTranslator(@Lazy TranslatorUtil translatorUtil) {
        this.translatorUtil = translatorUtil;
    }

    @Override
    public Object translate(Object content, Locale locale) {
        Map<?, ?> map = (Map<?, ?>) content;
        Map<Object, Object> translatedMap = new LinkedHashMap<>(map.size());
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            System.out.println("Translating object: " + value);
            Class<?> clazz = value.getClass();
            translatedMap.put(key, translatorUtil.getSpecificTranslatorForClass(clazz).translate(value, locale));
        }
        return translatedMap;
    }

    @Override
    public Class<?> translateClass() {
        return Map.class;
    }
}
