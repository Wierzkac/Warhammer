package com.warhammer.alfa.models.Talent;

import org.springframework.stereotype.Service;

import com.warhammer.alfa.models.Skill.Skill;
import com.warhammer.alfa.models.Skill.SkillDTO;

import java.util.*;

@Service
public class TalentService {

    final private TalentRepository talentRepository;

    TalentService(TalentRepository talentRepository) {
        this.talentRepository = talentRepository;
    }

    public List<TalentDTO> getAllTalents() {
        List<Talent> talents = (List<Talent>) talentRepository.findAllWithSkills();
        return talents.stream().map(this::convertToDTO).toList();
    }

    public TalentDTO getTalent(int id) {
        return convertToDTO(talentRepository.findById(id).orElseThrow());
    }

    public void createNewTalent(Talent newTalent) {
        talentRepository.save(newTalent);
    }

    public void updateTalent(int id, Talent talent) {
        talentRepository.save(talent);
    }

    public void deleteTalent(int id) {
        talentRepository.deleteById(id);
    }

    

    private TalentDTO convertToDTO(Talent talent) {
        TalentDTO talentDTO = new TalentDTO();
        talentDTO.setId(talent.getId());
        talentDTO.setName(talent.getName());
        talentDTO.setDescription(talent.getDescription());
        
        List<Map<String, String>> skills = new ArrayList<>();
        talent.getSkills().stream().forEach(skill -> {
            Map<String, String> subSkill = new HashMap<>();
            subSkill.put("id", String.valueOf(skill.getId()));
            subSkill.put("name", skill.getName());
            skills.add(subSkill);
        });

        talentDTO.setSkills(skills);
        return talentDTO;
    }
}
