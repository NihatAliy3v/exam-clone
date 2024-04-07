package com.example.exam.exam.controller;

import com.example.exam.exam.model.RequestDto.ResultRequestDto;
import com.example.exam.exam.model.ResponseDto.SimpleMessageDto;
import com.example.exam.exam.service.QuestionService;
import com.example.exam.exam.service.ResultExamService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/v1/result")
@RequiredArgsConstructor
public class ResultExamController {

    private final ResultExamService resultExamService;


    @PostMapping(consumes = "application/json", produces = "application/json")
    public SimpleMessageDto<ResultRequestDto> addSurvey(@RequestBody ResultRequestDto resultDto) {
        resultExamService.addResult(resultDto);
        return new SimpleMessageDto<>(HttpStatus.CREATED.getReasonPhrase(), HttpStatus.CREATED.value());
    }

    @GetMapping("/{id}")
    public SimpleMessageDto<Map<String, Double>> getResult(@PathVariable Long id) {
        return new SimpleMessageDto<>(HttpStatus.OK.getReasonPhrase(),
                HttpStatus.OK.value(),
                resultExamService.calculateScoresPerSubject(id));
    }
}
