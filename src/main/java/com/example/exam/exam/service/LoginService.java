package com.example.exam.exam.service;

import com.example.exam.exam.dao.entity.PersonEntity;
import com.example.exam.exam.dao.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class LoginService {

    private final PersonRepository personRepository;

    public boolean login(String fin) {
        PersonEntity person = personRepository.findByFin(fin);

        if (person != null) {
            return true;
        }else
            return false;
    }
}
