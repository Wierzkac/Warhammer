package com.warhammer.alfa.models.Character;

import com.warhammer.alfa.UtilTables.RandomTalentTable;
import com.warhammer.alfa.UtilTables.StartingFatePointsTable;
import com.warhammer.alfa.UtilTables.StartingWoundsTable;
import com.warhammer.alfa.enums.CharacteristicEnum;
import com.warhammer.alfa.enums.GenderEnum;
import com.warhammer.alfa.models.Career.Career;
import com.warhammer.alfa.models.Race.Race;
import com.warhammer.alfa.models.Skill.Skill;
import com.warhammer.alfa.models.Talent.Talent;
import com.warhammer.alfa.models.Talent.TalentRepository;
import lombok.Data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Data
public class Character {
    private String name;
    private Race race;
    private GenderEnum gender;
    private Career currentCareer;
    private Map<CharacteristicEnum, Integer> characteristics;
    private TalentRepository talentRepository;
    private Set<Talent> talents;
    private Set<Skill> skills;

    public Character(String name, Race race, GenderEnum gender, Career currentCareer, int woundsd10Roll, int fated10Roll, TalentRepository talentRepository) {
        this.name = name;
        this.race = race;
        this.gender = gender;
        this.currentCareer = currentCareer;
        this.characteristics = new HashMap<>(race.getCharacteristicModifiers());
        this.skills = new HashSet<Skill>(); // Initialize empty skills set
        this.talents = new HashSet<Talent>(); // Initialize empty talents set
        this.talentRepository = talentRepository;
        if (race.getSkills() != null) {
            this.skills.addAll(race.getSkills());
        }
        if (race.getTalents() != null) {
            this.talents.addAll(race.getTalents()); 
        }
        initializeWoundsAndFatePoints(woundsd10Roll, fated10Roll);
        initializeRandomTalents();
    }

    private void initializeWoundsAndFatePoints(int woundsd10Roll, int fated10Roll) {
        characteristics.put(CharacteristicEnum.WOUNDS, StartingWoundsTable.getStartingWounds(race.getRaceEnum(), woundsd10Roll));
        characteristics.put(CharacteristicEnum.FATE_POINTS, StartingFatePointsTable.getStartingFatePoints(race.getRaceEnum(), fated10Roll));
    }

    private void initializeRandomTalents() {
        // Race-specific talent initialization is now handled in each race's generateCharacter method
        race.generateCharacter(this);
    }
}
