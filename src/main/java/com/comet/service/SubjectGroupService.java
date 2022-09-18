package com.comet.service;

import com.comet.model.dto.ExternalStudentGroup;
import com.comet.model.dto.ExternalSubjectGroup;
import com.comet.model.entity.Student;
import com.comet.model.entity.StudentGroup;
import com.comet.model.entity.SubjectGroup;
import com.comet.repository.StudentGroupRepository;
import com.comet.repository.StudentRepository;
import com.comet.repository.SubjectGroupRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class SubjectGroupService extends ModelMapper {

    @Autowired
    private SubjectGroupRepository subjectGroupRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentGroupRepository studentGroupRepository;

    public SubjectGroup createSubjectGroup(ExternalSubjectGroup externalStudentGroup) {
        SubjectGroup group = this.map(externalStudentGroup, SubjectGroup.class);
        return subjectGroupRepository.save(group);
    }

    public SubjectGroup getGroup(UUID id){
        return subjectGroupRepository.findById(id).orElse(null);
    }

    public List<SubjectGroup> getAllGroups(){
        List<SubjectGroup> result = new ArrayList<>();
        subjectGroupRepository.findAll().iterator().forEachRemaining(result::add);
        return result;
    }

    public SubjectGroup assignStudent(UUID groupId, UUID studentId){
        SubjectGroup group = subjectGroupRepository.findById(groupId).get();
        Student student = studentRepository.findById(studentId).get();
        student.setSubjectGroup(group);
        studentRepository.save(student);
        return subjectGroupRepository.findById(groupId).get();
    }

    public SubjectGroup assignStudentGroup(UUID subjectGroupId, UUID studentGroupId) {
        SubjectGroup subjectGroup = subjectGroupRepository.findById(subjectGroupId).get();
        StudentGroup studentGroup = studentGroupRepository.findById(studentGroupId).get();
        studentGroup.getStudents().forEach(student -> {student.setSubjectGroup(subjectGroup);
        studentRepository.save(student);});
        return subjectGroupRepository.findById(studentGroupId).get();
    }
}
