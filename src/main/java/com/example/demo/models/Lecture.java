package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@SuperBuilder
@Table(name = "lecture")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Lecture extends BaseEntity{
  @Column(
          nullable = false
  )
  private String name;

  @ManyToOne
  @JoinColumn(
          name = "section_id"
  )
  private Section section;

  @OneToOne
  @JoinColumn(
          name = "resource_id"
  )
  private Resource resource;
}