package com.warhammer.alfa.enums;

public enum GenderEnum {
    MALE("gender.male"),
    FEMALE("gender.female"),
    OTHER("gender.other");

    private final String value;

    GenderEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
} 