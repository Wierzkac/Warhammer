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

    @PostMapping("/")
    public void createNewSkill(@RequestBody Skill newSkill) {
        skillService.createNewSkill(newSkill);
    }

    @PutMapping("/{id}")
    public void updateSkill(@PathVariable int id, @RequestBody Skill skill) {
        skillService.updateSkill(id, skill);
    }

    @DeleteMapping("/{id}")
    public void deleteSkill(@PathVariable int id) {
        skillService.deleteSkill(id);
    }
}