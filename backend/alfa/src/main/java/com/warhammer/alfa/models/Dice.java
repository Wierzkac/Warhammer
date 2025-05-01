package com.warhammer.alfa.models;

import java.util.Random;

public class Dice {
    private Random random;

    public Dice() {
        random = new Random();
    }

    public int roll(String version) {
        String[] parts = version.split("k");
        if (parts.length != 2) {
            // Handling wrong format
            throw new IllegalArgumentException("Invalid dice format. Use {numberOfRolls}k{valueOnTheDice}");
        }
        int numberOfRolls = Integer.parseInt(parts[0]);
        int valueOnTheDice = Integer.parseInt(parts[1]);

        if (numberOfRolls <= 0 || valueOnTheDice <= 0) {
            // Handling numbers below 0
            throw new IllegalArgumentException("Number of rolls and value on the dice must be positive integers.");
        }

        int result = 0;
        for (int i = 0; i < numberOfRolls; i++) {
            result += random.nextInt(valueOnTheDice) + 1; // Adding 1 because Random.nextInt returns [0, value)
        }
        return result;
    }
}
