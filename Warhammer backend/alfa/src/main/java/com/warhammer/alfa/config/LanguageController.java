package com.warhammer.alfa.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.Locale;

@RestController
@RequestMapping("/language")
public class LanguageController {
    @PostMapping("/")
    public ResponseEntity<String> setLanguagePreference(@RequestBody String language) {
        Locale.setDefault(Locale.forLanguageTag(language));
        return ResponseEntity.status(HttpStatus.OK).body("Language preference set to: " + language);
    }
}
