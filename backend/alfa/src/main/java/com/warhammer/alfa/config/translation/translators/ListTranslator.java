package com.warhammer.alfa.config.translation.translators;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.warhammer.alfa.config.translation.TranslatorUtil;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import com.warhammer.alfa.config.translation.Translator;

@Component
@Order(4)
public class ListTranslator implements Translator {

    private final TranslatorUtil translatorUtil;

    ListTranslator(@Lazy TranslatorUtil translatorUtil) {
        this.translatorUtil = translatorUtil;
    }

    @Override
    public Object translate(Object content, Locale locale) {
        List<?> list = (List<?>) content;
        List<Object> translatedList = new ArrayList<>();
        for (Object item : list) {
            Class<?> clazz = item.getClass();
            translatedList.add(translatorUtil.getSpecificTranslatorForClass(clazz).translate(item, locale));
        }
        return translatedList;
    }

    @Override
    public Class<?> translateClass() {
        return ArrayList.class;
    }
}
