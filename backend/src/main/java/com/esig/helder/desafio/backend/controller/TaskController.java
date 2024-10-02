package com.esig.helder.desafio.backend.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.esig.helder.desafio.backend.enums.Priority;
import com.esig.helder.desafio.backend.enums.Status;
import com.esig.helder.desafio.backend.model.Task;
import com.esig.helder.desafio.backend.repo.TaskRepo;
import com.esig.helder.desafio.backend.utils.TaskSpecification;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/task")
public class TaskController {

  @Autowired
  private TaskRepo repo;

  @PostMapping
  public ResponseEntity<Task> createTask(@RequestBody Task t) {
    Task savedTask = repo.save(t);
    return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<Iterable<Task>> getTasks() {
    Iterable<Task> tasks = repo.findAll();
    return new ResponseEntity<>(tasks, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Task> getTask(@PathVariable Long id) {
    Optional<Task> optionalTask = repo.findById(id);

    if (!optionalTask.isPresent()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(optionalTask.get(), HttpStatus.OK);
  }

  @GetMapping("/search")
  public ResponseEntity<List<Task>> searchTasks(
      @RequestParam(required = false) String title,
      @RequestParam(required = false) Status status,
      @RequestParam(required = false) String description,
      @RequestParam(required = false) Priority priority,
      @RequestParam(required = false) LocalDate deadline,
      @RequestParam(required = false) Long ownerId) {
    Specification<Task> spec = Specification.where(
        TaskSpecification.hasTitle(title)
            .and(TaskSpecification.hasStatus(status))
            .and(TaskSpecification.hasDescription(description))
            .and(TaskSpecification.hasPriority(priority))
            .and(TaskSpecification.hasDeadline(deadline))
            .and(TaskSpecification.hasOwnerId(ownerId)));
    List<Task> tasks = repo.findAll(spec);
    return ResponseEntity.ok(tasks);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task t) {
    Optional<Task> taskInDb = repo.findById(id);

    if (!taskInDb.isPresent()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    Task existingTask = taskInDb.get();
    existingTask.setTitle(t.getTitle());
    existingTask.setStatus(t.getStatus());
    existingTask.setDescription(t.getDescription());
    existingTask.setPriority(t.getPriority());
    existingTask.setDeadline(t.getDeadline());
    existingTask.setOwner(t.getOwner());

    Task updatedTask = repo.save(existingTask);
    return new ResponseEntity<>(updatedTask, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
    Optional<Task> optionalTask = repo.findById(id);

    if (!optionalTask.isPresent()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    repo.deleteById(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
