package com.example.assignment.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.example.assignment.entity.Status;
import com.example.assignment.entity.assignment.SpontaneousAssignment;
import com.example.assignment.httpResponse.SpontaneousAssignmentHttpResponse;
import com.example.assignment.repository.VolunteerRepository;
import com.example.assignment.requestBody.SpontaneousAssignmentCreateRequestBody;
import com.example.assignment.requestBody.SpontaneousAssignmentRequestBody;

@Component
public class SpontaneousAssignmentMapper {

    @Autowired
    private VolunteerRepository volunteerRepository;

    public SpontaneousAssignment spontaneousAssignmentCreateRequestBodyToClassicAssignment(SpontaneousAssignmentCreateRequestBody spontaneousAssignmentCreateRequestBody) {
        return new SpontaneousAssignment(
            spontaneousAssignmentCreateRequestBody.getDescription(),
            false,
            null,
            Status.PENDING,
            null,
            volunteerRepository.findById(spontaneousAssignmentCreateRequestBody.getIdVolunteer()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "HelpedUser with given ID not found"))
        );
    }

    public SpontaneousAssignment spontaneousAssignmentRequestBodyToSpontaneousAssignment(SpontaneousAssignmentRequestBody spontaneousAssignmentRequestBody) {
        return new SpontaneousAssignment(
            spontaneousAssignmentRequestBody.getId(),
            spontaneousAssignmentRequestBody.getDescritpion(),
            spontaneousAssignmentRequestBody.isValidate(),
            spontaneousAssignmentRequestBody.getReason(),
            spontaneousAssignmentRequestBody.getStatus(),
            spontaneousAssignmentRequestBody.getOpinion(),
            volunteerRepository.findById(spontaneousAssignmentRequestBody.getIdVolunteer()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "HelpedUser with given ID not found"))
        );
    }

    public SpontaneousAssignmentHttpResponse spontaneousAssignmentToSpontaneousAssignmentHttpResponse(SpontaneousAssignment spontaneousAssignment) {
        return new SpontaneousAssignmentHttpResponse(
            spontaneousAssignment.getId(),
            spontaneousAssignment.getDescription(),
            spontaneousAssignment.isValidate(),
            spontaneousAssignment.getReason(),
            spontaneousAssignment.getStatus(),
            spontaneousAssignment.getOpinion(),
            spontaneousAssignment.getVolunteer().getId()
        );
    }

    public List<SpontaneousAssignmentHttpResponse> listSpontaneousAssignmentHttpResponse(List<SpontaneousAssignment> spontaneousAssignments) {
        return spontaneousAssignments.stream().map(spontaneousAssignment -> new SpontaneousAssignmentHttpResponse(
            spontaneousAssignment.getId(),
            spontaneousAssignment.getDescription(),
            spontaneousAssignment.isValidate(),
            spontaneousAssignment.getReason(),
            spontaneousAssignment.getStatus(),
            spontaneousAssignment.getOpinion(),
            spontaneousAssignment.getVolunteer().getId()
        )).collect(Collectors.toList());
    }
}