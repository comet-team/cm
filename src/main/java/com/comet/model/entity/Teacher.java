package com.comet.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String surname;
    @Column(name = "tg_link")
    private String tgLink;

    public Teacher(String name, String surname, String tgLink) {
        this.name = name;
        this.surname = surname;
        this.tgLink = tgLink;
    }
}


