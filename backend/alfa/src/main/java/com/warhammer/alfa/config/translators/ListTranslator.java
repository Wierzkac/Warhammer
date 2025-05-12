package com.warhammer.alfa.config.translators;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import com.warhammer.alfa.config.TranslationInterceptor;
import com.warhammer.alfa.config.Translator;

@Component
public class ListTranslator implements Translator {

    @Lazy
    @Autowired
    private TranslationInterceptor translationInterceptor;

    @Override
    public Object translate(Object content, Locale locale) {
        List<?> list = (List<?>) content;
        List<Object> translatedList = new ArrayList<>();
        for (Object item : list) {
            translatedList.add(translationInterceptor.translateResponseBody(item, locale));
        }
        return translatedList;
    }

    @Override
    public Class<?> translateClass() {
        return List.class;
    }
}
