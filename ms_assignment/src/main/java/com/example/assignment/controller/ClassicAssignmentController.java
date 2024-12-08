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

import com.example.assignment.entity.assignment.ClassicAssignment;
import com.example.assignment.httpResponse.ClassicAssignmentHttpResponse;
import com.example.assignment.mapper.ClassicAssignmentMapper;
import com.example.assignment.requestBody.ClassicAssignmentCreateRequestBody;
import com.example.assignment.service.ClassicAssignmentService;

@RestController
@RequestMapping("/classicassignment")
public class ClassicAssignmentController {

    @Autowired
    private ClassicAssignmentService classicAssignmentService;

    @Autowired
    private ClassicAssignmentMapper classicAssignmentMapper;

    @GetMapping
	public List<ClassicAssignmentHttpResponse> getClassicAssignment() {
		return classicAssignmentMapper.listClassicAssignmentHttpResponse(
            classicAssignmentService.list()
        );
    }

	@PostMapping
	public void createClassicAssignment(@RequestBody ClassicAssignmentCreateRequestBody ClassicAssignmentRequestBody) {

		classicAssignmentService.add(
            classicAssignmentMapper.classicAssignmentCreateRequestBodyToClassicAssignment(ClassicAssignmentRequestBody)
        );
	}

    @GetMapping("/{id}")
    public ClassicAssignmentHttpResponse findClassicAssignment(@PathVariable Long id) {
        return classicAssignmentMapper.classicAssignmentToClassicAssignmentHttpResponse(
            classicAssignmentService.find(id)
        );
    }

    @DeleteMapping("/{id}")
    public void deleteClassicAssignment(@PathVariable Long id) {
        classicAssignmentService.delete(id);
    }

    @PutMapping
    public ClassicAssignment modifyClassicAssignment(@RequestBody ClassicAssignment ClassicAssignment) {
        return classicAssignmentService.modify(ClassicAssignment);
    }

    @PostMapping("/validate/{idAssignment}/{idValidator}")
    public void validateAssignment(@PathVariable Long idAssignment, @PathVariable Long idValidator) {
        classicAssignmentService.validateAssignment(idAssignment, idValidator);
    }

    @PostMapping("unvalidate/{idAssignment}/{idValidator}")
    public void unvalidateAssignment(@PathVariable Long idAssignment, @PathVariable Long idValidator, @RequestBody String reason) {
        classicAssignmentService.unvalidateAssignment(idAssignment, idValidator, reason);
    }

}