package com.comet.test;

import com.comet.BaseTest;
import com.comet.adapters.BotAdapter;
import com.comet.model.dto.AddMembersRequest;
import com.comet.model.entity.*;
import com.comet.repository.*;
import com.comet.service.GroupService;
import com.comet.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.cassandra.DataCassandraTest;

import java.util.List;
import java.util.Set;

public class FirstTest extends BaseTest {

    @Autowired
    private StudentService studentService;
    @Autowired
    private GroupService groupService;

    @Autowired
    private StudentGroupRepository studentGroupRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private SubjectGroupRepository subjectGroupRepository;

    @Test
    void someTest(){
        Student student = new Student("A", "B", "C");
        StudentGroup studentGroup = new StudentGroup("title");
        StudentGroup savedGroup = studentGroupRepository.save(studentGroup);
        Student studentSaved = studentRepository.save(student);
        savedGroup.getStudents().add(studentSaved);
        studentGroupRepository.save(savedGroup);
        System.out.println();
        Teacher teacher = new Teacher("D", "E", "F");
        Subject subject = new Subject("КПО");
        Teacher teacherSaved = teacherRepository.save(teacher);
        Subject subjectSaved = subjectRepository.save(subject);
        SubjectGroup subjectGroup = new SubjectGroup("БПИ197_КПО");
        SubjectGroup savedSubjectGroup = subjectGroupRepository.save(subjectGroup);
        savedSubjectGroup.setSubject(subjectSaved);
        savedSubjectGroup.setTeacher(teacherSaved);
        savedSubjectGroup.setStudents(Set.of(studentSaved));
        subjectGroupRepository.save(savedSubjectGroup);
    }
}
