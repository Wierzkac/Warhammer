package com.warhammer.alfa.models.Talent;

import java.util.Set;

import org.hibernate.annotations.GenericGenerator;

import com.warhammer.alfa.models.Skill.Skill;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "talents")
public class Talent {

    @Id
    @GeneratedValue(
        strategy= GenerationType.AUTO,
        generator="native"
    )
    @GenericGenerator(
        name = "native",
        strategy = "native"
    )
    protected int id;
    protected String name;
    protected String description;

    @ManyToMany(mappedBy = "talents", fetch = FetchType.EAGER)
    protected Set<Skill> skills;

    public Talent(){}
    public Talent(String name, String description){
        this.name = name;
        this.description = description;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Talent other = (Talent) obj;
        return name == other.name;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(id);
    }
}
