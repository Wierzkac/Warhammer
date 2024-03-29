package com.warhammer.alfa.models.Career;

import java.util.*;

import lombok.Data;

@Data
public class CareerDTO {
    private int id;
    private String name;
    private String description;
    
    private List<Map<String, String>> careerEntries;
    private List<Map<String, String>> careerExits;
}
