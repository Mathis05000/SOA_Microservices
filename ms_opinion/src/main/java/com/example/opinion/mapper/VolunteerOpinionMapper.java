package com.example.opinion.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.example.opinion.entity.HelpedUserOpinion;
import com.example.opinion.entity.VolunteerOpinion;
import com.example.opinion.httpResponse.HelpedUserOpinionHttpResponse;
import com.example.opinion.httpResponse.VolunteerOpinionHttpResponse;
import com.example.opinion.repository.user.VolunteerRepository;
import com.example.opinion.requestBody.VolunteerOpinionRequestBody;

@Component
public class VolunteerOpinionMapper {

    @Autowired
    private VolunteerRepository volunteerRepository;

    public VolunteerOpinion volunteerOpinionRequestBodyToVolunteerOpinion(VolunteerOpinionRequestBody volunteerOpinionRequestBody) {
        return new VolunteerOpinion(
            volunteerOpinionRequestBody.getOpinion(),
            volunteerRepository.findById(volunteerOpinionRequestBody.getIdVolunteer()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Volunteer with given ID not found"))
        );
    }

    public VolunteerOpinionHttpResponse volunteerOpinionToVolunteerOpinionHttpResponse(VolunteerOpinion volunteerOpinion) {
        return new VolunteerOpinionHttpResponse(
            volunteerOpinion.getId(),
            volunteerOpinion.getOpinion(),
            volunteerOpinion.getDate(),
            volunteerOpinion.getVolunteer().getId()
        );
    }

    public List<VolunteerOpinionHttpResponse> listVolunteerOpinionHttpResponse(List<VolunteerOpinion> volunteerOpinions) {
        return volunteerOpinions.stream().map(volunteerOpinion -> new VolunteerOpinionHttpResponse(
            volunteerOpinion.getId(),
            volunteerOpinion.getOpinion(),
            volunteerOpinion.getDate(),
            volunteerOpinion.getVolunteer().getId()
        )).collect(Collectors.toList());
    }
}