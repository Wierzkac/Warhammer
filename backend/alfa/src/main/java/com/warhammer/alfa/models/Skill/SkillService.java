package com.warhammer.alfa.models.Skill;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SkillService {

    final private SkillRepository skillRepository;
    final private SkillMapper skillMapper;

    SkillService(SkillRepository skillRepository, SkillMapper skillMapper) {
        this.skillRepository = skillRepository;
        this.skillMapper = skillMapper;
    }

    public List<SkillDTO> getAllSkills() {
        List<Skill> skills = skillRepository.findAll();
        return skillMapper.toDTOList(skills);
    }

    public SkillDTO getSkill(int id) {
        return skillMapper.toDTO(skillRepository.findById(id).orElseThrow());
    }
}
