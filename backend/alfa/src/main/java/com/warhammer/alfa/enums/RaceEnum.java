package com.warhammer.alfa.enums;

public enum RaceEnum {
    ELF("race.elf"),
    DWARF("race.dwarf"),
    HUMAN("race.human"),
    HALFLING("race.halfling");

    private final String value;

    RaceEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
} 