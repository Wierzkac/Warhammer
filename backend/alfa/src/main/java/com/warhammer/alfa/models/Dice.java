package com.warhammer.alfa.models;

import java.util.Random;

public class Dice {
    private static final Random random= new Random();
    private static final String invalidDiceFormatErrorMessage = "Invalid dice format. Use {numberOfRolls}k{valueOnTheDice}";
    private static final String onlyPositiveErrorMessage = "Number of rolls and value on the dice must be positive integers.";

    public static int roll(String version) {
        String[] parts;
        if (version.contains("k"))
            parts = version.split("k");
        else if (version.contains("d"))
            parts = version.split("d");
        else
            throw new IllegalArgumentException(invalidDiceFormatErrorMessage);
        if (parts.length != 2) {
            // Handling wrong format
            throw new IllegalArgumentException(invalidDiceFormatErrorMessage);
        }
        int numberOfRolls = Integer.parseInt(parts[0]);
        int valueOnTheDice = Integer.parseInt(parts[1]);

        if (numberOfRolls <= 0 || valueOnTheDice <= 0) {
            // Handling numbers below 0
            throw new IllegalArgumentException(onlyPositiveErrorMessage);
        }

        int result = 0;
        for (int i = 0; i < numberOfRolls; i++) {
            result += random.nextInt(valueOnTheDice) + 1;
        }
        return result;
    }
}
