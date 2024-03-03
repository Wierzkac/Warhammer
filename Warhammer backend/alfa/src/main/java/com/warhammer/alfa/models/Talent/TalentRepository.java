package com.warhammer.alfa.models.Talent;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;;

@Repository
public interface TalentRepository extends CrudRepository<Talent, Integer> {

    @Query("SELECT t FROM Talent t LEFT JOIN FETCH t.skills")
    List<Talent> findAllWithSkills();

}
