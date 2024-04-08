package com.example.exam.exam.controller;

import com.example.exam.exam.model.RequestDto.SubjectRequestDto;
import com.example.exam.exam.model.ResponseDto.SimpleMessageDto;
import com.example.exam.exam.model.ResponseDto.SubjectResponseDto;
import com.example.exam.exam.service.SubjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/subject")
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectService subjectService;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public SimpleMessageDto<SubjectRequestDto> addSubject(@Valid  @RequestBody SubjectRequestDto subjectRequestDto) {
        subjectService.addSubject(subjectRequestDto);
        return new SimpleMessageDto<>("Fənn əlavə edildi", HttpStatus.CREATED.value());
    }

    @GetMapping
    public SimpleMessageDto<List<SubjectResponseDto>> getSubjects() {
        return new SimpleMessageDto<>(HttpStatus.OK.getReasonPhrase(),
                HttpStatus.OK.value(),
                subjectService.getSubjects());
    }

    @GetMapping("/{id}")
    public SimpleMessageDto<SubjectResponseDto> getSubject(@PathVariable Long id) {
        return new SimpleMessageDto<>(HttpStatus.OK.getReasonPhrase(),
                HttpStatus.OK.value(),
                subjectService.getSubject(id));
    }

}
