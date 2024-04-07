package com.example.exam.exam.mapper;

import com.example.exam.exam.dao.entity.OptionEntity;
import com.example.exam.exam.model.RequestDto.OptionRequestDto;
import com.example.exam.exam.model.ResponseDto.OptionResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OptionMapper {
    @Mapping(target = "questionEntity",ignore = true )
    OptionEntity dtoToEntity(OptionRequestDto optionRequestDto);

    OptionResponseDto entityToDto(OptionEntity optionEntity);

    List<OptionResponseDto> entityToDto(List<OptionEntity> optionEntities);

}
