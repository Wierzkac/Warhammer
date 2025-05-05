package com.warhammer.alfa.models.Race.races;

import com.warhammer.alfa.enums.CharacteristicEnum;
import com.warhammer.alfa.enums.RaceEnum;
import com.warhammer.alfa.models.Character.Character;
import com.warhammer.alfa.models.Race.Race;
import com.warhammer.alfa.models.Skill.SkillRepository;
import com.warhammer.alfa.models.Talent.TalentRepository;

import java.util.EnumMap;
import java.util.HashSet;

public class Elf extends Race {
    public Elf(SkillRepository skillRepository, TalentRepository talentRepository) {
        super(
            RaceEnum.ELF,
            "race.elf.name",
            "race.elf.description",
            "race.elf.background",
            "race.elf.roleplayingHints",
            skillRepository,
            talentRepository
        );
        initializeCharacteristicModifiers();
        initializeSkills();
        initializeTalents();
    }

    private void initializeCharacteristicModifiers() {
        characteristicModifiers = new EnumMap<>(CharacteristicEnum.class);
        characteristicModifiers.put(CharacteristicEnum.WEAPON_SKILL, 20); // + 2d10
        characteristicModifiers.put(CharacteristicEnum.BALLISTIC_SKILL, 30); // + 2d10
        characteristicModifiers.put(CharacteristicEnum.STRENGTH, 20); // + 2d10
        characteristicModifiers.put(CharacteristicEnum.TOUGHNESS, 20); // + 2d10
        characteristicModifiers.put(CharacteristicEnum.AGILITY, 30); // + 2d10
        characteristicModifiers.put(CharacteristicEnum.INTELLIGENCE, 20); // + 2d10
        characteristicModifiers.put(CharacteristicEnum.WILL_POWER, 20); // + 2d10
        characteristicModifiers.put(CharacteristicEnum.FELLOWSHIP, 20); // + 2d10
        characteristicModifiers.put(CharacteristicEnum.ATTACKS, 1);
        characteristicModifiers.put(CharacteristicEnum.WOUNDS, 0); // + 1d10 via starting wounds table
        characteristicModifiers.put(CharacteristicEnum.STRENGTH_BONUS, characteristicModifiers.get(CharacteristicEnum.STRENGTH) / 10);
        characteristicModifiers.put(CharacteristicEnum.TOUGHNESS_BONUS, characteristicModifiers.get(CharacteristicEnum.TOUGHNESS) / 10);
        characteristicModifiers.put(CharacteristicEnum.MOVEMENT, 5);
        characteristicModifiers.put(CharacteristicEnum.MAGIC, 0);
        characteristicModifiers.put(CharacteristicEnum.INSTANITY_POINTS, 0);
        characteristicModifiers.put(CharacteristicEnum.FATE_POINTS, 0); // + 1d10 via starting fate points table
    }

    private void initializeSkills() {
        skills = new HashSet<>();
        skills.add(skillRepository.findByName("skill.common_knowledge.name"));
        skills.add(skillRepository.findByName("skill.speak_language.name")); // Eltharin
        skills.add(skillRepository.findByName("skill.speak_language.name")); // Reikspiel
    }

    private void initializeTalents() {
        talents = new HashSet<>();
        talents.add(talentRepository.findByName("talent.excellent_vision.name"));
        talents.add(talentRepository.findByName("talent.night_vision.name"));
    }

    @Override
    public void generateCharacter(Character character) {
        // TODO: Implement elf generation
    }
} 