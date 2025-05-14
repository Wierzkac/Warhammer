package com.warhammer.alfa.config.translation.translators;

import java.util.Locale;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import com.warhammer.alfa.config.translation.Translator;

@Component
@Order(2)
public class IntegerTranslator implements Translator {

    @Override
    public Object translate(Object content, Locale locale) {
        return content;
    }

    @Override
    public Class<?> translateClass() {
        return Integer.class;
    }
}
