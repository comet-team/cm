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
@Table(name = "student_groups")
@ToString
public class StudentGroup {
    @Id
    @GeneratedValue
    private UUID id;
    private String title;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id")
    private Set<Student> students = new HashSet<>();
    @Column(name = "is_chat_created")
    private Boolean isChatCreated;
    @Column(name = "chat_id")
    private String chatId;

    public StudentGroup(String title) {
        this.title = title;
    }
}


