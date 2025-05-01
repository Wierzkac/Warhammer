package com.warhammer.alfa.models.Skill;

import java.util.*;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends CrudRepository<Skill, Integer> {

    List<Skill> findAll();
}
