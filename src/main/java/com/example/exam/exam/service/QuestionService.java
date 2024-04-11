package com.example.exam.exam.service;

import com.example.exam.exam.dao.entity.ExamDescriptionEntity;
import com.example.exam.exam.dao.entity.OptionEntity;
import com.example.exam.exam.dao.entity.QuestionEntity;
import com.example.exam.exam.dao.repository.OptionRepository;
import com.example.exam.exam.dao.repository.QuestionRepository;
import com.example.exam.exam.mapper.QuestionMapper;
import com.example.exam.exam.model.RequestDto.QuestionRequestDto;
import com.example.exam.exam.model.ResponseDto.QuestionResponseDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;
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

    public List<QuestionResponseDto> getQuestionsByDesc(Long examDescriptionEntity) {

        List<QuestionEntity> questionEntities = questionRepository.findAllByExamDescriptionEntitiesId(examDescriptionEntity);
        return questionMapper.entityToDtos(questionEntities);
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
