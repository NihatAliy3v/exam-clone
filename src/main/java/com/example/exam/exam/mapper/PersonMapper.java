package com.example.exam.exam.mapper;

import com.example.exam.exam.dao.entity.PersonEntity;
import com.example.exam.exam.model.RequestDto.PersonRequestDto;
import com.example.exam.exam.model.ResponseDto.PersonResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonEntity dtoToEntity(PersonRequestDto personRequestDto);

    PersonResponseDto entityToDto(PersonEntity personEntity);

    List<PersonResponseDto> entityToDto(List<PersonEntity> personEntity);

}
