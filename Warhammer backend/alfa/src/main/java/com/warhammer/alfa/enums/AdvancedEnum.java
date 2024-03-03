package com.warhammer.alfa.enums;

public enum AdvancedEnum {
    BASIC("advance_type.basic"),
    ADVANCED("advance_type.advanced");

    private final String value;

    AdvancedEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
