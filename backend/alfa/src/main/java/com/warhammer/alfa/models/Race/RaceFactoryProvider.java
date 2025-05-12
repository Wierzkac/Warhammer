package com.warhammer.alfa.models.Race;

import com.warhammer.alfa.enums.RaceEnum;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class RaceFactoryProvider {
    private final Map<RaceEnum, RaceFactory> factories;

    public RaceFactoryProvider(List<RaceFactory> raceFactories) {
        this.factories = raceFactories.stream()
            .collect(Collectors.toMap(
                factory -> factory.createRace().getRaceEnum(),
                Function.identity()
            ));
    }

    public Race createRace(RaceEnum raceEnum) {
        RaceFactory factory = factories.get(raceEnum);
        if (factory == null) {
            throw new IllegalArgumentException("No factory found for race: " + raceEnum);
        }
        return factory.createRace();
    }
} 