package com.example.exam.exam.service;

import com.example.exam.exam.dao.entity.ExamEntity;

import com.example.exam.exam.dao.entity.OptionEntity;
import com.example.exam.exam.dao.entity.QuestionEntity;
import com.example.exam.exam.dao.repository.ExamRepository;
import com.example.exam.exam.dao.repository.LogMessageRepository;
import com.example.exam.exam.dao.repository.OptionRepository;
import com.example.exam.exam.dao.repository.QuestionRepository;
import com.example.exam.exam.mapper.ExamMapper;
import com.example.exam.exam.model.RequestDto.ExamRequestDto;
import com.example.exam.exam.model.ResponseDto.ExamResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ExamService {
    private final ExamRepository examRepository;
    private final QuestionRepository questionRepository;
    private final OptionRepository optionRepository;
    private final ExamMapper examMapper;
    private final LogMessageRepository logMessageRepository;

    public ExamEntity addExam(ExamRequestDto examRequestDto) {
        log.info("ActionLog.start exam add method");

        ExamEntity examEntity = examMapper.dtoToEntity(examRequestDto);


        log.info("ActionLog.end exam add method");
        return examRepository.save(examEntity);

    }

    public ExamEntity getExam(Long id) {
        log.info("ActionLog.start exam get method with id: {}", id);

        ExamEntity examEntity = examRepository.findById(id).get();

        List<QuestionEntity> questions = questionRepository.findAllByExamEntitiesId(examEntity.getId());

        for (QuestionEntity question : questions) {
            // Sorunun seçeneklerini çek
            List<OptionEntity> options = optionRepository.findAllByQuestionEntityId(question.getId());
            question.setOptionEntities(options);
        }

        examEntity.setQuestionEntities(questions);

        log.info("ActionLog.end exam get method with id: {}", id);
        return examEntity;
    }


    public List<ExamResponseDto> getExams() {
        log.info("ActionLog.start exam get method");

        List<ExamEntity> examEntities = examRepository.findAll();

        log.info("ActionLog.end exam get method");
        return examMapper.entityToDto(examEntities);
    }

    public void updateExam(Long id, ExamRequestDto examRequestDto) {
        ExamEntity examEntity = examRepository.findById(id).get();

        BeanUtils.copyProperties(examRequestDto,examEntity,"id");

        examRepository.save(examEntity);

    }
}
