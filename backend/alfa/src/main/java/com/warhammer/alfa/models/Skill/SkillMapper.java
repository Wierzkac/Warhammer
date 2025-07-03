package com.warhammer.alfa.models.Skill;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.warhammer.alfa.models.Talent.Talent;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface SkillMapper {
    
    @Mapping(target = "type", source = "type.value")
    @Mapping(target = "characteristic", source = "characteristic.value")
    @Mapping(target = "talents", source = "talents", qualifiedByName = "talentsToMap")
    SkillDTO toDTO(Skill skill);

    List<SkillDTO> toDTOList(List<Skill> skills);

    @Named("talentsToMap")
    static List<Map<String, Object>> talentsToMap(Set<Talent> talents) {
        if (talents == null) {
            return List.of();
        }
        
        return talents.stream().map(talent -> {
            Map<String, Object> talentMap = new HashMap<>();
            talentMap.put("id", talent.getId());
            talentMap.put("name", talent.getName());
            return talentMap;
        }).toList();
    }
} 