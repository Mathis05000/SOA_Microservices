package com.example.opinion.httpResponse;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VolunteerOpinionHttpResponse {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("opinion")
    private String opinion;
    @JsonProperty("date")
    private LocalDate date;
    @JsonProperty("idVolunteer")
    private Long idVolunteer;
    
    public VolunteerOpinionHttpResponse(Long id, String opinion, LocalDate date, Long idVolunteer) {
        this.id = id;
        this.opinion = opinion;
        this.date = date;
        this.idVolunteer = idVolunteer;
    }
}
