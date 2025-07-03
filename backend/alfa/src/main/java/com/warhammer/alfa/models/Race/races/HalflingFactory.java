package com.warhammer.alfa.models.Race.races;

import com.warhammer.alfa.enums.CharacteristicEnum;
import com.warhammer.alfa.enums.RaceEnum;
import com.warhammer.alfa.models.Race.Race;
import com.warhammer.alfa.models.Race.RaceFactory;
import com.warhammer.alfa.models.Skill.SkillRepository;
import com.warhammer.alfa.models.Talent.TalentRepository;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class HalflingFactory extends RaceFactory {

    private final List<String> skillNames;
    private final List<String> talentNames;

    public HalflingFactory(SkillRepository skillRepository, TalentRepository talentRepository) {
        super(skillRepository, talentRepository);
        this.skillNames = new ArrayList<>(Arrays.asList(
                "skill.common_knowledge.name", // The Moot
                "skill.gossip.name",
                "skill.haggle.name"));
        this.talentNames = new ArrayList<>(Arrays.asList(
                "talent.luck.name",
                "talent.resistance_to_magic.name"));
    }

    @Override
    public Race createRace() {
        Halfling halfling = new Halfling(
            RaceEnum.HALFLING,
            "race.halfling.name",
            "race.halfling.description",
            "race.halfling.history",
            "race.halfling.personality"
        );
        halfling.setSkills(loadSkills(skillNames))
            .setTalents(loadTalents(talentNames))
            .setCharacteristicModifiers(loadCharacteristicModifiers());
        return halfling;
    }

    @Override
    public Map<CharacteristicEnum, Integer> loadCharacteristicModifiers() {
        Map<CharacteristicEnum, Integer> modifiers = new HashMap<>();
        modifiers.put(CharacteristicEnum.WEAPON_SKILL, 20); // + 2d10
        modifiers.put(CharacteristicEnum.BALLISTIC_SKILL, 30); // + 2d10
        modifiers.put(CharacteristicEnum.STRENGTH, 10); // + 2d10
        modifiers.put(CharacteristicEnum.TOUGHNESS, 10); // + 2d10
        modifiers.put(CharacteristicEnum.AGILITY, 30); // + 2d10
        modifiers.put(CharacteristicEnum.INTELLIGENCE, 20); // + 2d10
        modifiers.put(CharacteristicEnum.WILL_POWER, 20); // + 2d10
        modifiers.put(CharacteristicEnum.FELLOWSHIP, 30); // + 2d10
        modifiers.put(CharacteristicEnum.ATTACKS, 1);
        modifiers.put(CharacteristicEnum.WOUNDS, 0); // + 1d10 via starting wounds table
        modifiers.put(CharacteristicEnum.STRENGTH_BONUS, modifiers.get(CharacteristicEnum.STRENGTH) / 10);
        modifiers.put(CharacteristicEnum.TOUGHNESS_BONUS, modifiers.get(CharacteristicEnum.TOUGHNESS) / 10);
        modifiers.put(CharacteristicEnum.MOVEMENT, 4);
        modifiers.put(CharacteristicEnum.MAGIC, 0);
        modifiers.put(CharacteristicEnum.INSTANITY_POINTS, 0);
        modifiers.put(CharacteristicEnum.FATE_POINTS, 0); // + 1d10 via starting fate points table
        return modifiers;
    }
} 