package com.comet.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExternalSubjectGroup {
    private String title;
    private List<UUID> students;
    private UUID teacher;
    private UUID subject;
}


