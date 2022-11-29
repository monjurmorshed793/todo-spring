package com.morshed.todo.task.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.hibernate.type.YesNoConverter;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@Table(name = "task_revision")
public class TaskRevision {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Enumerated(EnumType.ORDINAL)
  @Column(name = "revision_type")
  private RevisionType revisionType;

  @NotEmpty
  @Column(name = "revision_date")
  private LocalDate revisionDate;

  @ManyToOne
  private Task task;

  @Column(name="is_done", length = 1)
  @Convert(converter = YesNoConverter.class)
  private Boolean isDone;
}
