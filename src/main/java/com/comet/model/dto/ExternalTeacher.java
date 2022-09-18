package com.comet.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExternalTeacher {
    private UUID id;
    private String name;
    private String surname;
    private String tgLink;
}


