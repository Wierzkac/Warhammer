package com.warhammer.alfa.models.Skill;

import com.warhammer.alfa.models.WarhammerObject.WarhammerObject;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;

import org.hibernate.annotations.GenericGenerator;

import com.warhammer.alfa.enums.AdvancedEnum;
import com.warhammer.alfa.enums.CharacteristicEnum;
import com.warhammer.alfa.models.Talent.Talent;

@Data
@Entity
@Table(name="skills")
public class Skill extends WarhammerObject {

    @Enumerated(EnumType.STRING)
    protected AdvancedEnum type;
    
    @Enumerated(EnumType.STRING)
    protected CharacteristicEnum characteristic;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "skills_talents", 
        joinColumns = {
            @JoinColumn(name = "skill_id", referencedColumnName = "id")
        },
        inverseJoinColumns = {
            @JoinColumn(name = "talent_id", referencedColumnName = "id")
        }
    )
    protected Set<Talent> talents;

    public Skill(){}
    public Skill(String name, AdvancedEnum type, CharacteristicEnum characteristic, String description) {
        this.name = name;
        this.type = type;
        this.characteristic = characteristic;
        this.description = description;
    }
}
