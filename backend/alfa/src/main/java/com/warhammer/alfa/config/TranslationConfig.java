package com.warhammer.alfa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.HashSet;
import java.util.Set;

@Configuration
public class TranslationConfig {
    
    @Bean
    public Set<Translator> translators() {
        return new HashSet<>();
    }
} 