package com.example.exam.exam.service;

import com.example.exam.exam.dao.entity.LogEntity;
import com.example.exam.exam.dao.entity.SubjectEntity;
import com.example.exam.exam.dao.repository.LogMessageRepository;
import com.example.exam.exam.dao.repository.SubjectRepository;
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
    private final LogMessageRepository logMessageRepository;

    public void addSubject(SubjectRequestDto subjectRequestDto) {
        log.info("ActionLog.start subject add method");

        SubjectEntity subjectEntity = subjectMapper.dtoToEntity(subjectRequestDto);
        subjectRepository.save(subjectEntity);

        LogEntity logMessage = new LogEntity();
        logMessage.setLog_level("INFO");
        logMessage.setLo_message("Yeni fənn yaradıldı: " + subjectRequestDto);
        logMessage.setLocalDateTime(LocalDateTime.now());
        //  logMessage.setUserId(AdminHelper.getCurrentAdminIdAndUsername());
        logMessageRepository.save(logMessage);

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
