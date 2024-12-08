package com.example.opinion.httpResponse;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HelpedUserOpinionHttpResponse {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("opinion")
    private String opinion;
    @JsonProperty("date")
    private LocalDate date;
    @JsonProperty("idHelpedUser")
    private Long idHelpedUser;
    
    public HelpedUserOpinionHttpResponse(Long id, String opinion, LocalDate date, Long idHelpedUser) {
        this.id = id;
        this.opinion = opinion;
        this.date = date;
        this.idHelpedUser = idHelpedUser;
    }
}