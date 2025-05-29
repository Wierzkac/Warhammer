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
}