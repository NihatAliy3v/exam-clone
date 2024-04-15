package com.example.exam.exam.mapper;

import com.example.exam.exam.dao.entity.OptionEntity;
import com.example.exam.exam.dao.entity.ResultExamEntity;
import com.example.exam.exam.model.RequestDto.ResultRequestDto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ResultExamMapper {

    @Mapping(target = "examEntity.id", source = "examId")
//    @Mapping(target = "employee.empId", source = "employeeId")
    @Mapping(target = "person.id", source = "personId")
    @Mapping(target = "options", expression = "java(mapOptions(resultDto.getSoptionId()))")
    ResultExamEntity dtoToEntity(ResultRequestDto resultDto);

    List<ResultRequestDto> entityToDtos(List<ResultExamEntity> resultSurveyEntities);

    @Mapping(target = "soptionId", expression = "java(mapOptionIds(resultSurveyEntity.getOptions()))")
    ResultRequestDto entityToDto(ResultExamEntity resultSurveyEntity);

    default List<OptionEntity> mapOptions(List<Long> optionIds) {
        return optionIds.stream()
                .map(id -> {
                    OptionEntity optionEntity = new OptionEntity();
                    optionEntity.setId(id);
                    return optionEntity;
                })
                .collect(Collectors.toList());
    }

//    default List<SurveyEntity> mapSurveys(List<Long> surveyId) {
//        return surveyId.stream()
//                .map(id -> {
//                    SurveyEntity optionEntity = new SurveyEntity();
//                    optionEntity.setId(id);
//                    return optionEntity;
//                })
//                .collect(Collectors.toList());
//    }
//
//    default List<EmployeeDocumentsEntity> mapEmployees(List<Long> employeeIds) {
//        return employeeIds.stream()
//                .map(id -> {
//                    EmployeeDocumentsEntity employeeDocumentsEntity = new EmployeeDocumentsEntity();
//                    employeeDocumentsEntity.setEmpId(id);
//                    return employeeDocumentsEntity;
//                })
//                .collect(Collectors.toList());
//    }

    default List<Long> mapOptionIds(List<OptionEntity> options) {
        return options.stream()
                .map(OptionEntity::getId)
                .collect(Collectors.toList());
    }


//    default List<Long> mapEmployeeIds(List<EmployeeDocumentsEntity> employees) {
//        return employees.stream()
//                .map(EmployeeDocumentsEntity::getEmpId)
//                .collect(Collectors.toList());
//    }
}