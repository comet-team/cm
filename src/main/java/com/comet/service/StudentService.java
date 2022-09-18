package com.comet.service;

import com.comet.model.dto.ExternalStudent;
import com.comet.model.entity.Student;
import com.comet.repository.StudentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class StudentService extends ModelMapper {

    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(ExternalStudent externalStudent) {
        Student student = this.map(externalStudent, Student.class);
        return studentRepository.save(student);
    }

    public Student getStudent(UUID id) {
        return studentRepository.findById(id).orElse(null);
    }

    public List<Student> getAllStudents() {
        List<Student> result = new ArrayList<>();
        studentRepository.findAll().iterator().forEachRemaining(result::add);
        return result;
    }

}
