package com.example.exam.exam.auth;

import com.example.exam.exam.model.RequestDto.AdminRegisterRequestDto;
import com.example.exam.exam.model.RequestDto.AuthRequestDto;
import com.example.exam.exam.model.ResponseDto.AuthenticationDto;
import com.example.exam.exam.service.auth.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/admin/register")
    public ResponseEntity<AuthenticationDto> register(@Valid
            @RequestBody AdminRegisterRequestDto requestDto
    ) {
        return ResponseEntity.ok(authService.registerAdmin(requestDto));
    }

    @PostMapping("/admin/login")
    public ResponseEntity<AuthenticationDto> register(
            @RequestBody AuthRequestDto authRequestDto
    ) {
        return ResponseEntity.ok(authService.loginAdmin(authRequestDto));
    }
}