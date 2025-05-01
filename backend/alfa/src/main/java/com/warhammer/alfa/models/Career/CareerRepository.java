package com.warhammer.alfa.models.Career;

import java.util.*;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CareerRepository extends CrudRepository<Career, Integer> {

    List<Career> findAll();
}
