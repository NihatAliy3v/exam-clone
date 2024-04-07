package com.example.exam.exam.dao.repository;

import com.example.exam.exam.dao.entity.ExamEntity;
import com.example.exam.exam.dao.entity.ResultExamEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultExamRepository extends JpaRepository<ResultExamEntity,Long> {
    List<ResultExamEntity> findAllResultByExamEntity(ExamEntity examEntity);
}
