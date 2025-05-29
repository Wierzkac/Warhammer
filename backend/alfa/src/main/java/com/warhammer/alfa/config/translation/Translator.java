package com.warhammer.alfa.config.translation;

import java.util.Locale;

public interface Translator {
    Object translate(Object object, Locale locale);
    Class<?> translateClass();
}
