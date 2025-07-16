package com.warhammer.alfa.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AdvanceLevelEnum {
    BASIC("advance_type.basic"),
    ADVANCED("advance_type.advanced");

    private final String value;
}
