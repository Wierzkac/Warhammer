package com.warhammer.alfa.models.Character;

import com.warhammer.alfa.enums.GenderEnum;
import com.warhammer.alfa.enums.RaceEnum;
import com.warhammer.alfa.models.Career.Career;
import com.warhammer.alfa.models.Career.CareerRepository;
import com.warhammer.alfa.models.Dice;
import com.warhammer.alfa.models.Race.Race;
import com.warhammer.alfa.models.Race.RaceFactoryProvider;
import com.warhammer.alfa.models.Talent.TalentRepository;
import com.warhammer.alfa.util_tables.StartingCareerTable;
import org.springframework.stereotype.Service;

@Service
public class CharacterService {
    private final RaceFactoryProvider raceFactoryProvider;
    private final CareerRepository careerRepository;
    private final TalentRepository talentRepository;
    private final CharacterMapper characterMapper;

    public CharacterService(
            RaceFactoryProvider raceFactoryProvider,
            CareerRepository careerRepository,
            TalentRepository talentRepository,
            CharacterMapper characterMapper) {
        this.raceFactoryProvider = raceFactoryProvider;
        this.careerRepository = careerRepository;
        this.talentRepository = talentRepository;
        this.characterMapper = characterMapper;
    }

    public CharacterDTO createRandomCharacter(String name, RaceEnum raceEnum, GenderEnum gender) {
        Race race = raceFactoryProvider.createRace(raceEnum);
        int careerRoll = Dice.roll("1k100");
        int woundsRoll = Dice.roll("1k10");
        int fateRoll = Dice.roll("1k10");
        Career startingCareer = StartingCareerTable.getCareerForRoll(raceEnum, careerRoll, careerRepository);

        Character character = new Character(name, race, gender, startingCareer, woundsRoll, fateRoll, talentRepository);
        return characterMapper.toDTO(character);
    }
}
