package com.warhammer.alfa.config;

import java.lang.reflect.Field;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
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

        translateStringsInObject(body);
        return body;
    }

    private Object translateStringsInObject(Object object) {
        if (object== null || object instanceof Integer || object instanceof Boolean || object instanceof Float || object instanceof Double){
            return object;
        }
        else if (object instanceof String) {
            return translateString((String) object);
        } else if (object.getClass().isArray()) {
            Object[] array = (Object[]) object;
            for (Object item : array) {
                item = translateStringsInObject(item);
            }
            return array;
        } else if (object instanceof List) {
            List collection = (List) object;
            for (Object item : collection) {
                item = translateStringsInObject(item);
            }
            return collection;
        } else if (object instanceof Map) {
            Map<String, String> map = (Map) object;
            for (Map.Entry entry : map.entrySet()) {
                entry.setValue(translateStringsInObject(entry.getValue()));
            }
            return map;
        } else if (object instanceof Object) {
            Field[] fields = object.getClass().getDeclaredFields();

            for (Field field : fields) {
                // Set the field accessible to true to access private fields
                field.setAccessible(true);
                try {
                    // Get the value of the field from the object
                    Object fieldValue = field.get(object);
                    field.set(object, translateStringsInObject(fieldValue));
                } catch (IllegalAccessException e) {
                    // Handle IllegalAccessException
                    e.printStackTrace();
                }
            }
            return object;
        }
        return object;
    }

    private String translateString(String content) {
        String message = content;
        try {
            message = messageSource.getMessage(content, null, Locale.getDefault());
        } catch (Exception e) {
        }
        return message;

    }
}