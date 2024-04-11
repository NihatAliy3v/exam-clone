package com.example.exam.exam.service;

import com.example.exam.exam.dao.entity.ExamRuleEntity;
import com.example.exam.exam.dao.entity.LogEntity;
import com.example.exam.exam.dao.entity.PersonEntity;
import com.example.exam.exam.dao.repository.ExamRuleRepository;
import com.example.exam.exam.dao.repository.LogMessageRepository;
import com.example.exam.exam.dao.repository.PersonRepository;
import com.example.exam.exam.mapper.PersonMapper;
import com.example.exam.exam.mapper.RuleMapper;
import com.example.exam.exam.model.RequestDto.ExamRuleRequestDto;
import com.example.exam.exam.model.RequestDto.PersonRequestDto;
import com.example.exam.exam.model.ResponseDto.ExamRuleResponseDto;
import com.example.exam.exam.model.ResponseDto.PersonResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class RuleService {

    private final ExamRuleRepository examRuleRepository;
    private final RuleMapper ruleMapper;

    public void addRule(ExamRuleRequestDto examRuleRequestDto) {
        log.info("ActionLog.start person add method");

        ExamRuleEntity examRuleEntity = ruleMapper.dtoToEntity(examRuleRequestDto);

        examRuleRepository.save(examRuleEntity);
        log.info("ActionLog.end person add method");
    }

    public List<ExamRuleResponseDto> getRules() {
        log.info("ActionLog.start person get method");

        List<ExamRuleEntity> examRuleEntities = examRuleRepository.findAll();

        log.info("ActionLog.end person get method");
        return ruleMapper.entityToDto(examRuleEntities);
    }
}
