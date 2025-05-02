package com.warhammer.alfa.models.Talent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TalentRepository extends JpaRepository<Talent, Integer> {

    List<Talent> findAll();
}
