package com.esig.helder.desafio.backend.repo;

import org.springframework.data.repository.CrudRepository;

import com.esig.helder.desafio.backend.model.Task;

public interface TaskRepo extends CrudRepository<Task, Long> {
  
}
