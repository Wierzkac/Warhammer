package com.warhammer.alfa.models.Skill;

import java.util.*;

import lombok.Data;

@Data
public class SkillDTO {
    private int id;
    private String name;
    private String type;
    private String characteristic;
    private String description;
    private List<Map<String, Object>> talents;
}
