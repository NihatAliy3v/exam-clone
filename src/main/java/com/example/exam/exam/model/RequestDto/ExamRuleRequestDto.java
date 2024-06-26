package com.example.exam.exam.model.RequestDto;

import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ExamRuleRequestDto {

    String name;

    int trueCount;

    int falseCount;
}
