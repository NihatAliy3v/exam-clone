package com.example.exam.exam.controller;


import com.example.exam.exam.dao.entity.EmployeeDocumentsEntity;
import com.example.exam.exam.model.ResponseDto.SimpleMessageDto;
import com.example.exam.exam.service.EmployeeDocumentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/employees")
@RequiredArgsConstructor
public class EmployeeDocumentController {
    private final EmployeeDocumentsService employeeDocumentsService;


    @GetMapping()
    public SimpleMessageDto<List<EmployeeDocumentsEntity>> getEmployees() {

        return new SimpleMessageDto<>(HttpStatus.CREATED.getReasonPhrase(),
                HttpStatus.CREATED.value(),
                employeeDocumentsService.getEmployees());
    }

    @GetMapping("/{id}")
    public SimpleMessageDto<EmployeeDocumentsEntity> getEmployee(@PathVariable Long id) {

        return new SimpleMessageDto<>(HttpStatus.CREATED.getReasonPhrase(),
                HttpStatus.CREATED.value(),
                employeeDocumentsService.getEmployee(id));
    }
}
