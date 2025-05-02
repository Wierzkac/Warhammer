package com.warhammer.alfa.config;

import java.lang.reflect.Field;
import java.util.*;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
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

    @Autowired
    private MessageSource messageSource;

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

    private Object translateResponseBody(Object body, Locale locale) {
        if (body instanceof String) {
            return translateString((String) body, locale);
        } else if (body instanceof Integer) {
            return body;
        } else if (body instanceof Map) {
            return translateMap((Map<?, ?>) body, locale);
        } else if (body instanceof List) {
            return translateList((List<?>) body, locale);
        } else if (body.getClass().isArray()) {
            return translateArray((Object[]) body, locale);
        } else {
            return translateObjectFields(body, locale);
        }
    }

    private String translateString(String content, Locale locale) {
        try {
            return messageSource.getMessage(content, null, locale);
        } catch (NoSuchMessageException ex) {
            log.error("Could not translate string: " + content, ex);
            return content;
        }
    }

    private Map<?, ?> translateMap(Map<?, ?> map, Locale locale) {
        Map<Object, Object> translatedMap = new LinkedHashMap<>(map.size());
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            translatedMap.put(key, translateResponseBody(value, locale));
        }
        return translatedMap;
    }

    private List<?> translateList(List<?> list, Locale locale) {
        List<Object> translatedList = new ArrayList<>(list.size());
        for (Object item : list) {
            translatedList.add(translateResponseBody(item, locale));
        }
        return translatedList;
    }

    private Object[] translateArray(Object[] array, Locale locale) {
        Object[] translatedArray = new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            translatedArray[i] = translateResponseBody(array[i], locale);
        }
        return translatedArray;
    }

    private Object translateObjectFields(Object obj, Locale locale) {
        if (obj == null) {
            return null;
        }

        try {
            // Create a copy of the object to avoid modifying the original
            Object copy = obj.getClass().getDeclaredConstructor().newInstance();

            for (Field field : obj.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                Object value = field.get(obj);
                field.set(copy, translateResponseBody(value, locale));
            }
            return copy;
        } catch (Exception e) {
            // If we can't create a copy or access fields, return original
            return obj;
        }
    }
}