package com.comet.controller;

import com.comet.model.dto.ExternalSubjectGroup;
import com.comet.model.entity.SubjectGroup;
import com.comet.service.SubjectGroupService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/subject_group")
public class SubjectGroupController {

    @Autowired
    private SubjectGroupService subjectGroupService;

    @ApiOperation("Create subject group")
    @PostMapping
    public SubjectGroup createSubjectGroup(@RequestBody ExternalSubjectGroup externalSubjectGroup) {
        return subjectGroupService.createSubjectGroup(externalSubjectGroup);
    }

    @ApiOperation("Get subject group by id")
    @GetMapping("/{id}")
    @ApiResponse(code = 404, message = "Subject group with specified id does not exist")
    public SubjectGroup getSubjectGroup(@PathVariable(value = "id") UUID id) {
        return subjectGroupService.getGroup(id);
    }

    @ApiOperation("Get all subject groups")
    @GetMapping
    public List<SubjectGroup> getAllSubjectGroups() {
        return subjectGroupService.getAllGroups();
    }

    @ApiOperation("Assign student to a subject group")
    @PutMapping("/add_student")
    @ApiResponses({
            @ApiResponse(code = 404, message = "Subject group or student with specified ID does not exist"),
            @ApiResponse(code = 400, message = "Student is already assigned"),
    })
    public SubjectGroup assignStudent(@RequestParam(value = "subjectGroupId") UUID groupId,
                                       @RequestParam(value = "studentId") UUID studentID) {
        return subjectGroupService.assignStudent(groupId, studentID);
    }

    @ApiOperation("Assign all students from particular group to a subject group")
    @PutMapping("/add_group")
    @ApiResponses({
            @ApiResponse(code = 404, message = "Subject group or student group with specified ID does not exist"),
    })
    public SubjectGroup assignGroup(@RequestParam(value = "subjectGroupId") UUID subjectGroupId,
                                      @RequestParam(value = "studentGroupId") UUID studentGroupId) {
        return subjectGroupService.assignStudentGroup(subjectGroupId, studentGroupId);
    }
}
