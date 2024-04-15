package com.example.exam.exam.model.RequestDto;


import com.example.exam.exam.dao.entity.enums.ExamPersonType;
import com.example.exam.exam.dao.entity.enums.ExamStatus;
import com.example.exam.exam.dao.entity.enums.ExamTimeType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class    ExamRequestDto {

    @NotBlank(message = "İmtahanın ")
    String name;

    @Temporal(TemporalType.DATE)
    Date startTime;

    @Temporal(TemporalType.DATE)
    Date endTime;

    @Min(value = 1,message = "İmtahan müddətini yazın")
    int expirationTime;

    @Builder.Default
    Boolean calculator=false;

    @Min(value = 1,message = "İmtahan keçid balını yazın")
    int examScore;

    @Enumerated(EnumType.STRING)
    ExamStatus examStatus;

    @Enumerated(EnumType.STRING)
    ExamPersonType examPersonType;

    @Enumerated(EnumType.STRING)
    ExamTimeType examTimeType;

    List<Long> employeesId;

    List<Long> personId;


}
