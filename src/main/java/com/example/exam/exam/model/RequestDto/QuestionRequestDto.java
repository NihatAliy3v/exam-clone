package com.example.exam.exam.model.RequestDto;

import com.example.exam.exam.dao.entity.enums.QuestionType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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


    byte score;


    Long subjectId;

    @Enumerated(EnumType.STRING)
    QuestionType questionType;

    @NotNull(message = "Option alanı boş olamaz")
    List<OptionRequestDto> options;
}
