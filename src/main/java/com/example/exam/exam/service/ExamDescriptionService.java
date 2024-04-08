package com.example.exam.exam.service;

import com.example.exam.exam.dao.entity.ExamDescriptionEntity;
import com.example.exam.exam.dao.entity.ExamEntity;
import com.example.exam.exam.dao.entity.OptionEntity;
import com.example.exam.exam.dao.entity.QuestionEntity;
import com.example.exam.exam.dao.repository.*;
import com.example.exam.exam.mapper.ExamDescriptionMapper;
import com.example.exam.exam.mapper.ExamMapper;
import com.example.exam.exam.model.RequestDto.ExamDescriptionRequestDto;
import com.example.exam.exam.model.RequestDto.ExamRequestDto;
import com.example.exam.exam.model.ResponseDto.ExamDescriptionResponseDto;
import com.example.exam.exam.model.ResponseDto.ExamResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ExamDescriptionService {

    private final ExamDescriptionMapper examDescriptionMapper;
    private final ExamDescriptionRepository examDescriptionRepository;
    public void addExamQuestions(ExamDescriptionRequestDto examDescriptionRequestDto) {
        log.info("ActionLog.start exam add method");

        ExamDescriptionEntity examDescriptionEntity = examDescriptionMapper.dtoToEntity(examDescriptionRequestDto);

         examDescriptionRepository.save(examDescriptionEntity);
        log.info("ActionLog.end exam add method");
    }

//    public ExamEntity getExam(Long id) {
//        log.info("ActionLog.start exam get method with id: {}", id);
//
//        ExamEntity examEntity = examRepository.findById(id).get();
//
//        List<QuestionEntity> questions=questionRepository.findAllByExamEntitiesId(examEntity.getId());
//
//        for (QuestionEntity question : questions) {
//            // Sorunun seçeneklerini çek
//            List<OptionEntity> options = optionRepository.findAllByQuestionEntityId(question.getId());
//            question.setOptionEntities(options);
//        }
//
//        examEntity.setQuestionEntities(questions);
//
//        log.info("ActionLog.end exam get method with id: {}", id);
//        return examEntity;
//    }
//
//
//    public List<ExamResponseDto> getExams() {
//        log.info("ActionLog.start exam get method");
//
//        List<ExamEntity> examEntities=examRepository.findAll();
//
//        log.info("ActionLog.end exam get method");
//        return examMapper.entityToDto(examEntities);
//    }

}
