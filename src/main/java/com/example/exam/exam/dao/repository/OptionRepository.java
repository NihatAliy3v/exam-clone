package com.example.exam.exam.dao.repository;

import com.example.exam.exam.dao.entity.OptionEntity;
import com.example.exam.exam.dao.entity.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OptionRepository extends JpaRepository<OptionEntity,Long> {

    List<OptionEntity> findAllByQuestionEntityId(Long questionId);
    List<OptionEntity> findByQuestionEntityIdAndTypeTrue(Long questionId);

    List<OptionEntity> findByQuestionEntity(QuestionEntity question);


}
