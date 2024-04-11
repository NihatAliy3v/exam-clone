package com.example.exam.exam.model.RequestDto;


import jakarta.persistence.Lob;
import lombok.*;
import lombok.experimental.FieldDefaults;



@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ImageRequestDto {

    private String name;

    private String type;

    private String url;

    @Lob
    private byte[] imageData;

    Long examId;

    Long questionId;
}
