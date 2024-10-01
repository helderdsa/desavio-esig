package com.esig.helder.desafio.backend.repo;

import com.esig.helder.desafio.backend.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TaskRepo extends JpaRepository<Task, Long>, JpaSpecificationExecutor<Task> {
}
