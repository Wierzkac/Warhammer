package com.warhammer.alfa.models.Character;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import com.warhammer.alfa.enums.CharacteristicEnum;
import com.warhammer.alfa.models.Career.CareerMapper;
import com.warhammer.alfa.models.Skill.SkillMapper;
import com.warhammer.alfa.models.Talent.TalentMapper;

import java.util.*;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {CareerMapper.class, SkillMapper.class, TalentMapper.class})
public interface CharacterMapper {

    @Mapping(target = "raceName", source = "race.raceEnum.value")
    @Mapping(target = "genderName", source = "gender.value")
    @Mapping(target = "characteristics", source = "characteristics", qualifiedByName = "characteristicsToMap")
    @Mapping(target = "currentCareer", source = "currentCareer")
    @Mapping(target = "talents", source = "talents")
    @Mapping(target = "skills", source = "skills")
    CharacterDTO toDTO(Character character);

    List<CharacterDTO> toDTOList(List<Character> characters);

    @Named("characteristicsToMap")
    static Map<String, Integer> characteristicsToMap(Map<CharacteristicEnum, Integer> characteristics) {
        if (characteristics == null) {
            return new HashMap<>();
        }
        return characteristics.entrySet().stream()
            .collect(Collectors.toMap(
                entry -> entry.getKey().getValue(),
                Map.Entry::getValue
            ));
    }
}