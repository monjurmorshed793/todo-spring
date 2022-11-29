package com.morshed.todo.task.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "task")
public class Task {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @NotEmpty
  @Column(name = "title", length = 100)
  private String title;

  @Column(name = "description")
  private String description;

  @NotEmpty
  @Column(name="created_date")
  private LocalDate createdDate;

  @OneToMany(cascade = CascadeType.ALL)
  private List<TaskRevision> revisions;

  @OneToMany(cascade = CascadeType.ALL)
  private List<TaskDetails> taskDetails;
}
