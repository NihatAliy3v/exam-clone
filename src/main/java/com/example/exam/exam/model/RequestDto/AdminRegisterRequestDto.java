package com.example.exam.exam.model.RequestDto;

import com.example.exam.exam.dao.entity.enums.ERole;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminRegisterRequestDto {

    @NotBlank(message = "Ad və Soyad daxil edin")
    @JsonProperty("full_name")
    private String fullName;

    @NotBlank(message = "İstifadəçi adı daxil edin")
    private String username;

    @NotBlank(message = "Şifrə daxil edin")
    private String password;
}