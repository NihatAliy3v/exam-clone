package com.example.exam.exam.model.RequestDto;

import com.example.exam.exam.dao.entity.EmployeeDocumentsEntity;
import com.example.exam.exam.dao.entity.ExamEntity;
import com.example.exam.exam.dao.entity.OptionEntity;
import com.example.exam.exam.dao.entity.PersonEntity;
import com.example.exam.exam.dao.entity.enums.EResultType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ResultRequestDto {

    @Enumerated(EnumType.STRING)
    EResultType eResultType;

    Long examId;

    Long personId;

    int totalScore;

    List<Long> soptionId;
}
