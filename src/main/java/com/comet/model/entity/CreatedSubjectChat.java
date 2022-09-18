package com.comet.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "created_subject_chats")
@ToString
public class CreatedSubjectChat {
    @Id
    @GeneratedValue
    private UUID id;
    private String title;
    private String link;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "group_id")
    private SubjectGroup subjectGroup = null;

    public CreatedSubjectChat(String title, String link, SubjectGroup subjectGroup) {
        this.title = title;
        this.link = link;
        this.subjectGroup = subjectGroup;
    }
}


