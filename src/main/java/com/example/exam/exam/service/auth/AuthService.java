package com.example.exam.exam.service.auth;

import com.example.exam.exam.dao.entity.AdminEntity;
import com.example.exam.exam.dao.entity.enums.ERole;
import com.example.exam.exam.dao.repository.RoleRepository;
import com.example.exam.exam.dao.repository.UserRepository;
import com.example.exam.exam.model.RequestDto.AuthRequestDto;
import com.example.exam.exam.model.RequestDto.AdminRegisterRequestDto;
import com.example.exam.exam.model.ResponseDto.AuthenticationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.context.SecurityContextHolder;


@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authManager;


    public AuthenticationDto registerAdmin(AdminRegisterRequestDto requestDto) {

        var user = AdminEntity.builder()
                .fullName(requestDto.getFullName())
                .username(requestDto.getUsername())
                .password(passwordEncoder.encode(requestDto.getPassword()))
                .eRole(ERole.ADMIN)
                .build();

        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationDto.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationDto loginAdmin(AuthRequestDto authRequestDto) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequestDto.getUsername(), authRequestDto.getPassword()
                ));

        AdminEntity user = userRepository.findUserByUsername(authRequestDto.getUsername()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);

        return AuthenticationDto.builder().token(jwtToken).build();
    }

    public static AdminEntity getUser() {
        return (AdminEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}