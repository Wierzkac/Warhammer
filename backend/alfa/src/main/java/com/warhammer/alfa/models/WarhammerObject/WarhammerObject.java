package com.warhammer.alfa.models.WarhammerObject;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;

@MappedSuperclass
@Data
public abstract class WarhammerObject {

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        WarhammerObject other = (WarhammerObject) obj;
        return Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Long.hashCode(id);
    }
}
