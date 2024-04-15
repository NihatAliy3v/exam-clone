package com.example.exam.exam.controller;

import com.example.exam.exam.model.RequestDto.ExamRuleRequestDto;
import com.example.exam.exam.model.ResponseDto.ExamRuleResponseDto;
import com.example.exam.exam.model.ResponseDto.SimpleMessageDto;
import com.example.exam.exam.service.RuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/rules")
@RequiredArgsConstructor
public class ExamRuleController {

    private final RuleService ruleService;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public SimpleMessageDto<?> addRule(@RequestBody ExamRuleRequestDto ruleRequestDto){
        ruleService.addRule(ruleRequestDto);
        return new SimpleMessageDto<>("Qayda yaradıldı", HttpStatus.CREATED.value());
    }

    @GetMapping
    public SimpleMessageDto<List<ExamRuleResponseDto>> getRules() {
        return new SimpleMessageDto<>(HttpStatus.OK.getReasonPhrase(),
                HttpStatus.OK.value(),
                ruleService.getRules());
    }

//
//    @GetMapping("/{id}")
//    public SimpleMessageDto<Boolean> getOptionsByQuestionId(@PathVariable Long id) {
//        return new SimpleMessageDto<>(HttpStatus.OK.getReasonPhrase(),
//                HttpStatus.OK.value(),
//                optionService.getOptionsByQuestionId(id));
//    }
}
