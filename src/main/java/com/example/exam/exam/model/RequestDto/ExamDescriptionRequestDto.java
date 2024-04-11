package com.example.exam.exam.model.RequestDto;


import com.example.exam.exam.dao.entity.ExamRuleEntity;
import com.example.exam.exam.dao.entity.QuestionEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ExamDescriptionRequestDto {

    int questionScore;

    List<Long> questionsId;

    Long examId;

//    Long ruleId;

    Long subjectId;
}
