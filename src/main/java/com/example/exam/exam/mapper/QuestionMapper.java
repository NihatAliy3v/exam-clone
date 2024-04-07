package com.example.exam.exam.mapper;

import com.example.exam.exam.dao.entity.QuestionEntity;
import com.example.exam.exam.model.RequestDto.QuestionRequestDto;
import com.example.exam.exam.model.ResponseDto.QuestionResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;




@Mapper(componentModel = "spring")
public interface QuestionMapper {
    @Mapping(target = "subjectEntity.id", source = "subjectId")
    @Mapping(target = "optionEntities",source = "options")
    QuestionEntity dtoToEntity(QuestionRequestDto questionRequestDto);

    @Mapping(target = "subjectId", source = "subjectEntity.id")
    @Mapping(target = "options",source = "optionEntities")
    QuestionResponseDto entityToDto(QuestionEntity questionEntity);

    List<QuestionResponseDto> entityToDtos(List<QuestionEntity> questionEntities);
}

//    @Mapping(target = "questionEntity.id", source = "questionId")
//    OptionEntity dtoToEntity(OptionRequestDto optionRequestDto);
//
//    OptionResponseDto entityToDto(OptionEntity optionEntity);
//
//    List<OptionResponseDto> entityToDto(List<OptionEntity> optionEntities);



//@Mapper(componentModel = "spring")
//public interface QuestionMapper {
//    @Mapping(target = "subjectEntity.id", source = "questionRequestDto.subjectId")
//    QuestionResponseDto entityToDto(QuestionEntity questionEntity);
//    @Mapping(target = "subjectId", source = "subjectEntity.id")
//    QuestionEntity dtoToEntity(QuestionRequestDto questionRequestDto);
//
//    List<QuestionResponseDto> entityToDtos(List<QuestionEntity> questionEntities);

