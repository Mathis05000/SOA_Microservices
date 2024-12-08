package com.example.assignment.requestBody;

import com.example.assignment.entity.Status;

public class SpontaneousAssignmentRequestBody {

    private Long id;
    private String descritpion;
    private boolean isValidate;
    private String reason;
    private Status status;
    private String opinion;
    private Long idVolunteer;
    
    public Long getId() {
        return id;
    }
    public boolean isValidate() {
        return isValidate;
    }
    public String getReason() {
        return reason;
    }
    public Status getStatus() {
        return status;
    }
    public String getOpinion() {
        return opinion;
    }
    public Long getIdVolunteer() {
        return idVolunteer;
    }
    public String getDescritpion() {
        return descritpion;
    }

}
