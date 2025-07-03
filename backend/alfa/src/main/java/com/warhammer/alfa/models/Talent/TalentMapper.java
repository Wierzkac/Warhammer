package com.warhammer.alfa.models.Talent;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.warhammer.alfa.models.Skill.Skill;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface TalentMapper {
    
    @Mapping(target = "skills", source = "skills", qualifiedByName = "skillsToMap")
    TalentDTO toDTO(Talent talent);

    List<TalentDTO> toDTOList(List<Talent> talents);

    @Named("skillsToMap")
    static List<Map<String, Object>> skillsToMap(Set<Skill> skills) {
        if (skills == null) {
            return List.of();
        }
        
        return skills.stream().map(skill -> {
            Map<String, Object> skillMap = new HashMap<>();
            skillMap.put("id", skill.getId());
            skillMap.put("name", skill.getName());
            return skillMap;
        }).toList();
    }
} 