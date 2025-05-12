package com.warhammer.alfa.config.translators;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import com.warhammer.alfa.config.TranslationInterceptor;
import com.warhammer.alfa.config.Translator;

@Component
public class MapTranslator implements Translator {

    @Lazy
    @Autowired
    private TranslationInterceptor translationInterceptor;

    @Override
    public Object translate(Object content, Locale locale) {
        Map<?, ?> map = (Map<?, ?>) content;
        Map<Object, Object> translatedMap = new LinkedHashMap<>(map.size());
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            System.out.println("Translating object: " + value);
            translatedMap.put(key, translationInterceptor.translateResponseBody(value, locale)); /// TODO: fix TranslationInterceptor call
        }
        return translatedMap;
    }

    @Override
    public Class<?> translateClass() {
        return Map.class;
    }
}
