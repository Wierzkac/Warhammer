package com.warhammer.alfa.models.Career;

import java.util.*;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CareerRepository extends CrudRepository<Career, Integer> {

    @Query("SELECT c FROM Career c LEFT JOIN FETCH c.careerEntries LEFT JOIN FETCH c.careerExits")
    List<Career> findAllWithCareers();
    
}
