package com.warhammer.alfa.enums;

public enum AdvanceLevelEnum {
    BASIC("advance_type.basic"),
    ADVANCED("advance_type.advanced");

    private final String value;

    AdvanceLevelEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
