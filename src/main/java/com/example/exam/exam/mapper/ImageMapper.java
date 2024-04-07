package com.example.exam.exam.mapper;


import com.example.exam.exam.dao.entity.Image;
import com.example.exam.exam.model.RequestDto.ImageRequestDto;
import com.example.exam.exam.model.ResponseDto.ImageResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ImageMapper {

    @Mapping(target = "examEntity.id", source = "imageRequestDto.examId")
    Image dtoToEntity(ImageRequestDto imageRequestDto);

    ImageResponseDto entityToDto(Image image);

    List<ImageResponseDto> entityToDto(List<Image> images);


}
