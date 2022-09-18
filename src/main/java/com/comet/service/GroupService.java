package com.comet.service;

import com.comet.model.dto.ExternalStudent;
import com.comet.model.dto.ExternalStudentGroup;
import com.comet.model.dto.ExternalSubjectGroup;
import com.comet.model.entity.Student;
import com.comet.model.entity.StudentGroup;
import com.comet.repository.StudentGroupRepository;
import com.comet.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class GroupService extends ModelMapper {

    @Autowired
    private StudentGroupRepository studentGroupRepository;
    @Autowired
    private StudentRepository studentRepository;

    public StudentGroup createGroup(ExternalStudentGroup externalStudentGroup) {
        StudentGroup group = this.map(externalStudentGroup, StudentGroup.class);
        return studentGroupRepository.save(group);
    }

    public StudentGroup getGroup(UUID id){
        return studentGroupRepository.findById(id).orElse(null);
    }

    public List<StudentGroup> getAllGroups(){
        List<StudentGroup> result = new ArrayList<>();
        studentGroupRepository.findAll().iterator().forEachRemaining(result::add);
        return result;
    }

    public StudentGroup assignStudent(UUID groupId, UUID studentId){
        StudentGroup studentGroup = studentGroupRepository.findById(groupId).get();
        Student student = studentRepository.findById(studentId).get();
        studentGroup.getStudents().add(student);
        return studentGroupRepository.save(studentGroup);
    }
}
