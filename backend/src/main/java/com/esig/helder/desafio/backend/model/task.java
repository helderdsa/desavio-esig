package com.esig.helder.desafio.backend.model;

import org.springframework.format.annotation.DateTimeFormat;

import com.esig.helder.desafio.backend.enums.Priority;
import com.esig.helder.desafio.backend.enums.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "tasks")
@Getter
@Setter
public class Task {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String title;

  @Enumerated(EnumType.STRING)
  private Status status;

  private String description;

  @Enumerated(EnumType.STRING)
  private Priority priority;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate deadline;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;
}