package com.warhammer.alfa.enums;

public enum EmailStatusEnum {
    PENDING("TO_BE_SENT"),
    SENT("SENT");

    private final String value;

    EmailStatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
