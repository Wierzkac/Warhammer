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
public class HumanFactory extends RaceFactory {

    private final List<String> skillNames;
    private final List<String> talentNames;

    public HumanFactory(SkillRepository skillRepository, TalentRepository talentRepository) {
        super(skillRepository, talentRepository);
        this.skillNames = new ArrayList<>(Arrays.asList(
                "skill.common_knowledge.name", // Empire
                "skill.gossip.name",
                "skill.speak_language.name")); // Reikspiel
        this.talentNames = new ArrayList<>();
    }

    @Override
    public Race createRace() {
        Human human = new Human(
            RaceEnum.HUMAN,
            "race.human.name",
            "race.human.description",
            "race.human.history",
            "race.human.personality"
        );
        human.setSkills(loadSkills(skillNames));
        human.setTalents(loadTalents(talentNames));
        human.setCharacteristicModifiers(loadCharacteristicModifiers());
        return human;
    }

    @Override
    public Map<CharacteristicEnum, Integer> loadCharacteristicModifiers() {
        Map<CharacteristicEnum, Integer> modifiers = new HashMap<>();
        modifiers.put(CharacteristicEnum.WEAPON_SKILL, 20); // + 2d10
        modifiers.put(CharacteristicEnum.BALLISTIC_SKILL, 20); // + 2d10
        modifiers.put(CharacteristicEnum.STRENGTH, 20); // + 2d10
        modifiers.put(CharacteristicEnum.TOUGHNESS, 20); // + 2d10
        modifiers.put(CharacteristicEnum.AGILITY, 20); // + 2d10
        modifiers.put(CharacteristicEnum.INTELLIGENCE, 20); // + 2d10
        modifiers.put(CharacteristicEnum.WILL_POWER, 20); // + 2d10
        modifiers.put(CharacteristicEnum.FELLOWSHIP, 20); // + 2d10
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