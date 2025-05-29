package com.warhammer.alfa.models.Race;

import com.warhammer.alfa.models.Skill.Skill;
import com.warhammer.alfa.models.Skill.SkillRepository;
import com.warhammer.alfa.models.Talent.Talent;
import com.warhammer.alfa.enums.CharacteristicEnum;
import com.warhammer.alfa.models.Talent.TalentRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class RaceFactory {

    private final SkillRepository skillRepository;
    private final TalentRepository talentRepository;

    protected RaceFactory(SkillRepository skillRepository, TalentRepository talentRepository) {
        this.skillRepository = skillRepository;
        this.talentRepository = talentRepository;
    }

    abstract protected Race createRace();
    final protected Set<Skill> loadSkills(List<String> skillNames) {
        return new HashSet<>(skillRepository.findByNameIn(skillNames));
    }
    final protected Set<Talent> loadTalents(List<String> talentNames) {
        return new HashSet<>(talentRepository.findByNameIn(talentNames));
    }

    protected abstract Map<CharacteristicEnum, Integer> loadCharacteristicModifiers();
} 