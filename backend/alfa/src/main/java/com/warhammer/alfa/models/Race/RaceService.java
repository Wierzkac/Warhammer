package com.warhammer.alfa.models.Race;

import com.warhammer.alfa.enums.CharacteristicEnum;
import com.warhammer.alfa.enums.RaceEnum;
import com.warhammer.alfa.models.Skill.Skill;
import com.warhammer.alfa.models.Talent.Talent;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class RaceService {
    
    private final RaceFactoryProvider raceFactoryProvider;

    RaceService(RaceFactoryProvider raceFactoryProvider) {
        this.raceFactoryProvider = raceFactoryProvider;
    }
    
    public Map<CharacteristicEnum, Integer> getCharacteristicModifiers(RaceEnum raceEnum) {
        Race race = getRaceInstance(raceEnum);
        return new HashMap<>(race.getCharacteristicModifiers());
    }

    public Set<Skill> getStartingSkills(RaceEnum raceEnum) {
        Race race = getRaceInstance(raceEnum);
        return race.getSkills();
    }

    public Set<Talent> getStartingTalents(RaceEnum raceEnum) {
        Race race = getRaceInstance(raceEnum);
        return race.getTalents();
    }

    private Race getRaceInstance(RaceEnum raceEnum) {
        return raceFactoryProvider.createRace(raceEnum);
    }
} 