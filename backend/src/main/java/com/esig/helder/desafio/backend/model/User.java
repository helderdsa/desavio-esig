package com.esig.helder.desafio.backend.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.esig.helder.desafio.backend.repo.UserRepo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

  @Autowired
  private UserRepo repo;

  @Autowired
  private BCryptPasswordEncoder passwordEncoder;

  @PostMapping
  public ResponseEntity<User> createUser(@RequestBody User u) {
    u.setPassword(passwordEncoder.encode(u.getPassword()));
    User savedUser = repo.save(u);
    return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String name;

  private String password;
}