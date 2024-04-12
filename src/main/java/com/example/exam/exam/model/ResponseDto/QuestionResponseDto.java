package com.example.exam.exam.model.ResponseDto;

import com.example.exam.exam.dao.entity.SubjectEntity;
import com.example.exam.exam.model.RequestDto.OptionRequestDto;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class QuestionResponseDto {

    Long id;

    String name;

    SubjectResponseDto subjectId;

    ImageResponseDto imageDto;

    List<OptionResponseDto> options;


}
