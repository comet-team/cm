package com.comet.service;

import com.comet.adapters.BotAdapter;
import com.comet.model.dto.AddAdminRequest;
import com.comet.model.dto.AddMembersRequest;
import com.comet.model.entity.Student;
import com.comet.model.entity.StudentGroup;
import com.comet.model.entity.SubjectGroup;
import com.comet.repository.StudentGroupRepository;
import com.comet.repository.SubjectGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ChatService {

    @Autowired
    private BotAdapter botAdapter;
    @Autowired
    private StudentGroupRepository studentGroupRepository;
    @Autowired
    private SubjectGroupRepository subjectGroupRepository;

    public void createStudentGroupChat(UUID id) {
        StudentGroup studentGroup = studentGroupRepository.findById(id).orElse(null);
        if (studentGroup == null) {
            return;
        }
        String chatId = studentGroup.getChatId();
        List<String> students = studentGroup.getStudents().stream()
                .map(Student::getTgLink)
                .collect(Collectors.toList());
        botAdapter.addMembers(AddMembersRequest.builder()
                .chatId(chatId)
                .members(students)
                .build());
    }

    public void createSubjectGroupChat(UUID id) {
        SubjectGroup subjectGroup = subjectGroupRepository.findById(id).orElse(null);
        if (subjectGroup == null) {
            return;
        }
        String chatId = subjectGroup.getChatId();
        List<String> students = subjectGroup.getStudents().stream()
                .map(Student::getTgLink)
                .collect(Collectors.toList());
        String teacher = subjectGroup.getTeacher().getTgLink();

        botAdapter.addMembers(AddMembersRequest.builder()
                .chatId(chatId)
                .members(students)
                .build());

        botAdapter.addAdmin(AddAdminRequest.builder()
                .chatId(chatId)
                .adminId(teacher)
                .build());
    }
}
