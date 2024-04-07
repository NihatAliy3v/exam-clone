package com.example.exam.exam.dao.repository;

import com.example.exam.exam.dao.entity.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<QuestionEntity,Long> {
    List<QuestionEntity> findAllBySubjectEntityId(Long subId);
}
