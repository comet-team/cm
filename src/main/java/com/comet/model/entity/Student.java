package com.comet.model.entity;

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
    @GeneratedValue
    private UUID id;
    private String name;
    private String surname;
    @Column(name = "tg_link")
    private String tgLink;

    public Student(String name, String surname, String tgLink) {
        this.name = name;
        this.surname = surname;
        this.tgLink = tgLink;
    }
}


