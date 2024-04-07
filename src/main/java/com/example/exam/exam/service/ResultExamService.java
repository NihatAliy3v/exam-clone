package com.example.exam.exam.service;

import com.example.exam.exam.dao.entity.*;
import com.example.exam.exam.dao.repository.ExamRepository;
import com.example.exam.exam.dao.repository.ResultExamRepository;
import com.example.exam.exam.mapper.ResultExamMapper;
import com.example.exam.exam.model.RequestDto.ResultRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class ResultExamService {
    private final ResultExamRepository resultExamRepository;
    private final ExamRepository examRepository;
    private final ResultExamMapper resultExamMapper;


    public void addResult(ResultRequestDto resultDto) {
        log.info("ActionLog.start result add method");

        resultExamRepository.save(resultExamMapper.dtoToEntity(resultDto));

        log.info("ActionLog.end result add method");
    }


    //    public Map<Long, Map<Long, Map<String, Object>>> getResult(Long id) {
//        log.info("ActionLog.start result get method with id: {}", id);
//
//        Map<Long, Map<Long, Map<String, Object>>> questionOptionInfoMap = new HashMap<>();
//
//        ExamEntity examEntity = examRepository.findById(id).get();
//
//        List<ResultExamEntity> resultSurvey = resultExamRepository.findAllResultByExamEntity(examEntity);
//        for (ResultExamEntity resultSurveys : resultSurvey) {
//            List<OptionEntity> optionEntities = resultSurveys.getOptions();
//
//            // Calculate counts for each option
//            Map<Long, Integer> optionCountMap = new HashMap<>();
//            for (OptionEntity optionEntity : optionEntities) {
//                Long optionId = optionEntity.getId();
//                optionCountMap.put(optionId, optionCountMap.getOrDefault(optionId, 0) + 1);
//            }
//
//            // Populate the result map
//            for (OptionEntity optionEntity : optionEntities) {
//                Long questionId = optionEntity.getQuestionEntity().getId();
//                Long optionId = optionEntity.getId();
//
//                // Get or create the map for the specific question
//                Map<Long, Map<String, Object>> optionInfoMap = questionOptionInfoMap.computeIfAbsent(questionId, k -> new HashMap<>());
//
//                // Increment the count in the inner map
//                Map<String, Object> innerMap = optionInfoMap.getOrDefault(optionId, new HashMap<>());
//                innerMap.put("count", optionCountMap.getOrDefault(optionId, 0));
//                optionInfoMap.put(optionId, innerMap);
//
//                // Calculate the percentage for the current option
//                double optionPercentage = optionCountMap.getOrDefault(optionId, 0) / (double) optionEntities.size() * 100.0;
//
//                // Update the percentage in the inner map
//                innerMap.put("percentage", optionPercentage);
//            }
//        }
//
//        log.info("ActionLog.end result get method with id: {}", id);
//        return questionOptionInfoMap;
//    }
    public Map<String, Double> calculateScoresPerSubject(Long id) {
        Map<String, Double> scoresPerSubject = new HashMap<>();

        ExamEntity userAnswers = examRepository.findById(id).get();
        List<ResultExamEntity> resultExamEntities = resultExamRepository.findAllResultByExamEntity(userAnswers);
        for (ResultExamEntity answer : resultExamEntities) {
            List<OptionEntity> optionEntities = answer.getOptions();
            for (var option : optionEntities) {
                QuestionEntity question = option.getQuestionEntity();
                SubjectEntity subjectEntity = question.getSubjectEntity();
                double score = scoresPerSubject.getOrDefault(subjectEntity.getName(), 0.0);

                if (option.getType()) {
                    score += question.getScore();
                }

                scoresPerSubject.put(subjectEntity.getName(), score);
            }
        }
        return scoresPerSubject;
    }
}




