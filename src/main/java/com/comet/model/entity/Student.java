package com.comet.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.swing.*;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "students")
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String surname;
    @Column(name = "tg_link")
    private String tgLink;
    @ManyToOne
    @JoinColumn(name = "student_group_id")
    @JsonIgnore
    private StudentGroup studentGroup;
    @ManyToOne
    @JoinColumn(name = "subject_group_id")
    @JsonIgnore
    private SubjectGroup subjectGroup;

    public Student(String name, String surname, String tgLink) {
        this.name = name;
        this.surname = surname;
        this.tgLink = tgLink;
    }
}


