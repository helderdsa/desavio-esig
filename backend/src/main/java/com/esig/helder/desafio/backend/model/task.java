package com.esig.helder.desafio.backend.model;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

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

  @DateTimeFormat(pattern = "dd/mm/yyyy")
  private Date deadline;

  @ManyToOne
  @JoinColumn(name = "owner_id")
  private Owner owner;
}

enum Priority {
  HIGH,
  MID,
  LOW
}

enum Status {
  DONE,
  ON_GOING
}
