package com.example.exam.exam.model.RequestDto;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class QuestionRequestDto {

    @NotBlank(message = "Sualın adını yazın")
    String name;

    Long subjectId;

    @Size(min = 1, message = "Option alanı boş olamaz")
    List<OptionRequestDto> options;
}
