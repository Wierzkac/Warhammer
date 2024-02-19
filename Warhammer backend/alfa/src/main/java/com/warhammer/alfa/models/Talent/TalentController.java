package com.warhammer.alfa.models.Talent;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("talents")
public class TalentController {

    final private TalentService talentService;

    TalentController(TalentService talentService) {
        this.talentService = talentService;
    }

    @GetMapping
    public List<TalentDTO> getAllTalents() {
        return talentService.getAllTalents();
    }

    @GetMapping("/{id}")
    public TalentDTO getTalent(@PathVariable int id) {
        return talentService.getTalent(id);
    }

    @PostMapping("/")
    public void createNewTalent(@RequestBody Talent newTalent) {
        talentService.createNewTalent(newTalent);
    }

    @PutMapping("/{id}")
    public void updateTalent(@PathVariable int id, @RequestBody Talent talent) {
        talentService.updateTalent(id, talent);
    }

    @DeleteMapping("/{id}")
    public void deleteTalent(@PathVariable int id) {
        talentService.deleteTalent(id);
    }
}