package com.warhammer.alfa.models;

import java.util.*;

import org.springframework.web.bind.annotation.RestController;

import com.warhammer.alfa.enums.*;
import com.warhammer.alfa.models.Career.Career;
import com.warhammer.alfa.models.Career.CareerRepository;
import com.warhammer.alfa.models.Skill.*;
import com.warhammer.alfa.models.Talent.*;

import jakarta.annotation.PostConstruct;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("populate")
public class PopiulateTables {
    private final TalentRepository talentRepository;
    private final SkillRepository skillRepository;
    private final CareerRepository careerRepository;

    public PopiulateTables(TalentRepository talentRepository, SkillRepository skillRepository, CareerRepository careerRepository) {
        this.talentRepository = talentRepository;
        this.skillRepository = skillRepository;
        this.careerRepository = careerRepository;
    }

    @GetMapping("/talentsAndSkills")
    public void initTalents() {

        long skillCount = skillRepository.count();
        if (skillCount != 0) return;

        // Create talents
        List<Talent> talents = new ArrayList<Talent>();
        Talent acute_hearing = new Talent("talent.acute_hearing.name", "talent.acute_hearing.description"); talents.add(acute_hearing);
        Talent aethyric_attunement = new Talent("talent.aethyric_attunement.name", "talent.aethyric_attunement.description"); talents.add(aethyric_attunement);
        Talent alley_cat = new Talent("talent.alley_cat.name", "talent.alley_cat.description"); talents.add(alley_cat);
        Talent ambidextrous = new Talent("talent.ambidextrous.name", "talent.ambidextrous.description"); talents.add(ambidextrous);
        Talent arcane_lore = new Talent("talent.arcane_lore.name", "talent.arcane_lore.description"); talents.add(arcane_lore);
        Talent armored_casting = new Talent("talent.armored_casting.name", "talent.armored_casting.description"); talents.add(armored_casting);
        Talent artistic = new Talent("talent.artistic.name", "talent.artistic.description"); talents.add(artistic);
        Talent contortionist = new Talent("talent.contortionist.name", "talent.contortionist.description"); talents.add(contortionist);
        Talent coolheader = new Talent("talent.coolheader.name", "talent.coolheader.description"); talents.add(coolheader);
        Talent dark_lore = new Talent("talent.dark_lore.name", "talent.dark_lore.description"); talents.add(dark_lore);
        Talent dark_magic = new Talent("talent.dark_magic.name", "talent.dark_magic.description"); talents.add(dark_magic);
        Talent dealmaker = new Talent("talent.dealmaker.name", "talent.dealmaker.description"); talents.add(dealmaker);
        Talent disarm = new Talent("talent.disarm.name", "talent.disarm.description"); talents.add(disarm);
        Talent divine_lore = new Talent("talent.divine_lore.name", "talent.divine_lore.description"); talents.add(divine_lore);
        Talent dwarfcraft = new Talent("talent.dwarfcraft.name", "talent.dwarfcraft.description"); talents.add(dwarfcraft);
        Talent etiquette = new Talent("talent.etiquette.name", "talent.etiquette.description"); talents.add(etiquette);
        Talent excellent_vision = new Talent("talent.excellent_vision.name", "talent.excellent_vision.description"); talents.add(excellent_vision);
        Talent fast_hands = new Talent("talent.fast_hands.name", "talent.fast_hands.description"); talents.add(fast_hands);
        Talent fearless = new Talent("talent.fearless.name", "talent.fearless.description"); talents.add(fearless);
        Talent flee = new Talent("talent.flee.name", "talent.flee.description"); talents.add(flee);
        Talent fleet_footed = new Talent("talent.fleet_footed.name", "talent.fleet_footed.description"); talents.add(fleet_footed);
        Talent flier = new Talent("talent.flier.name", "talent.flier.description"); talents.add(flier);
        Talent frenzy = new Talent("talent.frenzy.name", "talent.frenzy.description"); talents.add(frenzy);
        Talent frightening = new Talent("talent.frightening.name", "talent.frightening.description"); talents.add(frightening);
        Talent grudge_born_fury = new Talent("talent.grudge_born_fury.name", "talent.grudge_born_fury.description"); talents.add(grudge_born_fury);
        Talent hardy = new Talent("talent.hardy.name", "talent.hardy.description"); talents.add(hardy);
        Talent hedge_magic = new Talent("talent.hedge_magic.name", "talent.hedge_magic.description"); talents.add(hedge_magic);
        Talent hoverer = new Talent("talent.hoverer.name", "talent.hoverer.description"); talents.add(hoverer);
        Talent keen_senses = new Talent("talent.keen_senses.name", "talent.keen_senses.description"); talents.add(keen_senses);
        Talent lesser_magic = new Talent("talent.lesser_magic.name", "talent.lesser_magic.description"); talents.add(lesser_magic);
        Talent lightning_parry = new Talent("talent.lightning_parry.name", "talent.lightning_parry.description"); talents.add(lightning_parry);
        Talent lightning_reflexes = new Talent("talent.lightning_reflexes.name", "talent.lightning_reflexes.description"); talents.add(lightning_reflexes);
        Talent linguistics = new Talent("talent.linguistics.name", "talent.linguistics.description"); talents.add(linguistics);
        Talent luck = new Talent("talent.luck.name", "talent.luck.description"); talents.add(luck);
        Talent marksman = new Talent("talent.marksman.name", "talent.marksman.description"); talents.add(marksman);
        Talent master_gunner = new Talent("talent.master_gunner.name", "talent.master_gunner.description"); talents.add(master_gunner);
        Talent master_orator = new Talent("talent.master_orator.name", "talent.master_orator.description"); talents.add(master_orator);
        Talent meditation = new Talent("talent.meditation.name", "talent.meditation.description"); talents.add(meditation);
        Talent menacing = new Talent("talent.menacing.name", "talent.menacing.description"); talents.add(menacing);
        Talent mighty_missle = new Talent("talent.mighty_missle.name", "talent.mighty_missle.description"); talents.add(mighty_missle);
        Talent mighty_shot = new Talent("talent.mighty_shot.name", "talent.mighty_shot.description"); talents.add(mighty_shot);
        Talent mimic = new Talent("talent.mimic.name", "talent.mimic.description"); talents.add(mimic);
        Talent natural_weapons = new Talent("talent.natural_weapons.name", "talent.natural_weapons.description"); talents.add(natural_weapons);
        Talent night_vision = new Talent("talent.night_vision.name", "talent.night_vision.description"); talents.add(night_vision);
        Talent orientation = new Talent("talent.orientation.name", "talent.orientation.description"); talents.add(orientation);
        Talent petty_magic = new Talent("talent.petty_magic.name", "talent.petty_magic.description"); talents.add(petty_magic);
        Talent public_speaking = new Talent("talent.public_speaking.name", "talent.public_speaking.description"); talents.add(public_speaking);
        Talent quick_draw = new Talent("talent.quick_draw.name", "talent.quick_draw.description"); talents.add(quick_draw);
        Talent rapid_reload = new Talent("talent.rapid_reload.name", "talent.rapid_reload.description"); talents.add(rapid_reload);
        Talent resistance_to_chaos = new Talent("talent.resistance_to_chaos.name", "talent.resistance_to_chaos.description"); talents.add(resistance_to_chaos);
        Talent resistance_to_disease = new Talent("talent.resistance_to_disease.name", "talent.resistance_to_disease.description"); talents.add(resistance_to_disease);
        Talent resistance_to_magic = new Talent("talent.resistance_to_magic.name", "talent.resistance_to_magic.description"); talents.add(resistance_to_magic);
        Talent resistance_to_posion = new Talent("talent.resistance_to_posion.name", "talent.resistance_to_posion.description"); talents.add(resistance_to_posion);
        Talent rover = new Talent("talent.rover.name", "talent.rover.description"); talents.add(rover);
        Talent savvy = new Talent("talent.savvy.name", "talent.savvy.description"); talents.add(savvy);
        Talent schemer = new Talent("talent.schemer.name", "talent.schemer.description"); talents.add(schemer);
        Talent seasoned_traveller = new Talent("talent.seasoned_traveller.name", "talent.seasoned_traveller.description"); talents.add(seasoned_traveller);
        Talent sharpshooter = new Talent("talent.sharpshooter.name", "talent.sharpshooter.description"); talents.add(sharpshooter);
        Talent sixth_sense = new Talent("talent.sixth_sense.name", "talent.sixth_sense.description"); talents.add(sixth_sense);
        Talent specialist_weapon = new Talent("talent.specialist_weapon.name", "talent.specialist_weapon.description"); talents.add(specialist_weapon);
        Talent group = new Talent("talent.group.name", "talent.group.description"); talents.add(group);
        Talent stout_hearted = new Talent("talent.stout_hearted.name", "talent.stout_hearted.description"); talents.add(stout_hearted);
        Talent street_fighting = new Talent("talent.street_fighting.name", "talent.street_fighting.description"); talents.add(street_fighting);
        Talent streetwise = new Talent("talent.streetwise.name", "talent.streetwise.description"); talents.add(streetwise);
        Talent strike_mighty_blow = new Talent("talent.strike_mighty_blow.name", "talent.strike_mighty_blow.description"); talents.add(strike_mighty_blow);
        Talent strike_to_injure = new Talent("talent.strike_to_injure.name", "talent.strike_to_injure.description"); talents.add(strike_to_injure);
        Talent strike_to_stun = new Talent("talent.strike_to_stun.name", "talent.strike_to_stun.description"); talents.add(strike_to_stun);
        Talent strong_minded = new Talent("talent.strong_minded.name", "talent.strong_minded.description"); talents.add(strong_minded);
        Talent sturdy = new Talent("talent.sturdy.name", "talent.sturdy.description"); talents.add(sturdy);
        Talent suave = new Talent("talent.suave.name", "talent.suave.description"); talents.add(suave);
        Talent sure_shot = new Talent("talent.sure_shot.name", "talent.sure_shot.description"); talents.add(sure_shot);
        Talent surgery = new Talent("talent.surgery.name", "talent.surgery.description"); talents.add(surgery);
        Talent super_numerate = new Talent("talent.super_numerate.name", "talent.super_numerate.description"); talents.add(super_numerate);
        Talent swashbuckler = new Talent("talent.swashbuckler.name", "talent.swashbuckler.description"); talents.add(swashbuckler);
        Talent terrifying = new Talent("talent.terrifying.name", "talent.terrifying.description"); talents.add(terrifying);
        Talent trapfinder = new Talent("talent.trapfinder.name", "talent.trapfinder.description"); talents.add(trapfinder);
        Talent trick_riding = new Talent("talent.trick_riding.name", "talent.trick_riding.description"); talents.add(trick_riding);
        Talent tunnel_rat = new Talent("talent.tunnel_rat.name", "talent.tunnel_rat.description"); talents.add(tunnel_rat);
        Talent undead = new Talent("talent.undead.name", "talent.undead.description"); talents.add(undead);
        Talent unsettling = new Talent("talent.unsettling.name", "talent.unsettling.description"); talents.add(unsettling);
        Talent very_resilient = new Talent("talent.very_resilient.name", "talent.very_resilient.description"); talents.add(very_resilient);
        Talent very_strong = new Talent("talent.very_strong.name", "talent.very_strong.description"); talents.add(very_strong);
        Talent warrior_born = new Talent("talent.warrior_born.name", "talent.warrior_born.description"); talents.add(warrior_born);
        Talent wrestling = new Talent("talent.wrestling.name", "talent.wrestling.description"); talents.add(wrestling);


        // Create skills and associate them with talents
        List<Skill> skills = new ArrayList<Skill>();
        Skill academic_knowledge = new Skill("skill.academic_knowledge.name", AdvancedEnum.ADVANCED, CharacteristicEnum.INTELLIGENCE, "skill.academic_knowledge.description");
        academic_knowledge.setTalents(new HashSet<>(Arrays.asList())); skills.add(academic_knowledge);

        Skill animal_care = new Skill("skill.animal_care.name", AdvancedEnum.BASIC, CharacteristicEnum.INTELLIGENCE, "skill.animal_care.description"); 
        animal_care.setTalents(new HashSet<>(Arrays.asList())); skills.add(animal_care);

        Skill animal_training = new Skill("skill.animal_training.name", AdvancedEnum.ADVANCED, CharacteristicEnum.FELLOWSHIP, "skill.animal_training.description"); 
        animal_training.setTalents(new HashSet<>(Arrays.asList())); skills.add(animal_training);

        Skill blather = new Skill("skill.blather.name", AdvancedEnum.ADVANCED, CharacteristicEnum.FELLOWSHIP, "skill.blather.description"); 
        blather.setTalents(new HashSet<>(Arrays.asList())); skills.add(blather);

        Skill channeling = new Skill("skill.channeling.name", AdvancedEnum.ADVANCED, CharacteristicEnum.WILL_POWER, "skill.channeling.description"); 
        channeling.setTalents(new HashSet<>(Arrays.asList(aethyric_attunement))); skills.add(channeling);

        Skill charm = new Skill("skill.charm.name", AdvancedEnum.BASIC, CharacteristicEnum.FELLOWSHIP, "skill.charm.description"); 
        charm.setTalents(new HashSet<>(Arrays.asList(etiquette, master_orator, public_speaking, schemer, streetwise))); skills.add(charm);

        Skill charm_animal = new Skill("skill.charm_animal.name", AdvancedEnum.BASIC, CharacteristicEnum.FELLOWSHIP, "skill.charm_animal.description"); 
        charm_animal.setTalents(new HashSet<>(Arrays.asList())); skills.add(charm_animal);

        Skill command = new Skill("skill.command.name", AdvancedEnum.BASIC, CharacteristicEnum.FELLOWSHIP, "skill.command.description"); 
        command.setTalents(new HashSet<>(Arrays.asList())); skills.add(command);
        
        Skill common_knowledge = new Skill("skill.common_knowledge.name", AdvancedEnum.ADVANCED, CharacteristicEnum.INTELLIGENCE, "skill.common_knowledge.description"); 
        common_knowledge.setTalents(new HashSet<>(Arrays.asList(seasoned_traveller))); skills.add(common_knowledge);

        Skill concealment = new Skill("skill.concealment.name", AdvancedEnum.BASIC, CharacteristicEnum.AGILITY, "skill.concealment.description"); 
        concealment.setTalents(new HashSet<>(Arrays.asList(alley_cat, rover, tunnel_rat))); skills.add(concealment);

        Skill consume_alcohol = new Skill("skill.consume_alcohol.name", AdvancedEnum.BASIC, CharacteristicEnum.TOUGHNESS, "skill.consume_alcohol.description"); 
        consume_alcohol.setTalents(new HashSet<>(Arrays.asList())); skills.add(consume_alcohol);

        Skill disguise = new Skill("skill.disguise.name", AdvancedEnum.BASIC, CharacteristicEnum.FELLOWSHIP, "skill.disguise.description"); 
        disguise.setTalents(new HashSet<>(Arrays.asList(mimic))); skills.add(disguise);
       
        Skill dodge_blow = new Skill("skill.dodge_blow.name", AdvancedEnum.ADVANCED, CharacteristicEnum.AGILITY, "skill.dodge_blow.description"); 
        dodge_blow.setTalents(new HashSet<>(Arrays.asList())); skills.add(dodge_blow);
        
        Skill drive = new Skill("skill.drive.name", AdvancedEnum.BASIC, CharacteristicEnum.STRENGTH, "skill.drive.description"); 
        drive.setTalents(new HashSet<>(Arrays.asList())); skills.add(drive);
        
        Skill evaluate = new Skill("skill.evaluate.name", AdvancedEnum.BASIC, CharacteristicEnum.INTELLIGENCE, "skill.evaluate.description"); 
        evaluate.setTalents(new HashSet<>(Arrays.asList(artistic, dealmaker))); skills.add(evaluate);
        
        Skill follow_trail = new Skill("skill.follow_trail.name", AdvancedEnum.ADVANCED, CharacteristicEnum.INTELLIGENCE, "skill.follow_trail.description"); 
        follow_trail.setTalents(new HashSet<>(Arrays.asList())); skills.add(follow_trail);
        
        Skill gamble = new Skill("skill.gamble.name", AdvancedEnum.BASIC, CharacteristicEnum.INTELLIGENCE, "skill.gamble.description"); 
        gamble.setTalents(new HashSet<>(Arrays.asList(super_numerate))); skills.add(gamble);
        
        Skill gossip = new Skill("skill.gossip.name", AdvancedEnum.BASIC, CharacteristicEnum.FELLOWSHIP, "skill.gossip.description"); 
        gossip.setTalents(new HashSet<>(Arrays.asList(etiquette, streetwise))); skills.add(gossip);
        
        Skill haggle = new Skill("skill.haggle.name", AdvancedEnum.BASIC, CharacteristicEnum.FELLOWSHIP, "skill.haggle.description"); 
        haggle.setTalents(new HashSet<>(Arrays.asList(dealmaker))); skills.add(haggle);
        
        Skill heal = new Skill("skill.heal.name", AdvancedEnum.ADVANCED, CharacteristicEnum.INTELLIGENCE, "skill.heal.description"); 
        heal.setTalents(new HashSet<>(Arrays.asList(surgery))); skills.add(heal);
        
        Skill hypnotism = new Skill("skill.hypnotism.name", AdvancedEnum.ADVANCED, CharacteristicEnum.INTELLIGENCE, "skill.hypnotism.description"); 
        hypnotism.setTalents(new HashSet<>(Arrays.asList())); skills.add(hypnotism);
        
        Skill intimidate = new Skill("skill.intimidate.name", AdvancedEnum.BASIC, CharacteristicEnum.STRENGTH, "skill.intimidate.description"); 
        intimidate.setTalents(new HashSet<>(Arrays.asList(menacing))); skills.add(intimidate);
        
        Skill lip_reading = new Skill("skill.lip_reading.name", AdvancedEnum.ADVANCED, CharacteristicEnum.INTELLIGENCE, "skill.lip_reading.description"); 
        lip_reading.setTalents(new HashSet<>(Arrays.asList(excellent_vision))); skills.add(lip_reading);
        
        Skill magical_sense = new Skill("skill.magical_sense.name", AdvancedEnum.ADVANCED, CharacteristicEnum.WILL_POWER, "skill.magical_sense.description"); 
        magical_sense.setTalents(new HashSet<>(Arrays.asList(aethyric_attunement))); skills.add(magical_sense);
        
        Skill navigation = new Skill("skill.navigation.name", AdvancedEnum.ADVANCED, CharacteristicEnum.INTELLIGENCE, "skill.navigation.description"); 
        navigation.setTalents(new HashSet<>(Arrays.asList(orientation, super_numerate))); skills.add(navigation);
        
        Skill outdoor_survival = new Skill("skill.outdoor_survival.name", AdvancedEnum.BASIC, CharacteristicEnum.INTELLIGENCE, "skill.outdoor_survival.description"); 
        outdoor_survival.setTalents(new HashSet<>(Arrays.asList())); skills.add(outdoor_survival);
        
        Skill perception = new Skill("skill.perception.name", AdvancedEnum.BASIC, CharacteristicEnum.INTELLIGENCE, "skill.perception.description"); 
        perception.setTalents(new HashSet<>(Arrays.asList(acute_hearing, excellent_vision, super_numerate, trapfinder))); skills.add(perception);
        
        Skill performer = new Skill("skill.performer.name", AdvancedEnum.ADVANCED, CharacteristicEnum.FELLOWSHIP, "skill.performer.description"); 
        performer.setTalents(new HashSet<>(Arrays.asList(contortionist, mimic))); skills.add(performer);
        
        Skill pick_locks = new Skill("skill.pick_locks.name", AdvancedEnum.ADVANCED, CharacteristicEnum.AGILITY, "skill.pick_locks.description"); 
        pick_locks.setTalents(new HashSet<>(Arrays.asList(trapfinder))); skills.add(pick_locks);
        
        Skill prepare_poison = new Skill("skill.prepare_poison.name", AdvancedEnum.ADVANCED, CharacteristicEnum.INTELLIGENCE, "skill.prepare_poison.description"); 
        prepare_poison.setTalents(new HashSet<>(Arrays.asList())); skills.add(prepare_poison);
        
        Skill read_write = new Skill("skill.read_write.name", AdvancedEnum.ADVANCED, CharacteristicEnum.INTELLIGENCE, "skill.read_write.description"); 
        read_write.setTalents(new HashSet<>(Arrays.asList(linguistics))); skills.add(read_write);
        
        Skill ride = new Skill("skill.ride.name", AdvancedEnum.BASIC, CharacteristicEnum.AGILITY, "skill.ride.description"); 
        ride.setTalents(new HashSet<>(Arrays.asList(trick_riding))); skills.add(ride);
        
        Skill row = new Skill("skill.row.name", AdvancedEnum.BASIC, CharacteristicEnum.STRENGTH, "skill.row.description"); 
        row.setTalents(new HashSet<>(Arrays.asList())); skills.add(row);
        
        Skill sail = new Skill("skill.sail.name", AdvancedEnum.ADVANCED, CharacteristicEnum.AGILITY, "skill.sail.description"); 
        sail.setTalents(new HashSet<>(Arrays.asList())); skills.add(sail);
        
        Skill scale_sheer_surface = new Skill("skill.scale_sheer_surface.name", AdvancedEnum.BASIC, CharacteristicEnum.STRENGTH, "skill.scale_sheer_surface.description"); 
        scale_sheer_surface.setTalents(new HashSet<>(Arrays.asList())); skills.add(scale_sheer_surface);
        
        Skill search = new Skill("skill.search.name", AdvancedEnum.BASIC, CharacteristicEnum.INTELLIGENCE, "skill.search.description"); 
        search.setTalents(new HashSet<>(Arrays.asList())); skills.add(search);
        
        Skill secret_language = new Skill("skill.secret_language.name", AdvancedEnum.ADVANCED, CharacteristicEnum.INTELLIGENCE, "skill.secret_language.description"); 
        secret_language.setTalents(new HashSet<>(Arrays.asList())); skills.add(secret_language);
        
        Skill secret_signs = new Skill("skill.secret_signs.name", AdvancedEnum.ADVANCED, CharacteristicEnum.INTELLIGENCE, "skill.secret_signs.description"); 
        secret_signs.setTalents(new HashSet<>(Arrays.asList())); skills.add(secret_signs);
        
        Skill set_trap = new Skill("skill.set_trap.name", AdvancedEnum.ADVANCED, CharacteristicEnum.AGILITY, "skill.set_trap.description"); 
        set_trap.setTalents(new HashSet<>(Arrays.asList())); skills.add(set_trap);
        
        Skill silent_move = new Skill("skill.silent_move.name", AdvancedEnum.BASIC, CharacteristicEnum.AGILITY, "skill.silent_move.description"); 
        silent_move.setTalents(new HashSet<>(Arrays.asList(alley_cat, rover, tunnel_rat))); skills.add(silent_move);
        
        Skill shadowing = new Skill("skill.shadowing.name", AdvancedEnum.ADVANCED, CharacteristicEnum.AGILITY, "skill.shadowing.description"); 
        shadowing.setTalents(new HashSet<>(Arrays.asList())); skills.add(shadowing);
        
        Skill sleight_of_hand = new Skill("skill.sleight_of_hand.name", AdvancedEnum.ADVANCED, CharacteristicEnum.AGILITY, "skill.sleight_of_hand.description"); 
        sleight_of_hand.setTalents(new HashSet<>(Arrays.asList())); skills.add(sleight_of_hand);
        
        Skill speak_arcane_language = new Skill("skill.speak_arcane_language.name", AdvancedEnum.ADVANCED, CharacteristicEnum.INTELLIGENCE, "skill.speak_arcane_language.description"); 
        speak_arcane_language.setTalents(new HashSet<>(Arrays.asList())); skills.add(speak_arcane_language);
        
        Skill speak_language = new Skill("skill.speak_language.name", AdvancedEnum.ADVANCED, CharacteristicEnum.INTELLIGENCE, "skill.speak_language.description"); 
        speak_language.setTalents(new HashSet<>(Arrays.asList(linguistics, mimic, seasoned_traveller))); skills.add(speak_language);
        
        Skill swim = new Skill("skill.swim.name", AdvancedEnum.BASIC, CharacteristicEnum.STRENGTH, "skill.swim.description"); 
        swim.setTalents(new HashSet<>(Arrays.asList())); skills.add(swim);
        
        Skill torture = new Skill("skill.torture.name", AdvancedEnum.ADVANCED, CharacteristicEnum.FELLOWSHIP, "skill.torture.description"); 
        torture.setTalents(new HashSet<>(Arrays.asList(menacing))); skills.add(torture);
        
        Skill trade = new Skill("skill.trade.name", AdvancedEnum.ADVANCED, CharacteristicEnum.NONE, "skill.trade.description"); 
        trade.setTalents(new HashSet<>(Arrays.asList(artistic, dwarfcraft))); skills.add(trade);
        
        Skill ventriloquism = new Skill("skill.ventriloquism.name", AdvancedEnum.ADVANCED, CharacteristicEnum.FELLOWSHIP, "skill.ventriloquism.description"); 
        ventriloquism.setTalents(new HashSet<>(Arrays.asList())); skills.add(ventriloquism);


        talentRepository.saveAll(talents);
        skillRepository.saveAll(skills);
    }

    @GetMapping("/careers")
    public void getMethodName() {

        long careerCount = careerRepository.count();
        if (careerCount != 0) return;

        // Create career entries
        List<Career> careers = new ArrayList<Career>();
        Career agitator = new Career("career.agitator.name", "career.agitator.description");
        Career apprentice_wizard = new Career("career.apprentice_wizard.name", "career.apprentice_wizard.description");
        Career bailiff = new Career("career.bailiff.name", "career.bailiff.description");
        Career barber_surgeon = new Career("career.barber_surgeon.name", "career.barber_surgeon.description");
        Career boatman = new Career("career.boatman.name", "career.boatman.description");
        Career bodyguard = new Career("career.bodyguard.name", "career.bodyguard.description");
        Career bone_picker = new Career("career.bone_picker.name", "career.bone_picker.description");
        Career bounty_hunter = new Career("career.bounty_hunter.name", "career.bounty_hunter.description");
        Career burgher = new Career("career.burgher.name", "career.burgher.description");
        Career camp_follower = new Career("career.camp_follower.name", "career.camp_follower.description");
        Career charcoal_burner = new Career("career.charcoal_burner.name", "career.charcoal_burner.description");
        Career coachman = new Career("career.coachman.name", "career.coachman.description");
        Career entertainer = new Career("career.entertainer.name", "career.entertainer.description");
        Career envoy = new Career("career.envoy.name", "career.envoy.description");
        Career estalian_diestro = new Career("career.estalian_diestro.name", "career.estalian_diestro.description");
        Career ferryman = new Career("career.ferryman.name", "career.ferryman.description");
        Career fieldwarden = new Career("career.fieldwarden.name", "career.fieldwarden.description");
        Career fisherman = new Career("career.fisherman.name", "career.fisherman.description");
        Career grave_robber = new Career("career.grave_robber.name", "career.grave_robber.description");
        Career hedge_wizard = new Career("career.hedge_wizard.name", "career.hedge_wizard.description");
        Career initiate = new Career("career.initiate.name", "career.initiate.description");
        Career hunter = new Career("career.hunter.name", "career.hunter.description");
        Career jailer = new Career("career.jailer.name", "career.jailer.description");
        Career kislevite_kossar = new Career("career.kislevite_kossar.name", "career.kislevite_kossar.description");
        Career kithband_warrior = new Career("career.kithband_warrior.name", "career.kithband_warrior.description");
        Career marine = new Career("career.marine.name", "career.marine.description");
        Career mercenary = new Career("career.mercenary.name", "career.mercenary.description");
        Career messenger = new Career("career.messenger.name", "career.messenger.description");
        Career militiaman = new Career("career.militiaman.name", "career.militiaman.description");
        Career miner = new Career("career.miner.name", "career.miner.description");
        Career noble = new Career("career.noble.name", "career.noble.description");
        Career norse_berserker = new Career("career.norse_berserker.name", "career.norse_berserker.description");
        Career outlaw = new Career("career.outlaw.name", "career.outlaw.description");
        Career outrider = new Career("career.outrider.name", "career.outrider.description");
        Career peasant = new Career("career.peasant.name", "career.peasant.description");
        Career pit_fighter = new Career("career.pit_fighter.name", "career.pit_fighter.description");
        Career protagonist = new Career("career.protagonist.name", "career.protagonist.description");
        Career rat_catcher = new Career("career.rat_catcher.name", "career.rat_catcher.description");
        Career roadwarden = new Career("career.roadwarden.name", "career.roadwarden.description");
        Career rogue = new Career("career.rogue.name", "career.rogue.description");
        Career runebearer = new Career("career.runebearer.name", "career.runebearer.description");
        Career scribe = new Career("career.scribe.name", "career.scribe.description");
        Career seaman = new Career("career.seaman.name", "career.seaman.description");
        Career servant = new Career("career.servant.name", "career.servant.description");
        Career shieldbreaker = new Career("career.shieldbreaker.name", "career.shieldbreaker.description");
        Career smuggler = new Career("career.smuggler.name", "career.smuggler.description");
        Career soldier = new Career("career.soldier.name", "career.soldier.description");
        Career squire = new Career("career.squire.name", "career.squire.description");
        Career student = new Career("career.student.name", "career.student.description");
        Career thief = new Career("career.thief.name", "career.thief.description");
        Career thug = new Career("career.thug.name", "career.thug.description");
        Career toll_keeper = new Career("career.toll_keeper.name", "career.toll_keeper.description");
        Career tomb_robber = new Career("career.tomb_robber.name", "career.tomb_robber.description");
        Career tradesman = new Career("career.tradesman.name", "career.tradesman.description");
        Career troll_slayer = new Career("career.troll_slayer.name", "career.troll_slayer.description");
        Career vagabond = new Career("career.vagabond.name", "career.vagabond.description");
        Career valet = new Career("career.valet.name", "career.valet.description");
        Career watchman = new Career("career.watchman.name", "career.watchman.description");
        Career woodsman = new Career("career.woodsman.name", "career.woodsman.description");
        Career zealot = new Career("career.zealot.name", "career.zealot.description");

        Career anointed_priest = new Career("career.anointed_priest.name", "career.anointed_priest.description");
        Career artisan = new Career("career.artisan.name", "career.artisan.description");
        Career assassin = new Career("career.assassin.name", "career.assassin.description");
        Career captain = new Career("career.captain.name", "career.captain.description");
        Career cat_burglar = new Career("career.cat_burglar.name", "career.cat_burglar.description");
        Career champion = new Career("career.champion.name", "career.champion.description");
        Career charlatan = new Career("career.charlatan.name", "career.charlatan.description");
        Career courtier = new Career("career.courtier.name", "career.courtier.description");
        Career crime_lord = new Career("career.crime_lord.name", "career.crime_lord.description");
        Career deamon_slayer = new Career("career.deamon_slayer.name", "career.deamon_slayer.description");
        Career demagogue = new Career("career.demagogue.name", "career.demagogue.description");
        Career duellist = new Career("career.duellist.name", "career.duellist.description");
        Career engineer = new Career("career.engineer.name", "career.engineer.description");
        Career explorer = new Career("career.explorer.name", "career.explorer.description");
        Career fence = new Career("career.fence.name", "career.fence.description");
        Career flagellant = new Career("career.flagellant.name", "career.flagellant.description");
        Career friar = new Career("career.friar.name", "career.friar.description");
        Career ghost_strider = new Career("career.ghost_strider.name", "career.ghost_strider.description");
        Career giant_slayer = new Career("career.giant_slayer.name", "career.giant_slayer.description");
        Career glorious_death = new Career("career.glorious_death.name", "career.glorious_death.description");
        Career guild_master = new Career("career.guild_master.name", "career.guild_master.description");
        Career herald = new Career("career.herald.name", "career.herald.description");
        Career high_priest = new Career("career.high_priest.name", "career.high_priest.description");
        Career highwayman = new Career("career.highwayman.name", "career.highwayman.description");
        Career inkeeper = new Career("career.inkeeper.name", "career.inkeeper.description");
        Career interrogator = new Career("career.interrogator.name", "career.interrogator.description");
        Career journeyman_wizard = new Career("career.journeyman_wizard.name", "career.journeyman_wizard.description");
        Career judicial_champion = new Career("career.judicial_champion.name", "career.judicial_champion.description");
        Career knight = new Career("career.knight.name", "career.knight.description");
        Career knight_of_the_inner_circle = new Career("career.knight_of_the_inner_circle.name", "career.knight_of_the_inner_circle.description");
        Career master_thief = new Career("career.master_thief.name", "career.master_thief.description");
        Career master_wizard = new Career("career.master_wizard.name", "career.master_wizard.description");
        Career mate = new Career("career.mate.name", "career.mate.description");
        Career merchant = new Career("career.merchant.name", "career.merchant.description");
        Career minstrel = new Career("career.minstrel.name", "career.minstrel.description");
        Career navigator = new Career("career.navigator.name", "career.navigator.description");
        Career noble_lord = new Career("career.noble_lord.name", "career.noble_lord.description");
        Career outlaw_chief = new Career("career.outlaw_chief.name", "career.outlaw_chief.description");
        Career physician = new Career("career.physician.name", "career.physician.description");
        Career pistolier = new Career("career.pistolier.name", "career.pistolier.description");
        Career politician = new Career("career.politician.name", "career.politician.description");
        Career priest = new Career("career.priest.name", "career.priest.description");
        Career racketeer = new Career("career.racketeer.name", "career.racketeer.description");
        Career scholar = new Career("career.scholar.name", "career.scholar.description");
        Career scout = new Career("career.scout.name", "career.scout.description");
        Career sea_captain = new Career("career.sea_captain.name", "career.sea_captain.description");
        Career sergeant = new Career("career.sergeant.name", "career.sergeant.description");
        Career spy = new Career("career.spy.name", "career.spy.description");
        Career steward = new Career("career.steward.name", "career.steward.description");
        Career targeteer = new Career("career.targeteer.name", "career.targeteer.description");
        Career vampire_hunter = new Career("career.vampire_hunter.name", "career.vampire_hunter.description");
        Career veteran = new Career("career.veteran.name", "career.veteran.description");
        Career witch_hunter = new Career("career.witch_hunter.name", "career.witch_hunter.description");
        Career wizard_lord = new Career("career.wizard_lord.name", "career.wizard_lord.description");
        
        // Establish connections between careers
        agitator.setCareerEntries(new HashSet<>(Arrays.asList(burgher, captain, herald, highwayman, scribe, servant, student, zealot)));
        apprentice_wizard.setCareerEntries(new HashSet<>(Arrays.asList(hedge_wizard, scholar, scribe, student))); 
        bailiff.setCareerEntries(new HashSet<>(Arrays.asList(bodyguard, jailer))); 
        barber_surgeon.setCareerEntries(new HashSet<>(Arrays.asList(initiate, student))); 
        boatman.setCareerEntries(new HashSet<>(Arrays.asList(ferryman, smuggler))); 
        bodyguard.setCareerEntries(new HashSet<>(Arrays.asList(estalian_diestro, jailer, mercenary, thug))); 
        bone_picker.setCareerEntries(new HashSet<>(Arrays.asList(peasant, rat_catcher, vagabond))); 
        bounty_hunter.setCareerEntries(new HashSet<>(Arrays.asList(bodyguard, fieldwarden, hunter, kislevite_kossar, mercenary, pit_fighter))); 
        burgher.setCareerEntries(new HashSet<>(Arrays.asList(inkeeper, servant)));
        camp_follower.setCareerEntries(new HashSet<>(Arrays.asList(bone_picker, servant)));
        charcoal_burner.setCareerEntries(new HashSet<>(Arrays.asList(camp_follower, hunter, miner, peasant)));
        coachman.setCareerEntries(new HashSet<>(Arrays.asList(outrider, messenger)));
        entertainer.setCareerEntries(new HashSet<>(Arrays.asList(herald, rogue, thief, vagabond)));
        envoy.setCareerEntries(new HashSet<>(Arrays.asList(student, tradesman)));
        estalian_diestro.setCareerEntries(new HashSet<>(Arrays.asList()));
        ferryman.setCareerEntries(new HashSet<>(Arrays.asList(coachman, smuggler, toll_keeper)));
        fieldwarden.setCareerEntries(new HashSet<>(Arrays.asList(hunter, militiaman, toll_keeper)));
        fisherman.setCareerEntries(new HashSet<>(Arrays.asList(boatman, peasant)));
        grave_robber.setCareerEntries(new HashSet<>(Arrays.asList(barber_surgeon, bone_picker, rat_catcher)));
        hedge_wizard.setCareerEntries(new HashSet<>(Arrays.asList()));
        hunter.setCareerEntries(new HashSet<>(Arrays.asList(charcoal_burner, kithband_warrior, woodsman)));
        initiate.setCareerEntries(new HashSet<>(Arrays.asList(hedge_wizard, knight, scribe, student, vampire_hunter, witch_hunter, zealot)));
        jailer.setCareerEntries(new HashSet<>(Arrays.asList(bodyguard, rat_catcher)));
        kislevite_kossar.setCareerEntries(new HashSet<>(Arrays.asList()));
        kithband_warrior.setCareerEntries(new HashSet<>(Arrays.asList(hunter, messenger)));
        marine.setCareerEntries(new HashSet<>(Arrays.asList(boatman, fisherman, seaman)));
        mercenary.setCareerEntries(new HashSet<>(Arrays.asList(bodyguard, bounty_hunter, demagogue, fieldwarden, kislevite_kossar, militiaman, miner, norse_berserker, outrider, pit_fighter, soldier, thug, watchman)));
        messenger.setCareerEntries(new HashSet<>(Arrays.asList(militiaman, roadwarden, servant)));
        militiaman.setCareerEntries(new HashSet<>(Arrays.asList(artisan, bailiff, burgher, fisherman, merchant, peasant, tradesman, woodsman)));
        miner.setCareerEntries(new HashSet<>(Arrays.asList(charcoal_burner, hunter)));
        noble.setCareerEntries(new HashSet<>(Arrays.asList(squire, steward)));
        norse_berserker.setCareerEntries(new HashSet<>(Arrays.asList()));
        outlaw.setCareerEntries(new HashSet<>(Arrays.asList(agitator, charlatan, coachman, hedge_wizard, inkeeper, marine, mercenary, militiaman, peasant, roadwarden, rogue, squire, toll_keeper, woodsman, zealot)));
        outrider.setCareerEntries(new HashSet<>(Arrays.asList(kithband_warrior, messenger, roadwarden, soldier)));
        peasant.setCareerEntries(new HashSet<>(Arrays.asList()));
        pit_fighter.setCareerEntries(new HashSet<>(Arrays.asList(norse_berserker, protagonist, shieldbreaker, thug)));
        protagonist.setCareerEntries(new HashSet<>(Arrays.asList(bailiff, bodyguard, bounty_hunter, estalian_diestro, pit_fighter)));
        rat_catcher.setCareerEntries(new HashSet<>(Arrays.asList(grave_robber, jailer, runebearer, tomb_robber)));
        roadwarden.setCareerEntries(new HashSet<>(Arrays.asList(coachman, ferryman, messenger, outrider, watchman)));
        rogue.setCareerEntries(new HashSet<>(Arrays.asList(agitator,  assassin, duellist, entertainer, envoy, estalian_diestro, noble, seaman, thief, valet)));
        runebearer.setCareerEntries(new HashSet<>(Arrays.asList(shieldbreaker)));
        scribe.setCareerEntries(new HashSet<>(Arrays.asList(apprentice_wizard, initiate)));
        seaman.setCareerEntries(new HashSet<>(Arrays.asList(boatman, envoy, ferryman, fisherman, norse_berserker, smuggler)));
        servant.setCareerEntries(new HashSet<>(Arrays.asList(camp_follower, peasant, rogue)));
        shieldbreaker.setCareerEntries(new HashSet<>(Arrays.asList(kislevite_kossar, mercenary, miner, rat_catcher, runebearer, smuggler, tomb_robber)));
        smuggler.setCareerEntries(new HashSet<>(Arrays.asList(bailiff, boatman, bone_picker, camp_follower, coachman, engineer, ferryman, inkeeper, marine, miner, seaman, shieldbreaker)));
        soldier.setCareerEntries(new HashSet<>(Arrays.asList(flagellant, hunter, messenger, toll_keeper, watchman)));
        squire.setCareerEntries(new HashSet<>(Arrays.asList(herald, noble, valet)));
        student.setCareerEntries(new HashSet<>(Arrays.asList(envoy, grave_robber, minstrel, noble, valet)));
        thief.setCareerEntries(new HashSet<>(Arrays.asList(entertainer, grave_robber, interrogator, militiaman, outlaw, protagonist, rat_catcher, rogue, servant, smuggler, toll_keeper, tomb_robber, vagabond)));
        thug.setCareerEntries(new HashSet<>(Arrays.asList(marine, protagonist)));
        toll_keeper.setCareerEntries(new HashSet<>(Arrays.asList(bailiff, coachman, roadwarden)));
        tomb_robber.setCareerEntries(new HashSet<>(Arrays.asList(runebearer, shieldbreaker, thief)));
        tradesman.setCareerEntries(new HashSet<>(Arrays.asList(barber_surgeon, burgher, camp_follower, peasant, watchman)));
        troll_slayer.setCareerEntries(new HashSet<>(Arrays.asList(pit_fighter)));
        vagabond.setCareerEntries(new HashSet<>(Arrays.asList(barber_surgeon, camp_follower, cat_burglar, charcoal_burner, entertainer, envoy, fieldwarden, hedge_wizard, kithband_warrior, outlaw, soldier, woodsman)));
        valet.setCareerEntries(new HashSet<>(Arrays.asList(burgher, servant)));
        watchman.setCareerEntries(new HashSet<>(Arrays.asList(jailer, soldier)));
        woodsman.setCareerEntries(new HashSet<>(Arrays.asList(charcoal_burner, vagabond)));
        zealot.setCareerEntries(new HashSet<>(Arrays.asList(agitator, initiate, judicial_champion, peasant, tradesman)));
        
        anointed_priest.setCareerEntries(new HashSet<>(Arrays.asList(priest)));
        artisan.setCareerEntries(new HashSet<>(Arrays.asList(engineer, militiaman, navigator, tradesman)));
        assassin.setCareerEntries(new HashSet<>(Arrays.asList(champion, duellist, judicial_champion, outlaw_chief, spy, targeteer)));
        captain.setCareerEntries(new HashSet<>(Arrays.asList(explorer, ghost_strider, knight, knight_of_the_inner_circle, noble_lord, outlaw_chief, sergeant, witch_hunter)));
        cat_burglar.setCareerEntries(new HashSet<>(Arrays.asList(bone_picker, charlatan, grave_robber, rat_catcher, thief)));
        champion.setCareerEntries(new HashSet<>(Arrays.asList(assassin, duellist, judicial_champion, knight_of_the_inner_circle, targeteer, veteran, witch_hunter)));
        charlatan.setCareerEntries(new HashSet<>(Arrays.asList(agitator, camp_follower, courtier, entertainer, envoy, fence, hedge_wizard, journeyman_wizard, minstrel, rogue, smuggler, thief)));
        courtier.setCareerEntries(new HashSet<>(Arrays.asList(noble, herald, pistolier, politician)));
        crime_lord.setCareerEntries(new HashSet<>(Arrays.asList(cat_burglar, demagogue, fence, guild_master, master_thief, outlaw_chief, politician, steward)));
        deamon_slayer.setCareerEntries(new HashSet<>(Arrays.asList(giant_slayer)));
        demagogue.setCareerEntries(new HashSet<>(Arrays.asList(agitator, anointed_priest, artisan, charlatan, crime_lord, flagellant, friar, initiate, minstrel, outlaw, outlaw_chief, politician, rogue, vampire_hunter, witch_hunter)));
        duellist.setCareerEntries(new HashSet<>(Arrays.asList(courtier, estalian_diestro, highwayman, pistolier, protagonist, sergeant, targeteer)));
        engineer.setCareerEntries(new HashSet<>(Arrays.asList(artisan, miner, student, tradesman)));
        explorer.setCareerEntries(new HashSet<>(Arrays.asList(captain, engineer, herald, master_thief, master_wizard, mate, navigator, scholar, scout, sea_captain, spy, wizard_lord)));
        fence.setCareerEntries(new HashSet<>(Arrays.asList(bone_picker, burgher, cat_burglar, grave_robber, inkeeper, racketeer, smuggler, steward, thief, tomb_robber)));
        flagellant.setCareerEntries(new HashSet<>(Arrays.asList(anointed_priest, friar, priest, zealot)));
        friar.setCareerEntries(new HashSet<>(Arrays.asList(demagogue, initiate, physician, scholar, vagabond, zealot)));
        ghost_strider.setCareerEntries(new HashSet<>(Arrays.asList(scout)));
        giant_slayer.setCareerEntries(new HashSet<>(Arrays.asList(troll_slayer)));
        glorious_death.setCareerEntries(new HashSet<>(Arrays.asList(deamon_slayer)));
        guild_master.setCareerEntries(new HashSet<>(Arrays.asList(artisan, engineer, merchant, physician, wizard_lord)));
        herald.setCareerEntries(new HashSet<>(Arrays.asList(messenger, valet)));
        high_priest.setCareerEntries(new HashSet<>(Arrays.asList(anointed_priest)));
        highwayman.setCareerEntries(new HashSet<>(Arrays.asList(coachman, duellist, estalian_diestro, ferryman, minstrel, outlaw, outrider, roadwarden, toll_keeper)));
        inkeeper.setCareerEntries(new HashSet<>(Arrays.asList(burgher, servant)));
        interrogator.setCareerEntries(new HashSet<>(Arrays.asList(barber_surgeon, bodyguard, flagellant, jailer, thug)));
        journeyman_wizard.setCareerEntries(new HashSet<>(Arrays.asList(apprentice_wizard)));
        judicial_champion.setCareerEntries(new HashSet<>(Arrays.asList(sergeant, veteran)));
        knight.setCareerEntries(new HashSet<>(Arrays.asList(noble_lord, pistolier, sergeant, squire, vampire_hunter)));
        knight_of_the_inner_circle.setCareerEntries(new HashSet<>(Arrays.asList(knight, witch_hunter)));
        master_thief.setCareerEntries(new HashSet<>(Arrays.asList(cat_burglar, crime_lord, fence, highwayman, racketeer, spy)));
        master_wizard.setCareerEntries(new HashSet<>(Arrays.asList(journeyman_wizard)));
        mate.setCareerEntries(new HashSet<>(Arrays.asList(marine, seaman)));
        merchant.setCareerEntries(new HashSet<>(Arrays.asList(artisan, burgher, captain, envoy, explorer, fisherman, inkeeper, mate, scholar, steward,  tradesman)));
        minstrel.setCareerEntries(new HashSet<>(Arrays.asList(entertainer)));
        navigator.setCareerEntries(new HashSet<>(Arrays.asList(boatman, fisherman, mate, scribe, seaman)));
        noble_lord.setCareerEntries(new HashSet<>(Arrays.asList(courtier, knight, knight_of_the_inner_circle, politician, sea_captain)));
        outlaw_chief.setCareerEntries(new HashSet<>(Arrays.asList(crime_lord, demagogue, ghost_strider, highwayman, master_thief, racketeer, scout, veteran)));
        physician.setCareerEntries(new HashSet<>(Arrays.asList(barber_surgeon, interrogator, scholar, student)));
        pistolier.setCareerEntries(new HashSet<>(Arrays.asList(engineer, noble)));
        politician.setCareerEntries(new HashSet<>(Arrays.asList(agitator, bailiff, captain, charlatan, courtier, crime_lord, demagogue, guild_master, herald, high_priest, merchant, noble, peasant, racketeer, toll_keeper)));
        priest.setCareerEntries(new HashSet<>(Arrays.asList(flagellant, friar, initiate)));
        racketeer.setCareerEntries(new HashSet<>(Arrays.asList(bailiff, bodyguard, cat_burglar, fence, guild_master, interrogator, merchant, politician, protagonist, spy, thug)));
        scholar.setCareerEntries(new HashSet<>(Arrays.asList(anointed_priest, apprentice_wizard, friar, high_priest, journeyman_wizard, master_wizard, navigator, noble_lord, physician, priest, scribe, sea_captain, student)));
        scout.setCareerEntries(new HashSet<>(Arrays.asList(bounty_hunter, champion, charcoal_burner, coachman, fieldwarden, hunter, kithband_warrior, messenger, miner, outrider, roadwarden, runebearer, vagabond, woodsman)));
        sea_captain.setCareerEntries(new HashSet<>(Arrays.asList(explorer, mate, navigator, noble_lord)));
        sergeant.setCareerEntries(new HashSet<>(Arrays.asList(assassin, champion, duellist, highwayman, judicial_champion, kislevite_kossar, marine, mercenary, militiaman, norse_berserker, soldier, squire, targeteer, veteran, watchman)));
        spy.setCareerEntries(new HashSet<>(Arrays.asList(camp_follower,  charlatan, courtier, explorer, merchant, minstrel, physician, sea_captain, servant)));
        steward.setCareerEntries(new HashSet<>(Arrays.asList(courtier, politician, priest, scholar, valet)));
        targeteer.setCareerEntries(new HashSet<>(Arrays.asList(bounty_hunter, ghost_strider, master_thief, vampire_hunter, veteran)));
        vampire_hunter.setCareerEntries(new HashSet<>(Arrays.asList(bounty_hunter, fieldwarden, ghost_strider, knight, scout, tomb_robber)));
        veteran.setCareerEntries(new HashSet<>(Arrays.asList(flagellant, kislevite_kossar, kithband_warrior, mercenary, norse_berserker, outlaw, pistolier, pit_fighter, runebearer, shieldbreaker, soldier, squire)));
        witch_hunter.setCareerEntries(new HashSet<>(Arrays.asList(anointed_priest, assassin, champion, high_priest, judicial_champion, knight_of_the_inner_circle, vampire_hunter)));
        wizard_lord.setCareerEntries(new HashSet<>(Arrays.asList(master_wizard)));
        
        
        careers.add(agitator);
        careers.add(apprentice_wizard);
        careers.add(bailiff);
        careers.add(barber_surgeon);
        careers.add(boatman);
        careers.add(bodyguard);
        careers.add(bone_picker);
        careers.add(bounty_hunter);
        careers.add(burgher);
        careers.add(camp_follower);
        careers.add(charcoal_burner);
        careers.add(coachman);
        careers.add(entertainer);
        careers.add(envoy);
        careers.add(estalian_diestro);
        careers.add(ferryman);
        careers.add(fieldwarden);
        careers.add(fisherman);
        careers.add(grave_robber);
        careers.add(hedge_wizard);
        careers.add(hunter);
        careers.add(initiate);
        careers.add(jailer);
        careers.add(kislevite_kossar);
        careers.add(kithband_warrior);
        careers.add(marine);
        careers.add(mercenary);
        careers.add(messenger);
        careers.add(militiaman);
        careers.add(miner);
        careers.add(noble);
        careers.add(norse_berserker);
        careers.add(outlaw);
        careers.add(outrider);
        careers.add(peasant);
        careers.add(pit_fighter);
        careers.add(protagonist);
        careers.add(rat_catcher);
        careers.add(roadwarden);
        careers.add(rogue);
        careers.add(runebearer);
        careers.add(scribe);
        careers.add(seaman);
        careers.add(servant);
        careers.add(shieldbreaker);
        careers.add(smuggler);
        careers.add(soldier);
        careers.add(squire);
        careers.add(student);
        careers.add(thief);
        careers.add(thug);
        careers.add(toll_keeper);
        careers.add(tomb_robber);
        careers.add(tradesman);
        careers.add(troll_slayer);
        careers.add(vagabond);
        careers.add(valet);
        careers.add(watchman);
        careers.add(woodsman);
        careers.add(zealot);

        careers.add(anointed_priest);
        careers.add(artisan);
        careers.add(assassin);
        careers.add(captain);
        careers.add(cat_burglar);
        careers.add(champion);
        careers.add(charlatan);
        careers.add(courtier);
        careers.add(crime_lord);
        careers.add(deamon_slayer);
        careers.add(demagogue);
        careers.add(duellist);
        careers.add(engineer);
        careers.add(explorer);
        careers.add(fence);
        careers.add(flagellant);
        careers.add(friar);
        careers.add(ghost_strider);
        careers.add(giant_slayer);
        careers.add(glorious_death);
        careers.add(guild_master);
        careers.add(herald);
        careers.add(high_priest);
        careers.add(highwayman);
        careers.add(inkeeper);
        careers.add(interrogator);
        careers.add(journeyman_wizard);
        careers.add(judicial_champion);
        careers.add(knight);
        careers.add(knight_of_the_inner_circle);
        careers.add(master_thief);
        careers.add(master_wizard);
        careers.add(mate);
        careers.add(merchant);
        careers.add(minstrel);
        careers.add(navigator);
        careers.add(noble_lord);
        careers.add(outlaw_chief);
        careers.add(physician);
        careers.add(pistolier);
        careers.add(politician);
        careers.add(priest);
        careers.add(racketeer);
        careers.add(scholar);
        careers.add(scout);
        careers.add(sea_captain);
        careers.add(sergeant);
        careers.add(spy);
        careers.add(steward);
        careers.add(targeteer);
        careers.add(vampire_hunter);
        careers.add(veteran);
        careers.add(witch_hunter);
        careers.add(wizard_lord);

        careerRepository.saveAll(careers);
    }
    
}
