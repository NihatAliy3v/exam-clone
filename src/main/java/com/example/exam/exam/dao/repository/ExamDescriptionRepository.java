package com.example.exam.exam.dao.repository;

import com.example.exam.exam.dao.entity.ExamDescriptionEntity;
import com.example.exam.exam.dao.entity.QuestionEntity;
import com.example.exam.exam.dao.entity.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExamDescriptionRepository extends JpaRepository<ExamDescriptionEntity,Long> {


    List<ExamDescriptionEntity> findByExamEntityId(Long examId);

    ExamDescriptionEntity findBySubjectEntity(SubjectEntity s);

}
