package com.example.exam.exam.model.RequestDto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class OptionRequestDto {

    @NotBlank(message = "dwdwed")
    String name;

    @Builder.Default
    Boolean type=false;

}
