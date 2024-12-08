package com.example.opinion.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.example.opinion.entity.HelpedUserOpinion;
import com.example.opinion.httpResponse.HelpedUserOpinionHttpResponse;
import com.example.opinion.repository.user.HelpedUserRepository;
import com.example.opinion.requestBody.HelpedUserOpinionRequestBody;

@Component
public class HelpedUserOpinionMapper {

    @Autowired
    private HelpedUserRepository helpedUserRepository;

    public HelpedUserOpinion helpedUserOpinionRequestBodyToHelpedUserOpinion(HelpedUserOpinionRequestBody helpedUserOpinionRequestBody) {
        return new HelpedUserOpinion(
            helpedUserOpinionRequestBody.getOpinion(),
            helpedUserRepository.findById(helpedUserOpinionRequestBody.getIdHelpedUser()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "HelpedUser with given ID not found"))
        );
    }

    public HelpedUserOpinionHttpResponse helpedUserOpinionToHelpedUserOpinionHttpResponse(HelpedUserOpinion helpedUserOpinion) {
        return new HelpedUserOpinionHttpResponse(
            helpedUserOpinion.getId(),
            helpedUserOpinion.getOpinion(),
            helpedUserOpinion.getDate(),
            helpedUserOpinion.getHelpedUser().getId()
        );
    }

    public List<HelpedUserOpinionHttpResponse> listHelpedUserOpinionHttpResponse(List<HelpedUserOpinion> helpedUserOpinions) {
        return helpedUserOpinions.stream().map(helpedUserOpinion -> new HelpedUserOpinionHttpResponse(
            helpedUserOpinion.getId(),
            helpedUserOpinion.getOpinion(),
            helpedUserOpinion.getDate(),
            helpedUserOpinion.getHelpedUser().getId()
        )).collect(Collectors.toList());
    }
}