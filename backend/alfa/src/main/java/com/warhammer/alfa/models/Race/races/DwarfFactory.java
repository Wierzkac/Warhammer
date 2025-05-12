package com.warhammer.alfa.models.Race.races;

import com.warhammer.alfa.enums.CharacteristicEnum;
import com.warhammer.alfa.enums.RaceEnum;
import com.warhammer.alfa.models.Race.Race;
import com.warhammer.alfa.models.Race.RaceFactory;
import com.warhammer.alfa.models.Skill.Skill;
import com.warhammer.alfa.models.Skill.SkillRepository;
import com.warhammer.alfa.models.Talent.Talent;
import com.warhammer.alfa.models.Talent.TalentRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Component
public class DwarfFactory implements RaceFactory {
    private final SkillRepository skillRepository;
    private final TalentRepository talentRepository;

    public DwarfFactory(SkillRepository skillRepository, TalentRepository talentRepository) {
        this.skillRepository = skillRepository;
        this.talentRepository = talentRepository;
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
        dwarf.setSkills(loadSkills());
        dwarf.setTalents(loadTalents());
        dwarf.setCharacteristicModifiers(loadCharacteristicModifiers());
        return dwarf;
    }

    @Override
    public Set<Skill> loadSkills() {
        Set<Skill> skills = new HashSet<>();
        skills.add(skillRepository.findByName("skill.common_knowledge.name"));
        skills.add(skillRepository.findByName("skill.speak_language.name")); // Khazalid
        skills.add(skillRepository.findByName("skill.speak_language.name")); // Reikspiel
        skills.add(skillRepository.findByName("skill.trade.name")); // Miner, Smith, or Stoneworker
        return skills;
    }

    @Override
    public Set<Talent> loadTalents() {
        Set<Talent> talents = new HashSet<>();
        talents.add(talentRepository.findByName("talent.dwarfcraft.name"));
        talents.add(talentRepository.findByName("talent.grudge_born_fury.name"));
        talents.add(talentRepository.findByName("talent.night_vision.name"));
        talents.add(talentRepository.findByName("talent.resistance_to_magic.name"));
        talents.add(talentRepository.findByName("talent.stout_hearted.name"));
        talents.add(talentRepository.findByName("talent.sturdy.name"));
        return talents;
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