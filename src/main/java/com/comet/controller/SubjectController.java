package com.comet.controller;

import com.comet.model.dto.ExternalSubject;
import com.comet.model.dto.ExternalTeacher;
import com.comet.model.entity.Subject;
import com.comet.service.SubjectService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @ApiOperation("Create subject")
    @PostMapping
    public Subject createSubject(@RequestBody ExternalSubject externalSubject) {
        return subjectService.createSubject(externalSubject);
    }

    @ApiOperation("Get subject by id")
    @GetMapping("/{id}")
    @ApiResponse(code = 404, message = "Subject with specified id does not exist")
    public Subject getSubject(@PathVariable(value = "id") UUID id) {
        return subjectService.getSubject(id);
    }

    @ApiOperation("Get all subjects")
    @GetMapping
    public List<Subject> getAllSubjects() {
        return subjectService.getAllSubjects();
    }
}
