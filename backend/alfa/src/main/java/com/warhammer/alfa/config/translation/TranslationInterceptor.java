package com.warhammer.alfa.config.translation;

import java.util.*;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@Slf4j
@RestControllerAdvice
@Component
public class TranslationInterceptor implements ResponseBodyAdvice<Object> {

    private final TranslatorUtil translatorUtil;

    TranslationInterceptor(TranslatorUtil translatorUtil) {
        this.translatorUtil = translatorUtil;
    }

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        // Apply translation logic for all controller methods returning an Object
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        // Translate the response body here
        if (body instanceof Map && ((Map)body).containsKey("error")) {
            return body;
        }

        // Get locale from Accept-Language header
        Locale locale = resolveLocale(request);

        return translateResponseBody(body, locale);
    }

    private Locale resolveLocale(ServerHttpRequest request) {
        // Get Accept-Language header
        List<String> acceptLanguage = request.getHeaders().get("Accept-Language");

        // Default to system locale if no header present
        if (acceptLanguage == null || acceptLanguage.isEmpty()) {
            return Locale.getDefault();
        }

        // Parse the first language tag (e.g., "en-US,en;q=0.9" -> "en-US")
        String languageTag = acceptLanguage.get(0).split(",")[0];
        return Locale.forLanguageTag(languageTag);
    }

    public Object translateResponseBody(Object body, Locale locale) {
        return translatorUtil.getSpecificTranslatorForClass(body.getClass())
            .translate(body, locale);
    }
}