package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class BaseEntity {
  @Id
  @GeneratedValue(
          strategy = GenerationType.IDENTITY
  )
  private Integer id;

  private LocalDateTime createdAt;
  private LocalDateTime lastModifiedAt;

  private String createdBy;
  private String lastModifiedBy;
}
