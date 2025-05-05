package com.warhammer.alfa.UtilTables;

import com.warhammer.alfa.enums.RaceEnum;
import com.warhammer.alfa.models.Talent.Talent;
import com.warhammer.alfa.models.Talent.TalentRepository;

import java.util.*;

public class RandomTalentTable {
    private static final Map<RaceEnum, NavigableMap<Integer, String>> TALENT_TABLES = new HashMap<>();

    public static Talent getTalentForRoll(RaceEnum race, int roll, TalentRepository talentRepository) {
        NavigableMap<Integer, String> table = TALENT_TABLES.get(race);
        if (table == null) {
            return null;
        }
        Map.Entry<Integer, String> entry = table.ceilingEntry(roll);
        if (entry == null) {
            return null;
        }
        return talentRepository.findByName(entry.getValue());
    }

    static {
        NavigableMap<Integer, String> humanTable = new TreeMap<>();
        humanTable.put(4, "talent.acute_hearing.name");
        humanTable.put(9, "talent.ambidextrous.name");
        humanTable.put(13, "talent.coolheaded.name");
        humanTable.put(18, "talent.excellent_vision.name");
        humanTable.put(22, "talent.fleet_footed.name");
        humanTable.put(27, "talent.hardy.name");
        humanTable.put(31, "talent.lightning_reflexes.name");
        humanTable.put(35, "talent.luck.name");
        humanTable.put(40, "talent.marksman.name");
        humanTable.put(44, "talent.mimic.name");
        humanTable.put(49, "talent.night_vision.name");
        humanTable.put(53, "talent.resistance_to_disease.name");
        humanTable.put(57, "talent.resistance_to_magic.name");
        humanTable.put(61, "talent.resistance_to_poison.name");
        humanTable.put(66, "talent.savvy.name");
        humanTable.put(71, "talent.sixth_sense.name");
        humanTable.put(75, "talent.strong_minded.name");
        humanTable.put(79, "talent.sturdy.name");
        humanTable.put(83, "talent.suave.name");
        humanTable.put(87, "talent.super_numerate.name");
        humanTable.put(91, "talent.very_resilient.name");
        humanTable.put(95, "talent.very_strong.name");
        humanTable.put(100, "talent.warrior_born.name");
        TALENT_TABLES.put(RaceEnum.HUMAN, humanTable);

        NavigableMap<Integer, String> halflingTable = new TreeMap<>();
        halflingTable.put(5, "talent.acute_hearing.name");
        halflingTable.put(10, "talent.ambidextrous.name");
        halflingTable.put(15, "talent.coolheaded.name");
        halflingTable.put(20, "talent.excellent_vision.name");
        halflingTable.put(25, "talent.fleet_footed.name");
        halflingTable.put(29, "talent.hardy.name");
        halflingTable.put(33, "talent.lightning_reflexes.name");
        halflingTable.put(38, "talent.luck.name");
        halflingTable.put(42, "talent.marksman.name");
        halflingTable.put(47, "talent.mimic.name");
        // halflings do not have night vision
        halflingTable.put(51, "talent.resistance_to_disease.name");
        halflingTable.put(53, "talent.resistance_to_magic.name");
        halflingTable.put(57, "talent.resistance_to_poison.name");
        halflingTable.put(62, "talent.savvy.name");
        halflingTable.put(67, "talent.sixth_sense.name");
        halflingTable.put(72, "talent.strong_minded.name");
        halflingTable.put(77, "talent.sturdy.name");
        halflingTable.put(82, "talent.suave.name");
        halflingTable.put(87, "talent.super_numerate.name");
        halflingTable.put(91, "talent.very_resilient.name");
        halflingTable.put(95, "talent.very_strong.name");
        halflingTable.put(100, "talent.warrior_born.name");
        TALENT_TABLES.put(RaceEnum.HALFLING, halflingTable);
    }
} 