package com.warhammer.alfa.util_tables;

import com.warhammer.alfa.enums.RaceEnum;
import java.util.*;

public class StartingFatePointsTable {
    private static final Map<RaceEnum, NavigableMap<Integer, Integer>> FATE_TABLES = new HashMap<>();

    static {
        NavigableMap<Integer, Integer> dwarf = new TreeMap<>();
        dwarf.put(4, 1);
        dwarf.put(7, 2);
        dwarf.put(10, 3);
        FATE_TABLES.put(RaceEnum.DWARF, dwarf);

        NavigableMap<Integer, Integer> elf = new TreeMap<>();
        elf.put(4, 1);
        elf.put(7, 2);
        elf.put(10, 2);
        FATE_TABLES.put(RaceEnum.ELF, elf);

        NavigableMap<Integer, Integer> halfling = new TreeMap<>();
        halfling.put(4, 2);
        halfling.put(7, 2);
        halfling.put(10, 3);
        FATE_TABLES.put(RaceEnum.HALFLING, halfling);

        NavigableMap<Integer, Integer> human = new TreeMap<>();
        human.put(4, 2);
        human.put(7, 3);
        human.put(10, 3);
        FATE_TABLES.put(RaceEnum.HUMAN, human);
    }

    public static int getStartingFatePoints(RaceEnum race, int d10Roll) {
        NavigableMap<Integer, Integer> table = FATE_TABLES.get(race);
        if (table == null) throw new IllegalArgumentException("No fate points table for race: " + race);
        return table.ceilingEntry(d10Roll).getValue();
    }
} 