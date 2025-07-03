package com.warhammer.alfa.models.Character;

import com.warhammer.alfa.enums.GenderEnum;
import com.warhammer.alfa.enums.RaceEnum;
import com.warhammer.alfa.models.Career.Career;
import com.warhammer.alfa.models.Dice;
import com.warhammer.alfa.util_tables.StartingCareerTable;
import org.springframework.stereotype.Service;

@Service
public class CharacterService {
    private final CharacterFactory characterFactory;
    private final CharacterMapper characterMapper;
    private final StartingCareerTable startingCareerTable;

    public CharacterService(
            CharacterFactory characterFactory,
            CharacterMapper characterMapper,
            StartingCareerTable startingCareerTable) {
        this.characterFactory = characterFactory;
        this.characterMapper = characterMapper;
        this.startingCareerTable = startingCareerTable; 
    }

    public CharacterDTO createRandomCharacter(String name, RaceEnum raceEnum, GenderEnum gender) {
        int careerRoll = Dice.roll("1k100");
        int woundsRoll = Dice.roll("1k10");
        int fateRoll = Dice.roll("1k10");
        Career startingCareer = startingCareerTable.getCareerForRoll(raceEnum, careerRoll);

        Character character = characterFactory.createCharacter(name, raceEnum, gender, startingCareer, woundsRoll, fateRoll);
        return characterMapper.toDTO(character);
    }
}
