package com.example.exam.exam.model.ResponseDto;


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

    //Long ruleId;

    List<Long> questionsId;

    Long examId;

    Long subjectId;
}
