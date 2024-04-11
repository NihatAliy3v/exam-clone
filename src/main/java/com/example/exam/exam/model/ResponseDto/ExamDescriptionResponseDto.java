package com.example.exam.exam.model.ResponseDto;


import com.example.exam.exam.model.RequestDto.QuestionRequestDto;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ExamDescriptionResponseDto {

    Long id;

    int questionScore;

    List<QuestionResponseDto> questionsId;

    Long examId;

//    Long ruleId;

    Long subjectId;
}
