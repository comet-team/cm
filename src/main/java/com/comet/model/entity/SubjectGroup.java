package com.comet.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

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
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id")
    private Set<Student> students = new HashSet<>();
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher = null;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subject_id")
    private Subject subject = null;
    @Column(name = "chat_id")
    private String chatId;

    public SubjectGroup(String title, Set<Student> students, Teacher teacher, Subject subject) {
        this.title = title;
        this.students = students;
        this.teacher = teacher;
        this.subject = subject;
    }
}


