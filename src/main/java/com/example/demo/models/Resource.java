package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "resources")
@EqualsAndHashCode(callSuper = true)
public class Resource extends BaseEntity{
  private String name;
  private int size;
  private String url;

  @OneToOne
  @JoinColumn(
          name = "lecture_id"
  )
  private Lecture lecture;
}
