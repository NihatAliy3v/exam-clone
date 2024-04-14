package com.example.exam.exam.model.RequestDto;

import com.example.exam.exam.dao.entity.enums.ERole;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty("full_name")
    private String fullName;

    private String username;

    private String password;
}