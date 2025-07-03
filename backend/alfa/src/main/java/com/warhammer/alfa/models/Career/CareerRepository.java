package com.warhammer.alfa.models.Career;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CareerRepository extends JpaRepository<Career, Integer> {

    Career findByName(String name);
}
