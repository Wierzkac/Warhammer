package com.warhammer.alfa.models.Career;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CareerRepository extends JpaRepository<Career, Integer> {

    List<Career> findAll();
}
