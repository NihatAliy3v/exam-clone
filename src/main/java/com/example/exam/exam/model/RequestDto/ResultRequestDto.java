package com.example.exam.exam.model.RequestDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ResultRequestDto {

    Long id;
    Long examId;
    List<Long> soptionId;
}
