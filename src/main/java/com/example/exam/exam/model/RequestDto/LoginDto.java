package com.example.exam.exam.model.RequestDto;


import jakarta.persistence.Lob;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class LoginDto {

    private String fin;
}
