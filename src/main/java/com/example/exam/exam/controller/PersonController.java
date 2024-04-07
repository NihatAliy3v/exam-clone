package com.example.exam.exam.controller;

import com.example.exam.exam.model.RequestDto.LoginDto;
import com.example.exam.exam.model.RequestDto.PersonRequestDto;
import com.example.exam.exam.model.ResponseDto.PersonResponseDto;
import com.example.exam.exam.model.ResponseDto.SimpleMessageDto;
import com.example.exam.exam.service.LoginService;
import com.example.exam.exam.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;
    private final LoginService loginService;


    @PostMapping(consumes = "application/json", produces = "application/json")
    public SimpleMessageDto<PersonRequestDto> addPerson(@RequestBody PersonRequestDto personRequestDto){
        personService.addPerson(personRequestDto);
        return new SimpleMessageDto<>(HttpStatus.CREATED.getReasonPhrase(), HttpStatus.CREATED.value());
    }

    @GetMapping
    public SimpleMessageDto<List<PersonResponseDto>> getPersons() {
        return new SimpleMessageDto<>(HttpStatus.OK.getReasonPhrase(),
                HttpStatus.OK.value(),
                personService.getPersons());
    }

    @PostMapping("/login")
    public Boolean login(String fin){
        return loginService.login(fin);
    }
}
