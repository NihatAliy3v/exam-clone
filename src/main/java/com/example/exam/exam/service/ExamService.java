package com.example.exam.exam.service;

import com.example.exam.exam.dao.entity.*;

import com.example.exam.exam.dao.entity.enums.ExamPersonType;
import com.example.exam.exam.dao.entity.enums.ExamStatus;
import com.example.exam.exam.dao.repository.*;
import com.example.exam.exam.exception.CustomerException;
import com.example.exam.exam.mapper.ExamMapper;
import com.example.exam.exam.model.RequestDto.ExamRequestDto;
import com.example.exam.exam.model.ResponseDto.ExamResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ExamService {
    private final ExamRepository examRepository;
    private final QuestionRepository questionRepository;
    private final PersonRepository personRepository;
    private final EmployeeDocumentsRepository employeeDocumentsRepository;
    private final OptionRepository optionRepository;
    private final ExamMapper examMapper;
    private final LogMessageRepository logMessageRepository;

    public ExamEntity addExam(ExamRequestDto examRequestDto) {
        log.info("ActionLog.start exam add method");

        if (!examRepository.findAll().isEmpty()) {
            List<ExamEntity> subjectEntities = examRepository.findAll();

            for (var subject : subjectEntities) {
                if (examRequestDto.getName().equals(subject.getName())) {
                    throw new CustomerException("İmtahan mövcuddur");
                }
            }
        }

        LocalDate bugun = LocalDate.now();

        Date examStartTime = examRequestDto.getStartTime();

        String type = String.valueOf(examRequestDto.getExamTimeType());

        ExamStatus examStatus;
        if (type.equals("MUDDETSIZ") || examStartTime.equals(bugun)) {
            examStatus = ExamStatus.ACTIVE;
        } else {
            examStatus = ExamStatus.PENDING;
        }

        examRequestDto.setExamStatus(examStatus);

        ExamEntity examEntity = examMapper.dtoToEntity(examRequestDto);

        log.info("ActionLog.end exam add method");
        return examRepository.save(examEntity);
    }

    public ExamResponseDto getExam(Long id) {
        log.info("ActionLog.start exam get method with id: {}" , id);

        ExamEntity examEntity=examRepository.findById(id).get();


        log.info("ActionLog.end exam get method with id: {}" , id);
        return examMapper.entityToDto(examEntity);
    }


    public List<ExamResponseDto> getExams() {
        log.info("ActionLog.start exam get method");

        List<ExamEntity> examEntities = examRepository.findAll();

        log.info("ActionLog.end exam get method");
        return examMapper.entityToDto(examEntities);
    }

    public void updateExam(Long id, ExamRequestDto examRequestDto) {
        ExamEntity examEntity = examRepository.findById(id).get();

        BeanUtils.copyProperties(examRequestDto, examEntity, "id");
        if (!examRequestDto.getPersonId().isEmpty()) {
            List<PersonEntity> persons = examRequestDto.getPersonId().stream()
                    .map(personId -> personRepository.findById(personId).orElse(null))
                    .collect(Collectors.toList());
            examEntity.setPersonEntities(persons);
        } else if (!examRequestDto.getEmployeesId().isEmpty()) {
            List<EmployeeDocumentsEntity> employees = examRequestDto.getEmployeesId().stream()
                    .map(empId -> employeeDocumentsRepository.findById(empId).orElse(null))
                    .collect(Collectors.toList());
            examEntity.setEmployees(employees);
        }
        examRepository.save(examEntity);

    }

    public List<ExamResponseDto> getExamByPersonId(Long id){

        List<ExamEntity> examEntities = examRepository.findByPersonsId(id);

        return examMapper.entityToDto(examEntities);
    }

    public List<ExamResponseDto> getExamByEmpId(Long id){

        List<ExamEntity> examEntities = examRepository.findByEmployeesId(id);

        return examMapper.entityToDto(examEntities);
    }
}
