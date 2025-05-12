package com.warhammer.alfa.models.Race;

import com.warhammer.alfa.models.Skill.Skill;
import com.warhammer.alfa.models.Talent.Talent;
import com.warhammer.alfa.enums.CharacteristicEnum;

import java.util.Map;
import java.util.Set;

public interface RaceFactory {
    Race createRace();
    Set<Skill> loadSkills();
    Set<Talent> loadTalents();
    Map<CharacteristicEnum, Integer> loadCharacteristicModifiers();
} 