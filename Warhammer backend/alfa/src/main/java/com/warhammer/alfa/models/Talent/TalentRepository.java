package com.warhammer.alfa.models.Talent;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;;

@Repository
public interface TalentRepository extends CrudRepository<Talent, Integer> {

}
