package com.warhammer.alfa.models.Career;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface CareerMapper {
    
    @Mapping(target = "type", source = "type.value")
    @Mapping(target = "careerEntries", source = "careerEntries", qualifiedByName = "careerEntriesToMap")
    @Mapping(target = "careerExits", source = "careerExits", qualifiedByName = "careerExitsToMap")
    CareerDTO toDTO(Career career);

    List<CareerDTO> toDTOList(List<Career> careers);

    @Named("careerEntriesToMap")
    static List<Map<String, Object>> careerEntriesToMap(Set<Career> entries) {
        if (entries == null) {
            return new ArrayList<>();
        }
        
        return entries.stream().map(entry -> {
            Map<String, Object> entryMap = new HashMap<>();
            entryMap.put("id", entry.getId());
            entryMap.put("name", entry.getName());
            return entryMap;
        }).toList();
    }

    @Named("careerExitsToMap")
    static List<Map<String, Object>> careerExitsToMap(Set<Career> exits) {
        if (exits == null) {
            return new ArrayList<>();
        }
        
        return exits.stream().map(exit -> {
            Map<String, Object> exitMap = new HashMap<>();
            exitMap.put("id", exit.getId());
            exitMap.put("name", exit.getName());
            return exitMap;
        }).toList();
    }
} 