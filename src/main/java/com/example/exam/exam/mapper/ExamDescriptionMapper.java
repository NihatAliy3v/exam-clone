package com.example.exam.exam.mapper;

import com.example.exam.exam.dao.entity.*;
import com.example.exam.exam.model.RequestDto.ExamDescriptionRequestDto;
import com.example.exam.exam.model.ResponseDto.ExamDescriptionResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ExamDescriptionMapper {
    //@Mapping(target = "personEntities",expression = "java(mapPerson(examRequestDto.getPersonId()))")

    @Mapping(target = "questionEntities", expression = "java(mapQuestion(examDescriptionRequestDto.getQuestionsId()))")
    @Mapping(target = "examEntity", expression = "java(mapExam(examDescriptionRequestDto.getExamId()))")
    //  @Mapping(target = "examRuleEntity", expression = "java(mapRule(examDescriptionRequestDto.getRuleId()))")
    @Mapping(target = "subjectEntity", expression = "java(mapSubject(examDescriptionRequestDto.getSubjectId()))")
    ExamDescriptionEntity dtoToEntity(ExamDescriptionRequestDto examDescriptionRequestDto);


    @Mapping(target = "examId", source = "examEntity.id")
    //@Mapping(target = "ruleId", expression = "java(mapRule(examDescriptionRequestDto.getRuleId()))")
    @Mapping(target = "subjectId", source = "subjectEntity.id")
    @Mapping(target = "questionsId",source = "questionEntities")
    ExamDescriptionResponseDto entityToDto(ExamDescriptionEntity examDescriptionEntity);

    List<ExamDescriptionResponseDto> entityToDto(List<ExamDescriptionEntity> examDescriptionEntities);


    default ExamEntity mapExam(Long exId) {
        ExamEntity academicDegreeEntity = new ExamEntity();
        academicDegreeEntity.setId(exId);
        return academicDegreeEntity;
    }

    default ExamRuleEntity mapRule(Long ruleId) {
        ExamRuleEntity academicDegreeEntity = new ExamRuleEntity();
        academicDegreeEntity.setId(ruleId);
        return academicDegreeEntity;
    }

    default SubjectEntity mapSubject(Long subId) {
        SubjectEntity academicDegreeEntity = new SubjectEntity();
        academicDegreeEntity.setId(subId);
        return academicDegreeEntity;
    }

    default List<QuestionEntity> mapQuestion(List<Long> questionId) {
        return questionId.stream()
                .map(id -> {
                    QuestionEntity academicDegreeEntity = new QuestionEntity();
                    academicDegreeEntity.setId(id);
                    return academicDegreeEntity;
                })
                .collect(Collectors.toList());
    }


    default List<Long> mapQuestions(List<QuestionEntity> questionEntities) {
        return questionEntities.stream()
                .map(QuestionEntity::getId)
                .collect(Collectors.toList());
    }
}
