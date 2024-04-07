    package com.example.exam.exam.model.RequestDto;

    import com.example.exam.exam.dao.entity.enums.QuestionType;
    import jakarta.persistence.EnumType;
    import jakarta.persistence.Enumerated;
    import lombok.*;
    import lombok.experimental.FieldDefaults;

    import java.util.List;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @FieldDefaults(level = AccessLevel.PRIVATE)
    @Builder
    public class QuestionRequestDto {

        String name;

        byte score;


        Long subjectId;

        @Enumerated(EnumType.STRING)
        QuestionType questionType;

        List<OptionRequestDto> options;
    }
