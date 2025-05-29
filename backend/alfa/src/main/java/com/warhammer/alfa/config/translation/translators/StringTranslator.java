package com.warhammer.alfa.config.translation.translators;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import com.warhammer.alfa.config.translation.Translator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Order(1)
public class StringTranslator implements Translator {

    @Autowired
    private MessageSource messageSource;
    
    @Override
    public Object translate(Object content, Locale locale) {
        try {
            return messageSource.getMessage(content.toString(), null, locale);
        } catch (NoSuchMessageException ex) {
            log.error("Could not translate string: " + content, ex);
            return content;
        }
    }

    @Override
    public Class<?> translateClass() {
        return String.class;
    }
}
