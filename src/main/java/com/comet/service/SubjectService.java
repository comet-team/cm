package com.comet.service;

import com.comet.model.dto.ExternalStudent;
import com.comet.model.dto.ExternalSubject;
import com.comet.model.entity.Student;
import com.comet.model.entity.Subject;
import com.comet.repository.StudentRepository;
import com.comet.repository.SubjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class SubjectService extends ModelMapper {

    @Autowired
    private SubjectRepository subjectRepository;

    public Subject createSubject(ExternalSubject externalSubject) {
        Subject subject = this.map(externalSubject, Subject.class);
        return subjectRepository.save(subject);
    }

    public Subject getSubject(UUID id) {
        return subjectRepository.findById(id).orElse(null);
    }

    public List<Subject> getAllSubjects() {
        List<Subject> result = new ArrayList<>();
        subjectRepository.findAll().iterator().forEachRemaining(result::add);
        return result;
    }

}
