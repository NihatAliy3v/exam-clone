package com.example.exam.exam.controller;

import com.example.exam.exam.model.RequestDto.ExamDescriptionRequestDto;
import com.example.exam.exam.model.ResponseDto.ExamDescriptionResponseDto;
import com.example.exam.exam.model.ResponseDto.SimpleMessageDto;
import com.example.exam.exam.service.ExamDescriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/examDescription")
@RequiredArgsConstructor
public class ExamDescriptionController {

    private final ExamDescriptionService examDescriptionService;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public SimpleMessageDto<ExamDescriptionRequestDto> addExamQuestion(@RequestBody ExamDescriptionRequestDto examDescriptionRequestDto) {
        examDescriptionService.addExamQuestions(examDescriptionRequestDto);
        return new SimpleMessageDto<>(HttpStatus.CREATED.getReasonPhrase(),
                HttpStatus.CREATED.value());
    }

//    @GetMapping
//    public SimpleMessageDto<List<ExamResponseDto>> getExams() {
//        return new SimpleMessageDto<>(HttpStatus.OK.getReasonPhrase(),
//                HttpStatus.OK.value(),
//                examService.getExams());
//    }
//
    @GetMapping("/{examId}")
    public SimpleMessageDto<List<ExamDescriptionResponseDto>> getDescription(@PathVariable Long examId) {
        return new SimpleMessageDto<>(HttpStatus.OK.getReasonPhrase(),
                HttpStatus.OK.value(),
                examDescriptionService.getDescription(examId));
    }

    @GetMapping()
    public SimpleMessageDto<List<ExamDescriptionResponseDto>> getDescription() {
        return new SimpleMessageDto<>(HttpStatus.OK.getReasonPhrase(),
                HttpStatus.OK.value(),
                examDescriptionService.getDescription());
    }
}
