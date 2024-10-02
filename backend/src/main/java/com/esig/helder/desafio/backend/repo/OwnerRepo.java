package com.esig.helder.desafio.backend.repo;

import org.springframework.data.repository.CrudRepository;

import com.esig.helder.desafio.backend.model.Owner;

public interface OwnerRepo extends CrudRepository<Owner, Long>{
  
}
