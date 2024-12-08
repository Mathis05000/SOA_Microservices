package com.example.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.assignment.entity.assignment.SpontaneousAssignment;
import com.example.assignment.httpResponse.SpontaneousAssignmentHttpResponse;
import com.example.assignment.mapper.SpontaneousAssignmentMapper;
import com.example.assignment.requestBody.SpontaneousAssignmentCreateRequestBody;
import com.example.assignment.requestBody.SpontaneousAssignmentRequestBody;
import com.example.assignment.service.SpontaneousAssignmentService;

@RestController
@RequestMapping("/spontaneousassignment")
public class SpontaneousAssignmentController {

    @Autowired
    private SpontaneousAssignmentService spontaneousAssignmentService;

    @Autowired
    private SpontaneousAssignmentMapper spontaneousAssignmentMapper;

    @GetMapping
	public List<SpontaneousAssignmentHttpResponse> getSpontaneousAssignment() {
		return spontaneousAssignmentMapper.listSpontaneousAssignmentHttpResponse(
            spontaneousAssignmentService.list()
        );
    }

	@PostMapping
	public void createSpontaneousAssignment(@RequestBody SpontaneousAssignmentCreateRequestBody spontaneousAssignmentRequestBody) {
		spontaneousAssignmentService.add(
            spontaneousAssignmentMapper.spontaneousAssignmentCreateRequestBodyToClassicAssignment(spontaneousAssignmentRequestBody)
        );
	}

    @GetMapping("/{id}")
    public SpontaneousAssignmentHttpResponse findSpontaneousAssignment(@PathVariable Long id) {
        return spontaneousAssignmentMapper.spontaneousAssignmentToSpontaneousAssignmentHttpResponse(
            spontaneousAssignmentService.find(id)
        );
    }

    @DeleteMapping("/{id}")
    public void deleteSpontaneousAssignment(@PathVariable Long id) {
        spontaneousAssignmentService.delete(id);
    }

    @PutMapping
    public SpontaneousAssignment modifySpontaneousAssignment(@RequestBody SpontaneousAssignmentRequestBody spontaneousAssignmentRequestBody) {
        return spontaneousAssignmentService.modify(
            spontaneousAssignmentMapper.spontaneousAssignmentRequestBodyToSpontaneousAssignment(spontaneousAssignmentRequestBody));
    }

    @PostMapping("/validate/{idAssignment}/{idValidator}")
    public void validateAssignment(@PathVariable Long idAssignment, @PathVariable Long idValidator) {
        spontaneousAssignmentService.validateAssignment(idAssignment, idValidator);
    }

    @PostMapping("unvalidate/{idAssignment}/{idValidator}")
    public void unvalidateAssignment(@PathVariable Long idAssignment, @PathVariable Long idValidator, @RequestBody String reason) {
        spontaneousAssignmentService.unvalidateAssignment(idAssignment, idValidator, reason);
    }
}
