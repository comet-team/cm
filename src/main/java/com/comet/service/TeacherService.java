package com.comet.service;

import com.comet.model.dto.ExternalStudent;
import com.comet.model.dto.ExternalTeacher;
import com.comet.model.entity.Student;
import com.comet.model.entity.Teacher;
import com.comet.repository.StudentRepository;
import com.comet.repository.TeacherRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TeacherService extends ModelMapper {

    @Autowired
    private TeacherRepository teacherRepository;

    public Teacher createTeacher(ExternalTeacher externalTeacher) {
        Teacher teacher = this.map(externalTeacher, Teacher.class);
        return teacherRepository.save(teacher);
    }

    public Teacher getTeacher(UUID id) {
        return teacherRepository.findById(id).orElse(null);
    }

    public List<Teacher> getAllTeacher() {
        List<Teacher> result = new ArrayList<>();
        teacherRepository.findAll().iterator().forEachRemaining(result::add);
        return result;
    }

}
