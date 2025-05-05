package com.warhammer.alfa.models.Race;

import com.warhammer.alfa.enums.CharacteristicEnum;
import com.warhammer.alfa.enums.RaceEnum;
import com.warhammer.alfa.models.Character.Character;
import com.warhammer.alfa.models.Skill.Skill;
import com.warhammer.alfa.models.Skill.SkillRepository;
import com.warhammer.alfa.models.Talent.Talent;
import com.warhammer.alfa.models.Talent.TalentRepository;

import java.util.Map;
import java.util.Set;

public abstract class Race {
    protected RaceEnum raceEnum;
    protected String name;
    protected String description;
    protected String background;
    protected String roleplayingHints;
    protected Set<Skill> skills;
    protected Set<Talent> talents;
    protected Map<CharacteristicEnum, Integer> characteristicModifiers;
    protected final SkillRepository skillRepository;
    protected final TalentRepository talentRepository;

    protected Race(RaceEnum raceEnum, String name, String description, String background, String roleplayingHints, 
                  SkillRepository skillRepository, TalentRepository talentRepository) {
        this.raceEnum = raceEnum;
        this.name = name;
        this.description = description;
        this.background = background;
        this.roleplayingHints = roleplayingHints;
        this.skillRepository = skillRepository;
        this.talentRepository = talentRepository;
    }

    // Abstract method to be implemented by each race
    public abstract void generateCharacter(Character character);

    public RaceEnum getRaceEnum() {
        return raceEnum;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getBackground() {
        return background;
    }

    public String getRoleplayingHints() {
        return roleplayingHints;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public Set<Talent> getTalents() {
        return talents;
    }

    public Map<CharacteristicEnum, Integer> getCharacteristicModifiers() {
        return characteristicModifiers;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    public void setTalents(Set<Talent> talents) {
        this.talents = talents;
    }

    public void setCharacteristicModifiers(Map<CharacteristicEnum, Integer> characteristicModifiers) {
        this.characteristicModifiers = characteristicModifiers;
    }
} 