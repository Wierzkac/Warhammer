package com.warhammer.alfa.config.translators;

import java.util.Locale;
import org.springframework.stereotype.Component;
import com.warhammer.alfa.config.Translator;

@Component
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
