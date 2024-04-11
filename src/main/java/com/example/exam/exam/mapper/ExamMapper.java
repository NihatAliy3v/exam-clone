package com.example.exam.exam.mapper;

import com.example.exam.exam.dao.entity.EmployeeDocumentsEntity;
import com.example.exam.exam.dao.entity.ExamEntity;
import com.example.exam.exam.dao.entity.PersonEntity;
import com.example.exam.exam.dao.entity.QuestionEntity;
import com.example.exam.exam.model.RequestDto.ExamRequestDto;
import com.example.exam.exam.model.ResponseDto.ExamResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ExamMapper {

//    @Mapping(target = "questionEntities",expression = "java(mapQuestion(examRequestDto.getQuestionId()))")
    @Mapping(target = "employees",expression = "java(mapEmployee(examRequestDto.getEmployeesId()))")
    @Mapping(target = "personEntities",expression = "java(mapPerson(examRequestDto.getPersonId()))")
    ExamEntity dtoToEntity(ExamRequestDto examRequestDto);
    @Mapping(target = "employeesId",expression = "java(mapEmployees(examEntity.getEmployees()))")
    @Mapping(target = "personId",expression = "java(mapPersons(examEntity.getPersonEntities()))")
    @Mapping(target = "imageDto", source = "imageEntities")
    ExamResponseDto entityToDto(ExamEntity examEntity);

    List<ExamResponseDto> entityToDto(List<ExamEntity> examEntities);

    default List<EmployeeDocumentsEntity> mapEmployee(List<Long> empId) {
        return empId.stream()
                .map(id -> {
                    EmployeeDocumentsEntity academicDegreeEntity = new EmployeeDocumentsEntity();
                    academicDegreeEntity.setEmpId(id);
                    return academicDegreeEntity;
                })
                .collect(Collectors.toList());
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
    default List<Long> mapQuestions(List<QuestionEntity> academicDegreeEntities) {
        return academicDegreeEntities.stream()
                .map(QuestionEntity::getId)
                .collect(Collectors.toList());
    }
    default List<Long> mapEmployees(List<EmployeeDocumentsEntity> academicDegreeEntities) {
        return academicDegreeEntities.stream()
                .map(EmployeeDocumentsEntity::getEmpId)
                .collect(Collectors.toList());
    }

    default List<PersonEntity> mapPerson(List<Long> personId) {
        return personId.stream()
                .map(id -> {
                    PersonEntity academicDegreeEntity = new PersonEntity();
                    academicDegreeEntity.setId(id);
                    return academicDegreeEntity;
                })
                .collect(Collectors.toList());
    }

    default List<Long> mapPersons(List<PersonEntity> personEntities) {
        return personEntities.stream()
                .map(PersonEntity::getId)
                .collect(Collectors.toList());
    }
}
