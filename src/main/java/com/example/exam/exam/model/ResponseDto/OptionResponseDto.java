package com.example.exam.exam.model.ResponseDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class OptionResponseDto {

    Long id;

    String name;

    Boolean type;
}
