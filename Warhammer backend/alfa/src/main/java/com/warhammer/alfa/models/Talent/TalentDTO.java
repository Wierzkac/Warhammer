package com.warhammer.alfa.models.Talent;

import java.util.*;

import lombok.Data;

@Data
public class TalentDTO {
    private int id;
    private String name;
    private String description;
    private List<Map<String, String>> skills;
}
