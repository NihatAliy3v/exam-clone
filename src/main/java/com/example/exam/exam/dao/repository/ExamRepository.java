package com.example.exam.exam.dao.repository;

import com.example.exam.exam.dao.entity.ExamEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<ExamEntity,Long> {
}
