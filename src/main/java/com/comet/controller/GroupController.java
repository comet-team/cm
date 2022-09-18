package com.comet.controller;

import com.comet.model.dto.ExternalStudentGroup;
import com.comet.model.entity.StudentGroup;
import com.comet.service.GroupService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/group")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @ApiOperation("Create group")
    @PostMapping
    public StudentGroup createGroup(@RequestBody ExternalStudentGroup externalGroup) {
        return groupService.createGroup(externalGroup);
    }

    @ApiOperation("Get group by id")
    @GetMapping("/{id}")
    @ApiResponse(code = 404, message = "Student with specified id does not exist")
    public StudentGroup getGroup(@PathVariable(value = "id") UUID id) {
        return groupService.getGroup(id);
    }

    @ApiOperation("Get all groups")
    @GetMapping
    public List<StudentGroup> getAllGroups() {
        return groupService.getAllGroups();
    }

    @ApiOperation("Assign student to a group")
    @PutMapping("/add_student")
    @ApiResponses({
            @ApiResponse(code = 404, message = "Group or student with specified ID does not exist"),
            @ApiResponse(code = 400, message = "Student is already assigned"),
    })
    public StudentGroup assignStudent(@RequestParam(value = "groupId") UUID groupId,
                                     @RequestParam(value = "studentId") UUID studentID) {
        return groupService.assignStudent(groupId, studentID);
    }
}
