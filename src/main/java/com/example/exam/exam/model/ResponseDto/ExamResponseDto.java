package com.example.exam.exam.model.ResponseDto;


import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.*;
import lombok.experimental.FieldDefaults;


import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ExamResponseDto {

    Long id;

    String name;

    @Builder.Default
    Boolean activeStatus=false;

    @Temporal(TemporalType.DATE)
    Date startTime;

    @Temporal(TemporalType.DATE)
    Date endTime;

    int expirationTime;

    @Builder.Default
    Boolean answerStatus=false;

    List<ImageResponseDto> imageDto;

    List<Long> employeesId;

    List<Long> personId;


}
