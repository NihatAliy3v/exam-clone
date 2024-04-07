package com.example.exam.exam.model.RequestDto;

import lombok.*;
import lombok.experimental.FieldDefaults;



@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class PersonRequestDto {
    String name;

    String surname;

    String fatherName;

    String fin;

    String cardNo;

    String phone;

    String mail;

}
