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

import com.example.opinion.httpResponse.HelpedUserOpinionHttpResponse;
import com.example.opinion.mapper.HelpedUserOpinionMapper;
import com.example.opinion.service.HelpedUserOpinionService;
import com.example.opinion.requestBody.HelpedUserOpinionRequestBody;

@RestController
@RequestMapping("/helpeduseropinion")
public class HelpedUserOpinionController {

    @Autowired
    private HelpedUserOpinionService helpedUserOpinionService;

    @Autowired
    private HelpedUserOpinionMapper helpedUserOpinionMapper;

    @GetMapping
	public List<HelpedUserOpinionHttpResponse> getHelpedUserOpinion() {
		return helpedUserOpinionMapper.listHelpedUserOpinionHttpResponse(
            helpedUserOpinionService.list()
        );
    }

    @PostMapping
	public void createHelpedUserOpinion(@RequestBody HelpedUserOpinionRequestBody helpedUserOpinionRequestBody) {

		helpedUserOpinionService.add(
            helpedUserOpinionMapper.helpedUserOpinionRequestBodyToHelpedUserOpinion(helpedUserOpinionRequestBody)
        );
	}

    @GetMapping("/{id}")
    public HelpedUserOpinionHttpResponse findHelpedUserOpinion(@PathVariable Long id) {
        return helpedUserOpinionMapper.helpedUserOpinionToHelpedUserOpinionHttpResponse(
            helpedUserOpinionService.find(id)
        );
    }

    @DeleteMapping("/{id}")
    public void deleteHelpedUserOpinion(@PathVariable Long id) {
        helpedUserOpinionService.delete(id);
    }
}