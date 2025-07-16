package com.warhammer.alfa.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum GenderEnum {
    MALE("gender.male"),
    FEMALE("gender.female"),
    OTHER("gender.other");

    private final String value;
} 