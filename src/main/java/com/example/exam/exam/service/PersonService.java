package com.example.exam.exam.service;

import com.example.exam.exam.dao.entity.LogEntity;
import com.example.exam.exam.dao.entity.OptionEntity;
import com.example.exam.exam.dao.entity.PersonEntity;
import com.example.exam.exam.dao.repository.LogMessageRepository;
import com.example.exam.exam.dao.repository.PersonRepository;
import com.example.exam.exam.mapper.PersonMapper;
import com.example.exam.exam.model.RequestDto.PersonRequestDto;
import com.example.exam.exam.model.ResponseDto.OptionResponseDto;
import com.example.exam.exam.model.ResponseDto.PersonResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;
    private final LogMessageRepository logMessageRepository;
    private final PasswordEncoder passwordEncoder;

    public void addPerson(PersonRequestDto personRequestDto) {
        log.info("ActionLog.start person add method");

        PersonEntity personEntity = personMapper.dtoToEntity(personRequestDto);


        personRepository.save(personEntity);

        LogEntity logMessage = new LogEntity();
        logMessage.setLog_level("INFO");
        logMessage.setLo_message("Yeni şexs yaradıldı: " + personRequestDto);
        logMessage.setLocalDateTime(LocalDateTime.now());
        //  logMessage.setUserId(AdminHelper.getCurrentAdminIdAndUsername());
        logMessageRepository.save(logMessage);

        log.info("ActionLog.end person add method");
    }

    public List<PersonResponseDto> getPersons() {
        log.info("ActionLog.start person get method");

        List<PersonEntity> personEntities = personRepository.findAll();

        log.info("ActionLog.end person get method");
        return personMapper.entityToDto(personEntities);
    }


}
