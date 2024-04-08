package com.example.exam.exam.exception;

import com.example.exam.exam.model.ResponseDto.SimpleMessageDto;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(CustomerException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)

    SimpleMessageDto<ExceptionDto> handle(CustomerException exception) {
        log.info("ActionLog.handle.error CustomerException handled");
        return new SimpleMessageDto<>(exception.getMessage(), HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public SimpleMessageDto<List<ExceptionDto>> handle(MethodArgumentNotValidException exception) {
        List<ExceptionDto> errors = new ArrayList<>();
        exception.getBindingResult().getFieldErrors().forEach(e -> errors.add(new ExceptionDto(e.getDefaultMessage())));
        return new SimpleMessageDto<>(errors.get(0).getCode(), HttpStatus.BAD_REQUEST.value());
    }


    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionDto paramsValidationHandler(ConstraintViolationException exception) {
        return new ExceptionDto(exception.getMessage());
    }
}