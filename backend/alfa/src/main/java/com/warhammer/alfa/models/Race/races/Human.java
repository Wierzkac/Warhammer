package com.warhammer.alfa.models.Race.races;

import com.warhammer.alfa.enums.CharacteristicEnum;
import com.warhammer.alfa.enums.RaceEnum;
import com.warhammer.alfa.models.Character.Character;
import com.warhammer.alfa.models.Race.Race;
import com.warhammer.alfa.models.Skill.SkillRepository;
import com.warhammer.alfa.models.Talent.TalentRepository;
import com.warhammer.alfa.UtilTables.RandomTalentTable;
import com.warhammer.alfa.models.Talent.Talent;

import java.util.EnumMap;
import java.util.HashSet;

public class Human extends Race {
    public Human(SkillRepository skillRepository, TalentRepository talentRepository) {
        super(
            RaceEnum.HUMAN,
            "race.human.name",
            "race.human.description",
            "race.human.background",
            "race.human.roleplayingHints",
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
        characteristicModifiers.put(CharacteristicEnum.BALLISTIC_SKILL, 20); // + 2d10
        characteristicModifiers.put(CharacteristicEnum.STRENGTH, 20); // + 2d10
        characteristicModifiers.put(CharacteristicEnum.TOUGHNESS, 20); // + 2d10
        characteristicModifiers.put(CharacteristicEnum.AGILITY, 20); // + 2d10
        characteristicModifiers.put(CharacteristicEnum.INTELLIGENCE, 20); // + 2d10
        characteristicModifiers.put(CharacteristicEnum.WILL_POWER, 20); // + 2d10
        characteristicModifiers.put(CharacteristicEnum.FELLOWSHIP, 20); // + 2d10
        characteristicModifiers.put(CharacteristicEnum.ATTACKS, 1);
        characteristicModifiers.put(CharacteristicEnum.WOUNDS, 0); // + 1d10 via starting wounds table
        characteristicModifiers.put(CharacteristicEnum.STRENGTH_BONUS, characteristicModifiers.get(CharacteristicEnum.STRENGTH) / 10);
        characteristicModifiers.put(CharacteristicEnum.TOUGHNESS_BONUS, characteristicModifiers.get(CharacteristicEnum.TOUGHNESS) / 10);
        characteristicModifiers.put(CharacteristicEnum.MOVEMENT, 4);
        characteristicModifiers.put(CharacteristicEnum.MAGIC, 0);
        characteristicModifiers.put(CharacteristicEnum.INSTANITY_POINTS, 0);
        characteristicModifiers.put(CharacteristicEnum.FATE_POINTS, 0); // + 1d10 via starting fate points table
    }

    private void initializeSkills() {
        skills = new HashSet<>();
        skills.add(skillRepository.findByName("skill.common_knowledge.name")); // Empire
        skills.add(skillRepository.findByName("skill.gossip.name"));
        skills.add(skillRepository.findByName("skill.speak_language.name")); // Reikspiel
    }

    private void initializeTalents() {
        talents = new HashSet<>();
    }

    @Override
    public void generateCharacter(Character character) {
        // Humans get 2 random talents
        for (int i = 0; i < 2; i++) {
            int roll = (int)(Math.random() * 100) + 1;
            RandomTalentTable.getTalentForRoll(raceEnum, roll, talentRepository)
                .ifPresent(character.getTalents()::add);
        }
    }
} 