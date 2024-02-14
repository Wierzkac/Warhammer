package com.warhammer.alfa.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class KostkaTest {

    @Test
    void testValidInput() {
        Kostka dice = new Kostka();
        assertEquals(9, dice.roll("1k10"), "Result should be between 1 and 10");
        assertEquals(5, dice.roll("1k6"), "Result should be between 1 and 6");
        assertEquals(7, dice.roll("2k4"), "Result should be between 2 and 8");
        assertEquals(15, dice.roll("3k5"), "Result should be between 3 and 15");
    }

    @Test
    void testInvalidInput() {
        Kostka dice = new Kostka();
        assertThrows(IllegalArgumentException.class, () -> dice.roll(""), "Empty input should throw exception");
        assertThrows(IllegalArgumentException.class, () -> dice.roll("k"), "Invalid format should throw exception");
        assertThrows(IllegalArgumentException.class, () -> dice.roll("3k0"),
                "Zero value on dice should throw exception");
        assertThrows(IllegalArgumentException.class, () -> dice.roll("-2k6"),
                "Negative number of rolls should throw exception");
    }
}