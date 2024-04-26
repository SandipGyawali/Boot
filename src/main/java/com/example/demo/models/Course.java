package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.*;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "course")
@EqualsAndHashCode(callSuper = true)
public class Course extends BaseEntity{
  private String title;
  private String description;

  @ManyToMany(
          mappedBy = "courses"
  )
  private List<Author> authors;

  @OneToMany
  private List<Section> sections;
}
