package com.example.exam.exam.controller;

import com.example.exam.exam.model.RequestDto.QuestionRequestDto;
import com.example.exam.exam.model.ResponseDto.QuestionResponseDto;
import com.example.exam.exam.model.ResponseDto.SimpleMessageDto;
import com.example.exam.exam.service.QuestionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/question")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

        @PostMapping(consumes = "application/json", produces = "application/json")
        public SimpleMessageDto<Long> addQuestion(@Valid @RequestBody QuestionRequestDto questionRequestDto) throws JsonProcessingException {
            return new SimpleMessageDto<>(HttpStatus.CREATED.getReasonPhrase(), HttpStatus.CREATED.value(),questionService.addQuestion(questionRequestDto));
        }

    @GetMapping
    public SimpleMessageDto<List<QuestionResponseDto>> getQuestions() {
        return new SimpleMessageDto<>(HttpStatus.OK.getReasonPhrase(),
                HttpStatus.OK.value(),
                questionService.getQuestions());
    }


    @GetMapping("/{id}")
    public SimpleMessageDto<List<QuestionResponseDto>> getQuestionsBySubjectId(@PathVariable Long id) {
        return new SimpleMessageDto<>(HttpStatus.OK.getReasonPhrase(),
                HttpStatus.OK.value(),
                questionService.getQuestionsBySubjectId(id));
    }

//    @PostMapping("/randomQuestions")
//    public SimpleMessageDto<List<Long>> rastgeleSayilarUret(int altSinir, int ustSinir, int miktar, Long subjectId, QuestionType questionType) {
//        return new SimpleMessageDto<>("Suallar uğurla əlavə edildiç.",
//                HttpStatus.OK.value(),
//                questionService.rastgeleSayilarUret(altSinir, ustSinir, miktar, subjectId, questionType));
//
//    }

}
