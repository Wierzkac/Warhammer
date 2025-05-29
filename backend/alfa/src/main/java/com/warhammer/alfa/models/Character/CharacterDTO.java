package com.warhammer.alfa.models.Character;

import com.warhammer.alfa.models.Career.CareerDTO;
import com.warhammer.alfa.models.Skill.SkillDTO;
import com.warhammer.alfa.models.Talent.TalentDTO;
import lombok.Data;

import java.util.Map;
import java.util.Set;

@Data
public class CharacterDTO {

    private String name;
    private String raceName;
    private String genderName;
    private Map<String, Integer> characteristics;
    private CareerDTO currentCareer;
    private Set<TalentDTO> talents;
    private Set<SkillDTO> skills;
}
