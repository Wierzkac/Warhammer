package com.warhammer.alfa.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EmailStatusEnum {
    PENDING("TO_BE_SENT"),
    SENT("SENT");

    private final String value;
}
