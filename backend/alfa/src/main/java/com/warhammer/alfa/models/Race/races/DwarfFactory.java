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
public class DwarfFactory extends RaceFactory {

    private final List<String> skillNames;
    private final List<String> talentNames;

    public DwarfFactory(SkillRepository skillRepository, TalentRepository talentRepository) {
        super(skillRepository, talentRepository);
        this.skillNames = new ArrayList<>(Arrays.asList(
                "skill.common_knowledge.name",
                "skill.speak_language.name",  // Khazalid
                "skill.speak_language.name",  // Reikspiel
                "skill.trade.name")); // Miner, Smith, or Stoneworker
        this.talentNames = new ArrayList<>(Arrays.asList(
                "talent.dwarfcraft.name",
                "talent.grudge_born_fury.name",
                "talent.night_vision.name",
                "talent.resistance_to_magic.name",
                "talent.stout_hearted.name",
                "talent.sturdy.name"));
    }

    @Override
    public Race createRace() {
        Dwarf dwarf = new Dwarf(
            RaceEnum.DWARF,
            "Dwarf",
            "Dwarfs are a proud and ancient race, known for their craftsmanship and resilience.",
            "Dwarfs have a long and storied history in the Old World.",
            "Dwarfs are stubborn, honorable, and value tradition."
        );
        dwarf.setSkills(loadSkills(skillNames))
            .setTalents(loadTalents(talentNames))
            .setCharacteristicModifiers(loadCharacteristicModifiers());
        return dwarf;
    }

    @Override
    public Map<CharacteristicEnum, Integer> loadCharacteristicModifiers() {
        Map<CharacteristicEnum, Integer> characteristicModifiers = new HashMap<>();
        characteristicModifiers.put(CharacteristicEnum.WEAPON_SKILL, 30);
        characteristicModifiers.put(CharacteristicEnum.BALLISTIC_SKILL, 20);
        characteristicModifiers.put(CharacteristicEnum.STRENGTH, 20);
        characteristicModifiers.put(CharacteristicEnum.TOUGHNESS, 30);
        characteristicModifiers.put(CharacteristicEnum.AGILITY, 10);
        characteristicModifiers.put(CharacteristicEnum.INTELLIGENCE, 20);
        characteristicModifiers.put(CharacteristicEnum.WILL_POWER, 20);
        characteristicModifiers.put(CharacteristicEnum.FELLOWSHIP, 10);
        characteristicModifiers.put(CharacteristicEnum.ATTACKS, 1);
        characteristicModifiers.put(CharacteristicEnum.WOUNDS, 0);
        characteristicModifiers.put(CharacteristicEnum.STRENGTH_BONUS, characteristicModifiers.get(CharacteristicEnum.STRENGTH) / 10);
        characteristicModifiers.put(CharacteristicEnum.TOUGHNESS_BONUS, characteristicModifiers.get(CharacteristicEnum.TOUGHNESS) / 10);
        characteristicModifiers.put(CharacteristicEnum.MOVEMENT, 3);
        characteristicModifiers.put(CharacteristicEnum.MAGIC, 0);
        characteristicModifiers.put(CharacteristicEnum.INSTANITY_POINTS, 0);
        characteristicModifiers.put(CharacteristicEnum.FATE_POINTS, 0);
        return characteristicModifiers;
    }
} 