package com.example.exam.exam.service;

import com.example.exam.exam.dao.entity.ExamDescriptionEntity;
import com.example.exam.exam.dao.entity.OptionEntity;
import com.example.exam.exam.dao.entity.QuestionEntity;
import com.example.exam.exam.dao.entity.SubjectEntity;
import com.example.exam.exam.dao.repository.OptionRepository;
import com.example.exam.exam.dao.repository.QuestionRepository;
import com.example.exam.exam.mapper.QuestionMapper;
import com.example.exam.exam.mapper.SubjectMapper;
import com.example.exam.exam.model.RequestDto.QuestionRequestDto;
import com.example.exam.exam.model.ResponseDto.QuestionResponseDto;
import com.example.exam.exam.model.ResponseDto.SubjectResponseDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final SubjectMapper subjectMapper;
    private final QuestionMapper questionMapper;
    private final OptionRepository optionRepository;


    public Long addQuestion(QuestionRequestDto questionRequestDto) throws JsonProcessingException {
        log.info("ActionLog.start question add method");

        QuestionEntity questionEntity=questionMapper.dtoToEntity(questionRequestDto);
        questionRepository.save(questionEntity);




            List<OptionEntity> options = questionEntity.getOptionEntities();
            if (options != null) {
                for (OptionEntity option : options) {
                    option.setQuestionEntity(questionEntity);
                    optionRepository.save(option);
                }
            }

return questionEntity.getId();
    }

    public List<QuestionResponseDto> getQuestions() {
        log.info("ActionLog.start question get method");

        List<QuestionEntity> questionEntities = questionRepository.findAll();


            for (QuestionEntity question : questionEntities) {
                List<OptionEntity> options = optionRepository.findByQuestionEntity(question);
                question.setOptionEntities(options);
            }


        log.info("ActionLog.end question get method");
        return questionMapper.entityToDtos(questionEntities);
    }

    public List<QuestionResponseDto> getQuestionsBySubjectId(Long subId) {

        List<QuestionEntity> questionEntities = questionRepository.findAllBySubjectEntityId(subId);
        return questionMapper.entityToDtos(questionEntities);
    }

    public List<QuestionResponseDto> getQuestionsByDesc(Long examDescriptionEntityId) {
        List<QuestionEntity> questionEntities = questionRepository.findAllByExamDescriptionEntitiesId(examDescriptionEntityId);

        // Soruları konularına göre gruplamak için bir Map oluştur
        Map<SubjectEntity, List<QuestionResponseDto>> subjectQuestionMap = new HashMap<>();
        for (QuestionEntity question : questionEntities) {
            SubjectEntity subject = question.getSubjectEntity();
            if (!subjectQuestionMap.containsKey(subject)) {
                subjectQuestionMap.put(subject, new ArrayList<>());
            }
            subjectQuestionMap.get(subject).add(questionMapper.entityToDto(question));
        }

        // SubjectEntity'yi dönüştürmek için gerekirse bir SubjectResponseDto oluştur
        List<QuestionResponseDto> questionResponseDtos = new ArrayList<>();
        for (Map.Entry<SubjectEntity, List<QuestionResponseDto>> entry : subjectQuestionMap.entrySet()) {
            SubjectEntity subject = entry.getKey();
            List<QuestionResponseDto> questionDtosForSubject = entry.getValue();

            // SubjectResponseDto oluştur
            SubjectResponseDto subjectResponseDto = subjectMapper.entityToDto(subject);

            // Her bir soruya ilgili konuyu ekle
            for (QuestionResponseDto questionDto : questionDtosForSubject) {
                questionDto.setSubjectId(subjectResponseDto);
            }

            // Konuya ait soruları listeye ekle
            questionResponseDtos.addAll(questionDtosForSubject);
        }

        return questionResponseDtos;
    }


}

//    public List<Long> rastgeleSayilarUret(int altSinir, int ustSinir, int miktar, Long subjectId, QuestionType questionType) {
//        Random random = new Random();
//
//        if (miktar > (ustSinir - altSinir) + 1 || ustSinir>questionRepository.findAll().size()) {
//            throw new IllegalArgumentException("Miktar, verilen aralığın içinde olmalıdır.");
//        }
//
//        List<Integer> secilenSayilar = new ArrayList<>();
//        List<Long> secilenSuallar = new ArrayList<>();
//        List<QuestionEntity> questionEntities=questionRepository.findAll();
//
//
//
//            while (secilenSayilar.size() < miktar) {
//
//                int rastgeleSayi = random.nextInt((ustSinir - altSinir) + 1) + altSinir;
//                if (!secilenSayilar.contains(rastgeleSayi)) {
//                    secilenSayilar.add(rastgeleSayi);
//                    for (var questionEntity : questionEntities) {
//                        if (questionEntity.getSubjectEntity().getId().equals(subjectId) && questionEntity.getQuestionType()==questionType) {
//                            if (rastgeleSayi == questionEntity.getCount()) {
//                                secilenSuallar.add(questionEntity.getId());
//                            }
//                        }
//                }
//        }}
//
//        return secilenSuallar;
//    }
//
//}
