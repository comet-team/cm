package com.comet.controller;

import com.comet.model.dto.ExternalStudent;
import com.comet.model.dto.ExternalTeacher;
import com.comet.model.entity.Teacher;
import com.comet.service.TeacherService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @ApiOperation("Create teacher")
    @PostMapping
    public Teacher createTeacher(@RequestBody ExternalTeacher externalTeacher) {
        return teacherService.createTeacher(externalTeacher);
    }

    @ApiOperation("Get teacher by id")
    @GetMapping("/{id}")
    @ApiResponse(code = 404, message = "Teacher with specified id does not exist")
    public Teacher getTeacher(@PathVariable(value = "id") UUID id) {
        return teacherService.getTeacher(id);
    }

    @ApiOperation("Get all teachers")
    @GetMapping
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeacher();
    }
}
