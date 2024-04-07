package com.example.exam.exam.controller;

import com.example.exam.exam.model.RequestDto.LoginDto;
import com.example.exam.exam.model.RequestDto.OptionRequestDto;
import com.example.exam.exam.model.ResponseDto.OptionResponseDto;
import com.example.exam.exam.model.ResponseDto.QuestionResponseDto;
import com.example.exam.exam.model.ResponseDto.SimpleMessageDto;
import com.example.exam.exam.service.LoginService;
import com.example.exam.exam.service.OptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/option")
@RequiredArgsConstructor
public class OptionController {

    private final OptionService optionService;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public SimpleMessageDto<OptionRequestDto> addOption(@RequestBody OptionRequestDto optionRequestDto){
        optionService.addQuestion(optionRequestDto);
        return new SimpleMessageDto<>(HttpStatus.CREATED.getReasonPhrase(), HttpStatus.CREATED.value());
    }

    @GetMapping
    public SimpleMessageDto<List<OptionResponseDto>> getOptions() {
        return new SimpleMessageDto<>(HttpStatus.OK.getReasonPhrase(),
                HttpStatus.OK.value(),
                optionService.getOptions());
    }


    @GetMapping("/{id}")
    public SimpleMessageDto<Boolean> getOptionsByQuestionId(@PathVariable Long id) {
        return new SimpleMessageDto<>(HttpStatus.OK.getReasonPhrase(),
                HttpStatus.OK.value(),
                optionService.getOptionsByQuestionId(id));
    }
}
