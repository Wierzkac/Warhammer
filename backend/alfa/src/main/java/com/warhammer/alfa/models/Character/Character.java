package com.warhammer.alfa.models.Character;

import com.warhammer.alfa.util_tables.StartingFatePointsTable;
import com.warhammer.alfa.util_tables.StartingWoundsTable;

import jakarta.persistence.*;

import com.warhammer.alfa.enums.CharacteristicEnum;
import com.warhammer.alfa.enums.GenderEnum;
import com.warhammer.alfa.models.Career.Career;
import com.warhammer.alfa.models.Race.Race;
import com.warhammer.alfa.models.Skill.Skill;
import com.warhammer.alfa.models.Talent.Talent;
import com.warhammer.alfa.models.User.User;
import lombok.Data;

import java.util.*;

@Entity
@Table(name = "characters")
@Data
public class Character {
    private String name;
    private Race race;
    private GenderEnum gender;
    private Career currentCareer;
    private Map<CharacteristicEnum, Integer> characteristics;
    private Set<Talent> talents = new HashSet<Talent>();
    private Set<Skill> skills = new HashSet<Skill>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Character(String name, Race race, GenderEnum gender, Career currentCareer, int woundsd10Roll, int fated10Roll) {
        this.name = name;
        this.race = race;
        this.gender = gender;
        this.currentCareer = currentCareer;
        this.characteristics = new HashMap<>(race.getCharacteristicModifiers());
        if (race.getSkills() != null) {
            this.skills.addAll(race.getSkills());
        }
        if (race.getTalents() != null) {
            this.talents.addAll(race.getTalents()); 
        }
        initializeWoundsAndFatePoints(woundsd10Roll, fated10Roll);
    }

    private void initializeWoundsAndFatePoints(int woundsd10Roll, int fated10Roll) {
        characteristics.put(CharacteristicEnum.WOUNDS, StartingWoundsTable.getStartingWounds(race.getRaceEnum(), woundsd10Roll));
        characteristics.put(CharacteristicEnum.FATE_POINTS, StartingFatePointsTable.getStartingFatePoints(race.getRaceEnum(), fated10Roll));
    }
}
