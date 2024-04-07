package com.example.exam.exam.service;

import com.example.exam.exam.dao.entity.DirectoryCatalogsEntity;
import com.example.exam.exam.dao.repository.DirectoryCatalogsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DirectoryCatalogsService {
    private final DirectoryCatalogsRepository directoryCatalogsRepository;

    public DirectoryCatalogsService(DirectoryCatalogsRepository directoryCatalogsRepository) {
        this.directoryCatalogsRepository = directoryCatalogsRepository;
    }


    public List<DirectoryCatalogsEntity> getBuros() {
        log.info("ActionLog.start buro get method");

        List<DirectoryCatalogsEntity> entity = directoryCatalogsRepository.findAllBuro();

        log.info("ActionLog.end buro get method");
        return entity;
    }

    public DirectoryCatalogsEntity getBuro(Long id) {
        log.info("ActionLog.start buro get method with id: {}", id);

        DirectoryCatalogsEntity entity =  directoryCatalogsRepository.findBuroWithId(id);

        log.info("ActionLog.end buro get method with id: {}", id);
        return entity;
    }
}
