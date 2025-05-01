package com.warhammer.alfa.models.Skill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;

import java.util.*;

@Service
public class SkillService {

    @Autowired
    EntityManager entityManager;

    final private SkillRepository skillRepository;

    SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public List<SkillDTO> getAllSkills() {
        List<Skill> skills = skillRepository.findAll();
        return skills.stream().map(this::convertToDTO).toList();
    }

    public SkillDTO getSkill(int id) {
        return convertToDTO(skillRepository.findById(id).orElseThrow());
    }

    public void createNewSkill(Skill newSkill) {
        skillRepository.save(newSkill);
    }

    public void updateSkill(int id, Skill skill) {
        skillRepository.save(skill);
    }

    public void deleteSkill(int id) {
        skillRepository.deleteById(id);
    }

    

    private SkillDTO convertToDTO(Skill skill) {
        SkillDTO skillDTO = new SkillDTO();
        skillDTO.setId(skill.getId());
        skillDTO.setName(skill.getName());
        skillDTO.setType(skill.getType().getValue());
        skillDTO.setCharacteristic(skill.getCharacteristic().getValue());
        skillDTO.setDescription(skill.getDescription());
        
        List<Map<String, Object>> talents = new ArrayList<>();
        skill.getTalents().stream().forEach(talent -> {
            Map<String, Object> subTalent = new HashMap<>();
            subTalent.put("id", talent.getId());
            subTalent.put("name", talent.getName());
            talents.add(subTalent);
        });

        skillDTO.setTalents(talents);
        return skillDTO;
    }
}
