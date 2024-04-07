package com.example.exam.exam.mapper;

import com.example.exam.exam.dao.entity.SubjectEntity;
import com.example.exam.exam.model.RequestDto.SubjectRequestDto;
import com.example.exam.exam.model.ResponseDto.SubjectResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubjectMapper {
    SubjectEntity dtoToEntity(SubjectRequestDto subjectRequestDto);

    SubjectResponseDto entityToDto(SubjectEntity subjectEntity);

    List<SubjectResponseDto> entityToDtos(List<SubjectEntity> subjectEntities);

}
