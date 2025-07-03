package com.warhammer.alfa.models.Skill;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer> {

    Skill findByName(String name);
    List<Skill> findByNameIn(List<String> names);
}
