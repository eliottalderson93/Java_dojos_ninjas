package com.erik.dojo_ninjas.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.erik.dojo_ninjas.models.Dojo;

@Repository
public interface DojoRepo extends CrudRepository<Dojo, Long> {

}
