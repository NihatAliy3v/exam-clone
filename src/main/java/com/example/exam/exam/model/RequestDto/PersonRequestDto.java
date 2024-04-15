package com.example.exam.exam.model.RequestDto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class PersonRequestDto {

    @NotBlank(message = "Ad daxil edin")
    String name;

    @NotBlank(message = "Soyad daxil edin")
    String surname;

    @NotBlank(message = "Ata adı daxil edin")
    String fatherName;

    @Size(min = 7, max = 7, message = "FIN 7 simvol olmalıdır")
    String fin;

    @Size(min = 9, max = 9, message = "Seriya nömrəsi 7 simvol olmalıdır")
    String cardNo;

    @Pattern(regexp = "^(\\+994|0)[0-9]{9}$", message = "Telefon nömrəsini düzgün daxil edin")
    String phone;

    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Mail-i düzgün daxil edin")
    String mail;

}
