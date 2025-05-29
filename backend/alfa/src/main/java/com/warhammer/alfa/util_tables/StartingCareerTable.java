package com.warhammer.alfa.util_tables;

import com.warhammer.alfa.enums.RaceEnum;
import com.warhammer.alfa.models.Career.Career;
import com.warhammer.alfa.models.Career.CareerRepository;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class StartingCareerTable {
    private final CareerRepository careerRepository;

    private final Map<RaceEnum, NavigableMap<Integer, String>> CAREER_TABLES = new HashMap<>();

    public Career getCareerForRoll(RaceEnum race, int roll) {
        NavigableMap<Integer, String> table = CAREER_TABLES.get(race);
        if (table == null) {
            return null;
        }
        Map.Entry<Integer, String> entry = table.ceilingEntry(roll);
        if (entry == null) {
            return null;
        }
        return careerRepository.findByName(entry.getValue());
    }

    StartingCareerTable(CareerRepository careerRepository) {
        this.careerRepository = careerRepository;
        
        NavigableMap<Integer, String> dwarf = new TreeMap<>();
        dwarf.put(2, "career.agitator.name");
        dwarf.put(6, "career.bodyguard.name");
        dwarf.put(10, "career.burgher.name");
        dwarf.put(11, "career.camp_follower.name");
        dwarf.put(12, "career.coachman.name");
        dwarf.put(15, "career.entertainer.name");
        dwarf.put(16, "career.hunter.name");
        dwarf.put(23, "career.jailer.name");
        dwarf.put(24, "career.marine.name");
        dwarf.put(30, "career.mercenary.name");
        dwarf.put(31, "career.militiaman.name");
        dwarf.put(40, "career.messenger.name");
        dwarf.put(46, "career.miner.name");
        dwarf.put(42, "career.noble.name");
        dwarf.put(50, "career.pit_fighter.name");
        dwarf.put(58, "career.rat_catcher.name");
        dwarf.put(63, "career.runebearer.name");
        dwarf.put(65, "career.scribe.name");
        dwarf.put(66, "career.seaman.name");
        dwarf.put(68, "career.servant.name");
        dwarf.put(72, "career.shieldbreaker.name");
        dwarf.put(74, "career.smuggler.name");
        dwarf.put(79, "career.soldier.name");
        dwarf.put(80, "career.squire.name");
        dwarf.put(81, "career.student.name");
        dwarf.put(84, "career.thief.name");
        dwarf.put(87, "career.toll_keeper.name");
        dwarf.put(88, "career.tomb_robber.name");
        dwarf.put(94, "career.tradesman.name");
        dwarf.put(98, "career.troll_slayer.name");
        dwarf.put(99, "career.watchman.name");
        CAREER_TABLES.put(RaceEnum.DWARF, dwarf);

        NavigableMap<Integer, String> elf = new TreeMap<>();
        elf.put(7, "career.apprentice_wizard.name");
        elf.put(12, "career.entertainer.name");
        elf.put(19, "career.envoy.name");
        elf.put(22, "career.fieldwarden.name");
        elf.put(27, "career.hunter.name");
        elf.put(34, "career.mercenary.name");
        elf.put(35, "career.messenger.name");
        elf.put(38, "career.militiaman.name");
        elf.put(42, "career.noble.name");
        elf.put(46, "career.outlaw.name");
        elf.put(57, "career.outrider.name");
        elf.put(63, "career.rogue.name");
        elf.put(69, "career.scribe.name");
        elf.put(75, "career.seaman.name");
        elf.put(80, "career.student.name");
        elf.put(86, "career.thief.name");
        elf.put(87, "career.tradesman.name");
        elf.put(94, "career.vagabond.name");
        elf.put(99, "career.watchman.name");
        CAREER_TABLES.put(RaceEnum.ELF, elf);

        NavigableMap<Integer, String> halfling = new TreeMap<>();
        halfling.put(3, "career.agitator.name");
        halfling.put(4, "career.barber_surgeon.name");
        halfling.put(6, "career.bounty_hunter.name");
        halfling.put(9, "career.burgher.name");
        halfling.put(12, "career.camp_follower.name");
        halfling.put(15, "career.entertainer.name");
        halfling.put(18, "career.ferryman.name");
        halfling.put(22, "career.fieldwarden.name");
        halfling.put(24, "career.grave_robber.name");
        halfling.put(27, "career.hunter.name");
        halfling.put(32, "career.mercenary.name");
        halfling.put(36, "career.messenger.name");
        halfling.put(41, "career.militiaman.name");
        halfling.put(46, "career.miner.name");
        halfling.put(48, "career.outlaw.name");
        halfling.put(55, "career.rat_catcher.name");
        halfling.put(60, "career.rogue.name");
        halfling.put(68, "career.smuggler.name");
        halfling.put(70, "career.soldier.name");
        halfling.put(72, "career.student.name");
        halfling.put(78, "career.thief.name");
        halfling.put(79, "career.toll_keeper.name");
        halfling.put(81, "career.tomb_robber.name");
        halfling.put(86, "career.tradesman.name");
        halfling.put(91, "career.vagabond.name");
        halfling.put(97, "career.watchman.name");
        CAREER_TABLES.put(RaceEnum.HALFLING, halfling);

        NavigableMap<Integer, String> human = new TreeMap<>();
        human.put(2, "career.agitator.name");
        human.put(4, "career.apprentice_wizard.name");
        human.put(5, "career.bailiff.name");
        human.put(6, "career.barber_surgeon.name");
        human.put(8, "career.boatman.name");
        human.put(10, "career.bodyguard.name");
        human.put(12, "career.bone_picker.name");
        human.put(14, "career.bounty_hunter.name");
        human.put(16, "career.burgher.name");
        human.put(18, "career.camp_follower.name");
        human.put(20, "career.charcoal_burner.name");
        human.put(22, "career.coachman.name");
        human.put(24, "career.entertainer.name");
        human.put(25, "career.estalian_diestro.name");
        human.put(26, "career.ferryman.name");
        human.put(28, "career.fisherman.name");
        human.put(30, "career.grave_robber.name");
        human.put(31, "career.hedge_wizard.name");
        human.put(33, "career.hunter.name");
        human.put(35, "career.initiate.name");
        human.put(36, "career.jailer.name");
        human.put(37, "career.kislevite_kossar.name");
        human.put(38, "career.kithband_warrior.name");
        human.put(39, "career.marine.name");
        human.put(41, "career.mercenary.name");
        human.put(42, "career.messenger.name");
        human.put(45, "career.militiaman.name");
        human.put(46, "career.miner.name");
        human.put(49, "career.noble.name");
        human.put(50, "career.norse_berserker.name");
        human.put(52, "career.outlaw.name");
        human.put(54, "career.outrider.name");
        human.put(58, "career.pit_fighter.name");
        human.put(60, "career.protagonist.name");
        human.put(62, "career.rat_catcher.name");
        human.put(64, "career.roadwarden.name");
        human.put(66, "career.rogue.name");
        human.put(68, "career.scribe.name");
        human.put(70, "career.seaman.name");
        human.put(72, "career.servant.name");
        human.put(74, "career.smuggler.name");
        human.put(76, "career.soldier.name");
        human.put(78, "career.squire.name");
        human.put(80, "career.student.name");
        human.put(82, "career.thief.name");
        human.put(84, "career.thug.name");
        human.put(86, "career.toll_keeper.name");
        human.put(88, "career.tomb_robber.name");
        human.put(90, "career.tradesman.name");
        human.put(92, "career.vagabond.name");
        human.put(94, "career.valet.name");
        human.put(96, "career.watchman.name");
        human.put(99, "career.woodsman.name");
        human.put(100, "career.zealot.name");
        CAREER_TABLES.put(RaceEnum.HUMAN, human);
    }
} 