package com.example.exam.exam.service;

import com.example.exam.exam.dao.entity.PersonEntity;
import com.example.exam.exam.dao.repository.PersonRepository;
import com.example.exam.exam.exception.CustomerException;
import com.example.exam.exam.model.RequestDto.AuthRequestDtoPerson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class LoginService {

    private final PersonRepository personRepository;

    public Long login(AuthRequestDtoPerson authRequestDtoPerson) {
        PersonEntity person = personRepository.findByFin(authRequestDtoPerson.getFin());

        if (person != null) {
            return person.getId();
        }else
         throw new CustomerException("Bu FIN kod mövcud deyil");
    }
}
