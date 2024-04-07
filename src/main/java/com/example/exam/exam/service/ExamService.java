package com.example.exam.exam.service;

import com.example.exam.exam.dao.entity.ExamEntity;

import com.example.exam.exam.dao.entity.LogEntity;
import com.example.exam.exam.dao.repository.ExamRepository;
import com.example.exam.exam.dao.repository.LogMessageRepository;
import com.example.exam.exam.mapper.ExamMapper;
import com.example.exam.exam.model.RequestDto.ExamRequestDto;
import com.example.exam.exam.model.ResponseDto.ExamResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ExamService {
    private final ExamRepository examRepository;
    private final ExamMapper examMapper;
    private final LogMessageRepository logMessageRepository;

    public ExamEntity addExam(ExamRequestDto examRequestDto) {
        log.info("ActionLog.start exam add method");

        ExamEntity examEntity = examMapper.dtoToEntity(examRequestDto);

//        LogEntity logMessage = new LogEntity();
//        logMessage.setLog_level("INFO");
//        logMessage.setLo_message("Yeni imtahan yaradıldı: " + examRequestDto);
//        logMessage.setLocalDateTime(LocalDateTime.now());
//        //  logMessage.setUserId(AdminHelper.getCurrentAdminIdAndUsername());
//        logMessageRepository.save(logMessage);


        log.info("ActionLog.end exam add method");
        return examRepository.save(examEntity);

    }

    public ExamResponseDto getExam(Long id) {
        log.info("ActionLog.start exam get method with id: {}", id);

        ExamEntity examEntity = examRepository.findById(id).get();
//        List<ImageEntity> imageEntities=imageRepository.findByExamEntity(examEntity);
//        examEntity.setImageEntities(imageEntities);
        log.info("ActionLog.end exam get method with id: {}", id);
        return examMapper.entityToDto(examEntity);
    }


    public List<ExamResponseDto> getExams() {
        log.info("ActionLog.start exam get method");

        List<ExamEntity> examEntities = examRepository.findAll();

//        for(ExamEntity examEntity:examEntities){
//           List<ImageEntity> imageEntities=imageRepository.findByExamEntity(examEntity);
//           examEntity.setImageEntities(imageEntities);
//        }

        log.info("ActionLog.end exam get method");
        return examMapper.entityToDto(examEntities);
    }

}
