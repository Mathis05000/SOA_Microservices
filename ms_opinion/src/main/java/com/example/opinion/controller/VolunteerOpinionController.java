package com.example.opinion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.opinion.httpResponse.VolunteerOpinionHttpResponse;
import com.example.opinion.mapper.VolunteerOpinionMapper;
import com.example.opinion.requestBody.VolunteerOpinionRequestBody;
import com.example.opinion.service.VolunteerOpinionService;

@RestController
@RequestMapping("/volunteeropinion")
public class VolunteerOpinionController {

    @Autowired
    private VolunteerOpinionService volunteerOpinionService;

    @Autowired
    private VolunteerOpinionMapper volunteerOpinionMapper;

    @GetMapping
	public List<VolunteerOpinionHttpResponse> getVolunteerOpinion() {
		return volunteerOpinionMapper.listVolunteerOpinionHttpResponse(
            volunteerOpinionService.list()
        );
    }

    @PostMapping
	public void createHelpedUserOpinion(@RequestBody VolunteerOpinionRequestBody volunteerOpinionRequestBody) {

		volunteerOpinionService.add(
            volunteerOpinionMapper.volunteerOpinionRequestBodyToVolunteerOpinion(volunteerOpinionRequestBody)
        );
	}

    @GetMapping("/{id}")
    public VolunteerOpinionHttpResponse findHelpedUserOpinion(@PathVariable Long id) {
        return volunteerOpinionMapper.volunteerOpinionToVolunteerOpinionHttpResponse(
            volunteerOpinionService.find(id)
        );
    }

    @DeleteMapping("/{id}")
    public void deleteVolunteerOpinion(@PathVariable Long id) {
        volunteerOpinionService.delete(id);
    }
}