package com.esig.helder.desafio.backend.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.esig.helder.desafio.backend.model.User;

public interface UserRepo extends CrudRepository<User, Long>{
  Optional<User> findByName(String name);
}
