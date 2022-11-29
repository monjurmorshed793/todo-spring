package com.morshed.todo.task.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.type.YesNoConverter;

import java.io.File;
import java.time.Instant;
import java.util.UUID;

@Data
@Entity
@Table(name = "task_details")
public class TaskDetails {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @ManyToOne
  private Task task;

  @Column(name="title")
  private String title;

  @Column(name = "image_link")
  private String imageLink;

  @Transient
  private File image;

  @Column(name="is_done", length = 1)
  @Convert(converter = YesNoConverter.class)
  private Boolean isDone;

  @Column(name="created_on")
  private Instant createdOn;

  @Column(name="done_on")
  private Instant doneOn;
}
