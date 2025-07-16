package com.warhammer.alfa.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RaceEnum {
    ELF("race.elf"),
    DWARF("race.dwarf"),
    HUMAN("race.human"),
    HALFLING("race.halfling");

    private final String value;
} 