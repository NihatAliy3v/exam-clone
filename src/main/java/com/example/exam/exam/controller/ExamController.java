package com.example.exam.exam.controller;

import com.example.exam.exam.dao.entity.ExamEntity;
import com.example.exam.exam.model.RequestDto.ExamRequestDto;
import com.example.exam.exam.model.ResponseDto.ExamResponseDto;
import com.example.exam.exam.model.ResponseDto.SimpleMessageDto;
import com.example.exam.exam.service.ExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/exam")
@RequiredArgsConstructor
public class ExamController {

    private final ExamService examService;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public SimpleMessageDto<ExamEntity> addExam(@RequestBody ExamRequestDto examRequestDto) {
        return new SimpleMessageDto<>(HttpStatus.CREATED.getReasonPhrase(),
                HttpStatus.CREATED.value(),
                examService.addExam(examRequestDto));
    }

    @GetMapping
    public SimpleMessageDto<List<ExamResponseDto>> getExams() {
        return new SimpleMessageDto<>(HttpStatus.OK.getReasonPhrase(),
                HttpStatus.OK.value(),
                examService.getExams());
    }

    @GetMapping("/{id}")
    public SimpleMessageDto<ExamResponseDto> getExam(@PathVariable Long id) {
        return new SimpleMessageDto<>(HttpStatus.OK.getReasonPhrase(),
                HttpStatus.OK.value(),
                examService.getExam(id));
    }
}
