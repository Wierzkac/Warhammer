package com.warhammer.alfa.models;

import java.util.Arrays;
import java.util.HashSet;

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

        // Create talents
        Talent talent1 = new Talent("talent.acute_hearing.name", "talent.acute_hearing.description");
        Talent talent2 = new Talent("talent.aethyric_attunement.name", "talent.aethyric_attunement.description");

        talentRepository.saveAll(Arrays.asList(talent1, talent2));

        // Create skills and associate them with talents
        Skill skill1 = new Skill("skill.academic_knowledge.name", AdvancedEnum.ADVANCED, CharacteristicEnum.INTELLIGENCE, "skill.academic_knowledge.description");
        Skill skill2 = new Skill("skill.animal_care.name", AdvancedEnum.BASIC, CharacteristicEnum.INTELLIGENCE, "skill.animal_care.description");

        skill1.setTalents(new HashSet<>(Arrays.asList(talent1, talent2)));
        skill2.setTalents(new HashSet<>(Arrays.asList(talent2)));

        skillRepository.saveAll(Arrays.asList(skill1, skill2));
    }

    @GetMapping("/carrers")
    public void getMethodName() {
        // Create career entries
        Career career1 = new Career();
        career1.setName("Career 1");
        career1.setDescription("Description for Career 1");

        Career career2 = new Career();
        career2.setName("Career 2");
        career2.setDescription("Description for Career 2");

        // Create career exits
        Career career3 = new Career();
        career3.setName("Career 3");
        career3.setDescription("Description for Career 3");

        Career career4 = new Career();
        career4.setName("Career 4");
        career4.setDescription("Description for Career 4");

        // Establish connections between careers
        career1.setCareerEntries(new HashSet<>(Arrays.asList(career2)));
        career2.setCareerEntries(new HashSet<>(Arrays.asList(career3)));
        career3.setCareerEntries(new HashSet<>(Arrays.asList(career4)));
        career4.setCareerEntries(new HashSet<>(Arrays.asList(career1)));

        careerRepository.saveAll(Arrays.asList(career1, career2, career3, career4));
    }
    
}
