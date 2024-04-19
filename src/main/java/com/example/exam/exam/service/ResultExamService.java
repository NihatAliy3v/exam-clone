package com.example.exam.exam.service;

import com.example.exam.exam.dao.entity.*;
import com.example.exam.exam.dao.entity.enums.EResultType;
import com.example.exam.exam.dao.repository.*;
import com.example.exam.exam.mapper.ExamDescriptionMapper;
import com.example.exam.exam.mapper.ResultExamMapper;
import com.example.exam.exam.model.RequestDto.ResultRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    private final ExamDescriptionRepository examDescriptionRepository;
    private final OptionRepository optionRepository;


    public Map<String, Integer> addResult(ResultRequestDto resultDto) {
        log.info("ActionLog.start result add method");

        ResultExamEntity resultExamEntity=resultExamMapper.dtoToEntity(resultDto);
        Map<SubjectEntity, List<Long>> sortedQuestions = new HashMap<>();

        Map<String, Integer> subjectScores = new HashMap<>();
        int totalScore = 0;


        List<ExamDescriptionEntity> examDescriptionEntities = examDescriptionRepository.findByExamEntityId(resultDto.getExamId());

        for (var examDesc : examDescriptionEntities) {

            List<QuestionEntity> questionEntities = examDesc.getQuestionEntities();
            for (var question : questionEntities) {
                // Sorunun ait olduğu konuyu alın
                SubjectEntity subjectName = question.getSubjectEntity();

                if (sortedQuestions.containsKey(subjectName)) {
                    sortedQuestions.get(subjectName).add(question.getId());
                } else {
                    List<Long> questions = new ArrayList<>();
                    questions.add(question.getId());
                    sortedQuestions.put(subjectName, questions);
                }
            }
        }

        for (Map.Entry<SubjectEntity, List<Long>> entry : sortedQuestions.entrySet()) {
            SubjectEntity subjectName = entry.getKey();
            List<Long> questions = entry.getValue();
            ExamDescriptionEntity examDescriptionEntity = examDescriptionRepository.findBySubjectEntity(subjectName);
            int score = examDescriptionEntity.getQuestionScore();
            int total = 0;
            int trueCount = 0;
            int falseCount = 0;
            for (Long question : questions) {
                List<OptionEntity> correctOptions = optionRepository.findByQuestionEntityIdAndTypeTrue(question);
                for (var option : correctOptions) {
                    for (var optionD : resultDto.getSoptionId()) {
                        if (option.getId().equals(optionD)) {
                            total += score;
                            trueCount++;
                        } else {
                            falseCount++;
                        }
                    }
                }
            }
          SubjectResultEntity subjectResultEntity=new SubjectResultEntity();
            subjectResultEntity.setSubject(entry.getKey());
            subjectResultEntity.setResult(resultExamEntity);
            subjectResultEntity.setScore(total);
            subjectResultEntity.setFalseCount(falseCount);
            subjectResultEntity.setTrueCount(trueCount);

           // resultExamEntity.getSubjectResults().add(subjectResultEntity);

            subjectScores.put(subjectName.getName(), total);
        }

        for (Map.Entry<String, Integer> entry : subjectScores.entrySet()) {
            totalScore += entry.getValue();
            resultDto.setTotalScore(totalScore);
        }
        ExamEntity exam=examRepository.findById(resultDto.getExamId()).get();
        if (totalScore>=exam.getExamScore()){
            resultDto.setEResultType(EResultType.SUCCESS);
        }else {
            resultDto.setEResultType(EResultType.FAILED);
        }
        resultExamRepository.save(resultExamMapper.dtoToEntity(resultDto));
        return subjectScores;
    }

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




