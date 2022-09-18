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
@Table(name = "created_group_chats")
@ToString
public class CreatedGroupChat {
    @Id
    @GeneratedValue
    private UUID id;
    private String title;
    private String link;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "group_id")
    private StudentGroup studentGroup = null;

    public CreatedGroupChat(String title, String link, StudentGroup studentGroup) {
        this.title = title;
        this.link = link;
        this.studentGroup = studentGroup;
    }
}


