package com.example.exam.exam.model.ResponseDto;

import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ExamRuleResponseDto {

    Long id;

    String name;

    int trueCount;

    int falseCount;
}
