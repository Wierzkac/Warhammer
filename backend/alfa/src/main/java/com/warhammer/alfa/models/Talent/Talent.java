package com.warhammer.alfa.models.Talent;

import java.util.Set;

import com.warhammer.alfa.models.WarhammerObject.WarhammerObject;

import com.warhammer.alfa.models.Skill.Skill;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "talents")
public class Talent extends WarhammerObject {

    @ManyToMany(mappedBy = "talents", fetch = FetchType.EAGER)
    protected Set<Skill> skills;

    public Talent(){}
    public Talent(String name, String description){
        this.name = name;
        this.description = description;
    }
}
