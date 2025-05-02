package com.warhammer.alfa.models.Career;

import java.util.*;

import lombok.Data;

@Data
public class CareerDTO {
    private int id;
    private String name;
    private String description;
    private String type;
    
    private List<Map<String, Object>> careerEntries;
    private List<Map<String, Object>> careerExits;
}
