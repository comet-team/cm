package com.comet.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "subject_groups")
@ToString
public class SubjectGroup {
    @Id
    @GeneratedValue
    private UUID id;
    private String title;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "subjectGroup")
    private Set<Student> students = new HashSet<>();
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher = null;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subject_id")
    private Subject subject = null;
    @Column(name = "chat_id")
    private String chatId;

    public SubjectGroup(String title) {
        this.title = title;
    }
}


