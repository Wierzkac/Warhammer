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
public class ElfFactory implements RaceFactory {
    private final SkillRepository skillRepository;
    private final TalentRepository talentRepository;

    public ElfFactory(SkillRepository skillRepository, TalentRepository talentRepository) {
        this.skillRepository = skillRepository;
        this.talentRepository = talentRepository;
    }

    @Override
    public Race createRace() {
        Elf elf = new Elf(
            RaceEnum.ELF,
            "race.elf.name",
            "race.elf.description",
            "race.elf.history",
            "race.elf.personality"
        );
        elf.setSkills(loadSkills());
        elf.setTalents(loadTalents());
        elf.setCharacteristicModifiers(loadCharacteristicModifiers());
        return elf;
    }

    @Override
    public Set<Skill> loadSkills() {
        Set<Skill> skills = new HashSet<>();
        skills.add(skillRepository.findByName("skill.common_knowledge.name")); // Eltharin
        skills.add(skillRepository.findByName("skill.speak_language.name")); // Eltharin
        skills.add(skillRepository.findByName("skill.perception.name"));
        return skills;
    }

    @Override
    public Set<Talent> loadTalents() {
        Set<Talent> talents = new HashSet<>();
        talents.add(talentRepository.findByName("talent.night_vision.name"));
        return talents;
    }

    @Override
    public Map<CharacteristicEnum, Integer> loadCharacteristicModifiers() {
        Map<CharacteristicEnum, Integer> modifiers = new HashMap<>();
        modifiers.put(CharacteristicEnum.WEAPON_SKILL, 30); // + 2d10
        modifiers.put(CharacteristicEnum.BALLISTIC_SKILL, 30); // + 2d10
        modifiers.put(CharacteristicEnum.STRENGTH, 20); // + 2d10
        modifiers.put(CharacteristicEnum.TOUGHNESS, 20); // + 2d10
        modifiers.put(CharacteristicEnum.AGILITY, 30); // + 2d10
        modifiers.put(CharacteristicEnum.INTELLIGENCE, 30); // + 2d10
        modifiers.put(CharacteristicEnum.WILL_POWER, 20); // + 2d10
        modifiers.put(CharacteristicEnum.FELLOWSHIP, 20); // + 2d10
        modifiers.put(CharacteristicEnum.ATTACKS, 1);
        modifiers.put(CharacteristicEnum.WOUNDS, 0); // + 1d10 via starting wounds table
        modifiers.put(CharacteristicEnum.STRENGTH_BONUS, modifiers.get(CharacteristicEnum.STRENGTH) / 10);
        modifiers.put(CharacteristicEnum.TOUGHNESS_BONUS, modifiers.get(CharacteristicEnum.TOUGHNESS) / 10);
        modifiers.put(CharacteristicEnum.MOVEMENT, 5);
        modifiers.put(CharacteristicEnum.MAGIC, 0);
        modifiers.put(CharacteristicEnum.INSTANITY_POINTS, 0);
        modifiers.put(CharacteristicEnum.FATE_POINTS, 0); // + 1d10 via starting fate points table
        return modifiers;
    }
} 