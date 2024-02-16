package com.warhammer.alfa.models.Talent;

import jakarta.persistence.*;
import lombok.Data;

import com.warhammer.alfa.exceptions.InvalidParametersException;

@Data
@Entity
@Table(name = "Talents")
public class Talent {

    @Id
    protected int id;
    protected String name;
    protected String description;

    Talent() throws InvalidParametersException {
        throw new InvalidParametersException("Not enought parameters to create a Talent!");
    }

    Talent(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
