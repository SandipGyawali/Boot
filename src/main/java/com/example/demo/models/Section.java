package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "section")
@EqualsAndHashCode(callSuper = true)
public class Section extends BaseEntity{
  private String name;
  private String sectionOrder;

  @ManyToOne
  @JoinColumn(name = "course_id")
  private Course course;

  @OneToMany(mappedBy = "section")
  private List<Lecture> lectures;
}