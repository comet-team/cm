package com.comet.controller;

import com.comet.model.dto.ExternalStudent;
import com.comet.model.entity.Student;
import com.comet.service.StudentService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @ApiOperation("Create student")
    @PostMapping
    public Student createStudent(@RequestBody ExternalStudent externalStudent) {
        return studentService.createStudent(externalStudent);
    }

    @ApiOperation("Get student by id")
    @GetMapping("/{id}")
    @ApiResponse(code = 404, message = "Student with specified id does not exist")
    public Student getStudent(@PathVariable(value = "id") UUID id) {
        return studentService.getStudent(id);
    }

    @ApiOperation("Get all students")
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
}
