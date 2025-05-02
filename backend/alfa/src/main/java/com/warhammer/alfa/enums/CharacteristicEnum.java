package com.warhammer.alfa.enums;

public enum CharacteristicEnum {    
    WEAPON_SKILL("characteristic.weapon_skill"),
    BALLISTIC_SKILL("characteristic.ballistic_skill"),
    STRENGTH("characteristic.strength"),
    TOUGHNESS("characteristic.toughness"),
    AGILITY("characteristic.agility"),
    INTELLIGENCE("characteristic.intelligence"),
    WILL_POWER("characteristic.will_power"),
    FELLOWSHIP("characteristic.fellowship"),
    
    ATTACKS("characteristic.attacks"),
    WOUNDS("characteristic.wounds"),
    STRENGTH_BONUS("characteristic.strength_bonus"),
    TOUGHNESS_BONUS("characteristic.toughness_bonus"),
    MOVEMENT("characteristic.movement"),
    MAGIC("characteristic.magic"),
    INSTANITY_POINTS("characteristic.insanity_points"),
    FATE_POINTS("characteristic.fate_points"),
    
    NONE("characteristic.none");

    private final String value;

    CharacteristicEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
