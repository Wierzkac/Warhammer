package com.warhammer.alfa.util_tables;

import com.warhammer.alfa.enums.RaceEnum;
import java.util.*;

public class StartingWoundsTable {
    private static final Map<RaceEnum, NavigableMap<Integer, Integer>> WOUNDS_TABLES = new HashMap<>();

    static {
        NavigableMap<Integer, Integer> dwarf = new TreeMap<>();
        dwarf.put(3, 11);
        dwarf.put(6, 12);
        dwarf.put(9, 13);
        dwarf.put(10, 14);
        WOUNDS_TABLES.put(RaceEnum.DWARF, dwarf);

        NavigableMap<Integer, Integer> elf = new TreeMap<>();
        elf.put(3, 9);
        elf.put(6, 10);
        elf.put(9, 11);
        elf.put(10, 12);
        WOUNDS_TABLES.put(RaceEnum.ELF, elf);

        NavigableMap<Integer, Integer> halfling = new TreeMap<>();
        halfling.put(3, 8);
        halfling.put(6, 9);
        halfling.put(9, 10);
        halfling.put(10, 11);
        WOUNDS_TABLES.put(RaceEnum.HALFLING, halfling);

        NavigableMap<Integer, Integer> human = new TreeMap<>();
        human.put(3, 10);
        human.put(6, 11);
        human.put(9, 12);
        human.put(10, 13);
        WOUNDS_TABLES.put(RaceEnum.HUMAN, human);
    }

    public static int getStartingWounds(RaceEnum race, int d10Roll) {
        NavigableMap<Integer, Integer> table = WOUNDS_TABLES.get(race);
        if (table == null) throw new IllegalArgumentException("No wounds table for race: " + race);
        return table.ceilingEntry(d10Roll).getValue();
    }
} 