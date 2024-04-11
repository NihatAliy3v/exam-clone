package com.example.exam.exam.mapper;

import com.example.exam.exam.dao.entity.ExamRuleEntity;
import com.example.exam.exam.dao.entity.PersonEntity;
import com.example.exam.exam.model.RequestDto.ExamRuleRequestDto;
import com.example.exam.exam.model.RequestDto.PersonRequestDto;
import com.example.exam.exam.model.ResponseDto.ExamRuleResponseDto;
import com.example.exam.exam.model.ResponseDto.PersonResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RuleMapper {

    ExamRuleEntity dtoToEntity(ExamRuleRequestDto examRuleRequestDto);

    ExamRuleResponseDto entityToDto(ExamRuleEntity examRuleEntity);

    List<ExamRuleResponseDto> entityToDto(List<ExamRuleEntity> examRuleEntities);

}
