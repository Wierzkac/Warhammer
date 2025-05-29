package com.warhammer.alfa.models.Character;

import com.warhammer.alfa.enums.GenderEnum;
import com.warhammer.alfa.enums.RaceEnum;
import com.warhammer.alfa.models.Career.Career;
import com.warhammer.alfa.models.Dice;
import com.warhammer.alfa.models.Race.Race;
import com.warhammer.alfa.models.Race.RaceFactoryProvider;
import com.warhammer.alfa.util_tables.StartingCareerTable;
import org.springframework.stereotype.Service;

@Service
public class CharacterService {
    private final RaceFactoryProvider raceFactoryProvider;
    private final CharacterMapper characterMapper;
    private final StartingCareerTable startingCareerTable;

    public CharacterService(
            RaceFactoryProvider raceFactoryProvider,
            CharacterMapper characterMapper,
            StartingCareerTable startingCareerTable) {
        this.raceFactoryProvider = raceFactoryProvider;
        this.characterMapper = characterMapper;
        this.startingCareerTable = startingCareerTable; 
    }

    public CharacterDTO createRandomCharacter(String name, RaceEnum raceEnum, GenderEnum gender) {
        Race race = raceFactoryProvider.createRace(raceEnum);
        int careerRoll = Dice.roll("1k100");
        int woundsRoll = Dice.roll("1k10");
        int fateRoll = Dice.roll("1k10");
        Career startingCareer = startingCareerTable.getCareerForRoll(raceEnum, careerRoll);

        Character character = new Character(name, race, gender, startingCareer, woundsRoll, fateRoll);
        return characterMapper.toDTO(character);
    }
}
