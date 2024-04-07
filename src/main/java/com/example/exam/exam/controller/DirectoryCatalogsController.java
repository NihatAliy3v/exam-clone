package com.example.exam.exam.controller;


import com.example.exam.exam.dao.entity.DirectoryCatalogsEntity;
import com.example.exam.exam.model.ResponseDto.SimpleMessageDto;
import com.example.exam.exam.service.DirectoryCatalogsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/catalogs")
public class DirectoryCatalogsController {
    private final DirectoryCatalogsService directoryCatalogsService;

    public DirectoryCatalogsController(DirectoryCatalogsService directoryCatalogsService) {
        this.directoryCatalogsService = directoryCatalogsService;
    }


    @GetMapping()
    public SimpleMessageDto<List<DirectoryCatalogsEntity>> getBuros() {
        return new SimpleMessageDto<>(HttpStatus.OK.getReasonPhrase(),
                HttpStatus.OK.value(),
                directoryCatalogsService.getBuros());
    }

    @GetMapping("/{id}")
    public SimpleMessageDto<DirectoryCatalogsEntity> getBuro(@PathVariable Long id) {
        return new SimpleMessageDto<>(HttpStatus.OK.getReasonPhrase(),
                HttpStatus.OK.value(),
                directoryCatalogsService.getBuro(id));
    }
}
