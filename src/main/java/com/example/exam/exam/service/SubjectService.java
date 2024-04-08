package com.example.exam.exam.service;

import com.example.exam.exam.dao.entity.LogEntity;
import com.example.exam.exam.dao.entity.SubjectEntity;
import com.example.exam.exam.dao.repository.LogMessageRepository;
import com.example.exam.exam.dao.repository.SubjectRepository;
import com.example.exam.exam.exception.CustomerException;
import com.example.exam.exam.mapper.SubjectMapper;
import com.example.exam.exam.model.RequestDto.SubjectRequestDto;
import com.example.exam.exam.model.ResponseDto.SubjectResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SubjectService {

    private final SubjectRepository subjectRepository;
    private final SubjectMapper subjectMapper;

    public void addSubject(SubjectRequestDto subjectRequestDto) {
        log.info("ActionLog.start subject add method");



        if (!subjectRepository.findAll().isEmpty()) {
            List<SubjectEntity> subjectEntities = subjectRepository.findAll();

            for (var subject : subjectEntities) {
                if (subjectRequestDto.getName().equals(subject.getName())) {
                    throw new CustomerException("Bu fənn artıq yaradılıb");
                }
            }
        }

        SubjectEntity subjectEntity = subjectMapper.dtoToEntity(subjectRequestDto);
        subjectRepository.save(subjectEntity);


        log.info("ActionLog.end subject add method");
    }

    public List<SubjectResponseDto> getSubjects() {
        log.info("ActionLog.start subject get method");

        List<SubjectEntity> subjectEntities = subjectRepository.findAll();

        log.info("ActionLog.end subject get method");
        return subjectMapper.entityToDtos(subjectEntities);
    }

    public SubjectResponseDto getSubject(Long id) {
        log.info("ActionLog.start subject get method with id: {}", id);

        SubjectEntity subjectEntity = subjectRepository.findById(id).get();

        log.info("ActionLog.end subject get method with id: {}", id);
        return subjectMapper.entityToDto(subjectEntity);
    }

}
