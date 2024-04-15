package com.example.exam.exam.mapper;


import com.example.exam.exam.dao.entity.Image;
import com.example.exam.exam.dao.entity.QuestionImageEntity;
import com.example.exam.exam.model.RequestDto.ImageRequestDto;
import com.example.exam.exam.model.RequestDto.QuestionImageRequestDto;
import com.example.exam.exam.model.ResponseDto.ImageResponseDto;
import com.example.exam.exam.model.ResponseDto.QuestionImageResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuestionImageMapper {

    @Mapping(target = "questionEntity.id", source = "imageRequestDto.questionId")
    QuestionImageEntity dtoToEntity(QuestionImageRequestDto imageRequestDto);

    QuestionImageResponseDto entityToDto(QuestionImageEntity image);

    List<QuestionImageResponseDto> entityToDto(List<QuestionImageEntity> images);


}
