package com.example.assignment.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.example.assignment.entity.Status;
import com.example.assignment.entity.assignment.ClassicAssignment;
import com.example.assignment.httpResponse.ClassicAssignmentHttpResponse;
import com.example.assignment.repository.HelpedUserRepository;
import com.example.assignment.requestBody.ClassicAssignmentCreateRequestBody;
import com.example.assignment.requestBody.ClassicAssignmentRequestBody;

@Component
public class ClassicAssignmentMapper {

    @Autowired
    private HelpedUserRepository helpedUserRepository;

    public ClassicAssignment classicAssignmentCreateRequestBodyToClassicAssignment(ClassicAssignmentCreateRequestBody classicAssignmentCreateRequestBody) {
        return new ClassicAssignment(
            classicAssignmentCreateRequestBody.getDescription(),
            false,
            null,
            Status.PENDING,
            null,
            helpedUserRepository.findById(classicAssignmentCreateRequestBody.getIdHelpedUser()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "HelpedUser with given ID not found"))
        );
    }

    public ClassicAssignment classicAssignmentRequestBodyToClassicAssignment(ClassicAssignmentRequestBody classicAssignmentRequestBody) {
        return new ClassicAssignment(
            classicAssignmentRequestBody.getId(),
            classicAssignmentRequestBody.getDescritpion(),
            classicAssignmentRequestBody.isValidate(),
            classicAssignmentRequestBody.getReason(),
            classicAssignmentRequestBody.getStatus(),
            classicAssignmentRequestBody.getOpinion(),
            helpedUserRepository.findById(classicAssignmentRequestBody.getIdHelpedUser()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "HelpedUser with given ID not found"))
        );
    }

    public ClassicAssignmentHttpResponse classicAssignmentToClassicAssignmentHttpResponse(ClassicAssignment classicAssignment) {
        return new ClassicAssignmentHttpResponse(
            classicAssignment.getId(),
            classicAssignment.getDescription(),
            classicAssignment.isValidate(),
            classicAssignment.getReason(),
            classicAssignment.getStatus(),
            classicAssignment.getOpinion(),
            classicAssignment.getHelpedUser().getId()
        );
    }

    public List<ClassicAssignmentHttpResponse> listClassicAssignmentHttpResponse(List<ClassicAssignment> classicAssignments) {
        return classicAssignments.stream().map(classicAssignment -> new ClassicAssignmentHttpResponse(
            classicAssignment.getId(),
            classicAssignment.getDescription(),
            classicAssignment.isValidate(),
            classicAssignment.getReason(),
            classicAssignment.getStatus(),
            classicAssignment.getOpinion(),
            classicAssignment.getHelpedUser().getId()
        )).collect(Collectors.toList());
    }
}