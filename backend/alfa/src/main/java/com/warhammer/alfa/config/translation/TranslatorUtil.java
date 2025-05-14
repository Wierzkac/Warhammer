package com.warhammer.alfa.config.translation;

import com.warhammer.alfa.exceptions.TranslationException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TranslatorUtil {

    private final List<Translator> translators;

    public TranslatorUtil(List<Translator> translators) {
        this.translators = translators;
    }

    public Translator getSpecificTranslatorForClass(Class<?> clazz) {
        return translators.stream()
                .filter(translator -> translator.translateClass().isAssignableFrom(clazz))
                .findFirst()
                .orElseThrow(() -> new TranslationException("No translator found for class: " + clazz));
    }
}
