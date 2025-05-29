package com.warhammer.alfa.models.Character;

import com.warhammer.alfa.enums.GenderEnum;
import com.warhammer.alfa.enums.RaceEnum;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("characters")
public class CharacterController {

    private final CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @PostMapping("/createRandomCharacter")
    public CharacterDTO createRandomCharacter(
            @RequestParam String name,
            @RequestParam RaceEnum race,
            @RequestParam GenderEnum gender) {
        return characterService.createRandomCharacter(name, race, gender);
    }
}
