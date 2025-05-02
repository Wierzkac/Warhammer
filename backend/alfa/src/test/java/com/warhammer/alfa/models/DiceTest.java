package com.warhammer.alfa.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiceTest {

    @Test
    void testValidInput() {
        Dice dice = new Dice();

        int result;
        result = dice.roll("1k10");
        assertTrue(1 <= result && result <= 10, "Result should be between 1 and 10");
        result = dice.roll("1k6");
        assertTrue(1 <= result && result <= 6, "Result should be between 1 and 6");
        result = dice.roll("2k4");
        assertTrue(2 <= result && result <= 8, "Result should be between 2 and 8");
        result = dice.roll("3k5");
        assertTrue(3 <= result && result <= 15, "Result should be between 3 and 15");
    }

    @Test
    void testInvalidInput() {
        Dice dice = new Dice();
        assertThrows(IllegalArgumentException.class, () -> dice.roll(""), "Empty input should throw exception");
        assertThrows(IllegalArgumentException.class, () -> dice.roll("k"), "Invalid format should throw exception");
        assertThrows(IllegalArgumentException.class, () -> dice.roll("3k0"),
                "Zero value on dice should throw exception");
        assertThrows(IllegalArgumentException.class, () -> dice.roll("-2k6"),
                "Negative number of rolls should throw exception");
    }
}