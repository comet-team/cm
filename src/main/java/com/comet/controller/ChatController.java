package com.comet.controller;

import com.comet.model.dto.ExternalStudentGroup;
import com.comet.model.entity.StudentGroup;
import com.comet.service.ChatService;
import com.comet.service.GroupService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @ApiOperation("Create chat for student group")
    @PostMapping("/student_group_chat")
    public void createStudentGroupChat(@PathVariable(value = "studentGroupId") UUID studentGroupId) {
        chatService.createStudentGroupChat(studentGroupId);
    }

    @ApiOperation("Create chat for subject group")
    @PostMapping("/subject_group_chat")
    public void createSubjectGroupChat(@PathVariable(value = "subjectGroupId") UUID subjectGroupId) {
        chatService.createSubjectGroupChat(subjectGroupId);
    }
}
