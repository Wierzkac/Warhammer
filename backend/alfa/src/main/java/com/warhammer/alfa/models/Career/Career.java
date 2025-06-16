package com.warhammer.alfa.models.Career;

import java.util.Set;

import com.fasterxml.jackson.annotation.*;
import com.warhammer.alfa.enums.AdvanceLevelEnum;
import com.warhammer.alfa.models.WarhammerObject.WarhammerObject;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "careers")
@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true, exclude = {"careerEntries", "careerExits"})
public class Career extends WarhammerObject {

    @Enumerated(EnumType.STRING)
    protected AdvanceLevelEnum type;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "careers_careers", 
        joinColumns = {
            @JoinColumn(name = "career_entry", referencedColumnName = "id")
        },
        inverseJoinColumns = {
            @JoinColumn(name = "career_exit", referencedColumnName = "id")
        }
    )
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    protected Set<Career> careerEntries;

    @ManyToMany(mappedBy = "careerEntries", fetch = FetchType.LAZY)
    @JsonIgnore
    protected Set<Career> careerExits;
    
    public Career(){}
}
