package com.warhammer.alfa.models.Character;

import com.warhammer.alfa.enums.CharacteristicEnum;
import com.warhammer.alfa.enums.GenderEnum;
import com.warhammer.alfa.enums.RaceEnum;
import com.warhammer.alfa.models.Career.Career;
import com.warhammer.alfa.models.Race.RaceService;
import com.warhammer.alfa.util_tables.StartingFatePointsTable;
import com.warhammer.alfa.util_tables.StartingWoundsTable;

import org.springframework.stereotype.Component;

@Component
public class CharacterFactory {
    
    private final RaceService raceService;

    public CharacterFactory(RaceService raceService) {
        this.raceService = raceService;
    }

    public Character createCharacter(String name, RaceEnum race, GenderEnum gender, 
                                  Career currentCareer, int woundsd10Roll, int fated10Roll) {
        Character character = new Character();
        character.setName(name);
        character.setRace(race);
        character.setGender(gender);
        character.setCurrentCareer(currentCareer);

        // Initialize characteristics from race modifiers
        character.getCharacteristics().putAll(raceService.getCharacteristicModifiers(race));

        // Add race-specific skills and talents
        var startingSkills = raceService.getStartingSkills(race);
        if (startingSkills != null) {
            character.getSkills().addAll(startingSkills);
        }

        var startingTalents = raceService.getStartingTalents(race);
        if (startingTalents != null) {
            character.getTalents().addAll(startingTalents);
        }

        // Initialize wounds and fate points
        character.getCharacteristics().put(
            CharacteristicEnum.WOUNDS, 
            StartingWoundsTable.getStartingWounds(race, woundsd10Roll)
        );
        character.getCharacteristics().put(
            CharacteristicEnum.FATE_POINTS, 
            StartingFatePointsTable.getStartingFatePoints(race, fated10Roll)
        );

        return character;
    }
} 