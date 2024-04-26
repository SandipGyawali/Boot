package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.*;

@Data
@Table(name = "Author")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@Entity
public class Author extends BaseEntity {
    @Column(
            length = 50
    )
    private String firstName;
    private String lastName;

    @Column(
            unique = true,
            nullable = false
    )
    private String email;

    @ManyToMany
    @JoinTable(
            name = "authors_courses",
            joinColumns = {
                    @JoinColumn(name = "course_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "author_id")
            }
    )
    private List<Course> courses;

//    @Column(
//            updatable = false,
//            nullable = false
//    )
//    private LocalDateTime createdAt;
//
//    @Column(
//            insertable = false
//    )
//    private LocalDateTime lastModified;
}
