package com.example.exam.exam.service;


import com.example.exam.exam.dao.entity.EmployeeDocumentsEntity;
import com.example.exam.exam.dao.repository.EmployeeDocumentsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeDocumentsService {
    private final EmployeeDocumentsRepository employeeDocumentsRepository;


    public List<EmployeeDocumentsEntity> getEmployees() {
        log.info("ActionLog.start employees get");

        List<EmployeeDocumentsEntity> entity = employeeDocumentsRepository.findAllEmployees();

        log.info("ActionLog.end employee get method");
        return entity;
    }

    public EmployeeDocumentsEntity getEmployee(Long id) {
        log.info("ActionLog.start employee get method with id: {}", id);

        EmployeeDocumentsEntity entity = employeeDocumentsRepository.findEmployeeWithID(id);

        log.info("ActionLog.end employee get method with id: {}", id);
        return entity;
    }
}
