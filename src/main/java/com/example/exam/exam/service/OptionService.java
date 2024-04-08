package com.example.exam.exam.service;

import com.example.exam.exam.dao.entity.LogEntity;
import com.example.exam.exam.dao.entity.OptionEntity;
import com.example.exam.exam.dao.repository.LogMessageRepository;
import com.example.exam.exam.dao.repository.OptionRepository;
import com.example.exam.exam.mapper.OptionMapper;
import com.example.exam.exam.model.RequestDto.OptionRequestDto;
import com.example.exam.exam.model.ResponseDto.OptionResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OptionService {

    private final OptionRepository optionRepository;
    private final OptionMapper optionMapper;
    private final LogMessageRepository logMessageRepository;


    public void addQuestion(OptionRequestDto optionRequestDto) {
        log.info("ActionLog.start question add method");

        optionRepository.save(optionMapper.dtoToEntity(optionRequestDto));



        log.info("ActionLog.end question add method");
    }

    public List<OptionResponseDto> getOptions() {
        log.info("ActionLog.start option get method");

        List<OptionEntity> optionEntities = optionRepository.findAll();

        log.info("ActionLog.end option get method");
        return optionMapper.entityToDto(optionEntities);
    }

    public boolean getOptionsByQuestionId(Long questionId) {

        List<OptionEntity> optionEntities = optionRepository.findAllByQuestionEntityId(questionId);
        byte count= 0;
        for (var optionEntity:optionEntities ) {
            if (optionEntity.getType()){
                count++;
                break;
            }
        }
        return count == 1;
    }
}
