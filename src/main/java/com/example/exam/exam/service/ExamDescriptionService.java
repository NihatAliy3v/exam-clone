package com.example.exam.exam.service;

import com.example.exam.exam.dao.entity.ExamDescriptionEntity;
import com.example.exam.exam.dao.entity.ExamEntity;
import com.example.exam.exam.dao.entity.OptionEntity;
import com.example.exam.exam.dao.entity.QuestionEntity;
import com.example.exam.exam.dao.repository.*;
import com.example.exam.exam.mapper.ExamDescriptionMapper;
import com.example.exam.exam.mapper.ExamMapper;
import com.example.exam.exam.mapper.QuestionMapper;
import com.example.exam.exam.model.RequestDto.ExamDescriptionRequestDto;
import com.example.exam.exam.model.RequestDto.ExamRequestDto;
import com.example.exam.exam.model.ResponseDto.ExamDescriptionResponseDto;
import com.example.exam.exam.model.ResponseDto.ExamResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ExamDescriptionService {

    private final ExamDescriptionMapper examDescriptionMapper;
    private final QuestionMapper questionMapper ;
    private final ExamDescriptionRepository examDescriptionRepository;
    private final QuestionRepository questionRepository;
    private final OptionRepository optionRepository;
    public void addExamQuestions(ExamDescriptionRequestDto examDescriptionRequestDto) {
        log.info("ActionLog.start exam add method");

        ExamDescriptionEntity examDescriptionEntity = examDescriptionMapper.dtoToEntity(examDescriptionRequestDto);

         examDescriptionRepository.save(examDescriptionEntity);
        log.info("ActionLog.end exam add method");
    }

    public List<ExamDescriptionResponseDto> getDescription(Long examId) {
        List<ExamDescriptionEntity> examDescriptionEntities = examDescriptionRepository.findByExamEntityId(examId);
        List<ExamDescriptionResponseDto> examDescriptionResponseDtos = new ArrayList<>();

        for (var desc : examDescriptionEntities) {
            List<QuestionEntity> questionEntities = questionRepository.findAllByExamDescriptionEntities(desc);

            for (var question : questionEntities) {
                List<OptionEntity> optionEntities = optionRepository.findAllByQuestionEntityId(question.getId());
                System.out.println(optionEntities);
                question.setOptionEntities(optionEntities);
            }

            desc.setQuestionEntities(questionEntities);
            examDescriptionResponseDtos.add(examDescriptionMapper.entityToDto(desc));
        }

        return examDescriptionResponseDtos;
    }

    public List<ExamDescriptionResponseDto> getDescription(){
        List<ExamDescriptionEntity> examDescriptionEntities=examDescriptionRepository.findAll();

        return examDescriptionMapper.entityToDto(examDescriptionEntities);
    }
}
