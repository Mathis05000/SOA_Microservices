package com.example.assignment.httpResponse;

import com.example.assignment.entity.Status;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SpontaneousAssignmentHttpResponse {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("description")
    private String description;
    @JsonProperty("isValidate")
    private boolean isValidate;
    @JsonProperty("reason")
    private String reason;
    @JsonProperty("status")
    private Status status;
    @JsonProperty("opinion")
    private String opinion;
    @JsonProperty("idVolunteer")
    private Long idVolonteer;

    public SpontaneousAssignmentHttpResponse(Long id, String description, boolean isValidate, String reason, Status status, String opinion, Long idVolonteer) {
        this.id = id;
        this.description = description;
        this.isValidate = isValidate;
        this.reason = reason;
        this.status = status;
        this.opinion = opinion;
        this.idVolonteer = idVolonteer;
    }

}
