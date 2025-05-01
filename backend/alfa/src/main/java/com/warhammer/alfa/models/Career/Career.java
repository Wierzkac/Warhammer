package com.warhammer.alfa.models.Career;

import java.util.Set;

import com.warhammer.alfa.enums.AdvanceLevelEnum;
import com.warhammer.alfa.models.WarhammerObject.WarhammerObject;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="careers")
public class Career extends WarhammerObject {

    @Enumerated(EnumType.STRING)
    protected AdvanceLevelEnum type;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "careers_careers", 
        joinColumns = {
            @JoinColumn(name = "career_entry", referencedColumnName = "id")
        },
        inverseJoinColumns = {
            @JoinColumn(name = "career_exit", referencedColumnName = "id")
        }
    )
    protected Set<Career> careerEntries;

    @ManyToMany(mappedBy = "careerEntries", fetch = FetchType.EAGER)
    protected Set<Career> careerExits;
    
    public Career(){}
    public Career(String name, String description){
        this.name = name;
        this.description = description;
    }
}
