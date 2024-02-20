package com.warhammer.alfa.models.Career;

import java.util.Set;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="careers")
public class Career {
    
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Career other = (Career) obj;
        return name == other.name;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(id);
    }

}
