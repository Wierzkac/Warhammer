package com.warhammer.alfa.models.Skill;

import org.springframework.web.bind.annotation.*;
import java.util.*;


@RestController
@RequestMapping("skills")
public class SkillController {

    final private SkillService skillService;

    SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @GetMapping
    public List<SkillDTO> getAllSkills() {
        return skillService.getAllSkills();
    }

    @GetMapping("/{id}")
    public SkillDTO getSkill(@PathVariable int id) {
        return skillService.getSkill(id);
    }
}