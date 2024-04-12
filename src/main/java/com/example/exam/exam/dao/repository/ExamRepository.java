package com.example.exam.exam.dao.repository;

import com.example.exam.exam.dao.entity.ExamEntity;
import com.example.exam.exam.dao.entity.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExamRepository extends JpaRepository<ExamEntity,Long> {
    @Query(value = "SELECT * FROM learning.Exams e " +
            "INNER JOIN LEARNING.EXAM_PERSON p ON e.ID = p.EXAM_ID " +
            "WHERE p.PERSON_ID =:id", nativeQuery = true)
    List<ExamEntity> findByPersonsId(Long id);


    @Query(value = "SELECT * FROM learning.Exams e " +
            "INNER JOIN LEARNING.EXAM_EMPLOYEES p ON e.ID = p.EXAM_ID " +
            "WHERE p.EMPLOYEE_ID =:id", nativeQuery = true)
    List<ExamEntity> findByEmployeesId(Long id);
}
