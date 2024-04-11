package com.example.exam.exam.dao.repository;

import com.example.exam.exam.dao.entity.ExamDescriptionEntity;
import com.example.exam.exam.dao.entity.ExamRuleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRuleRepository extends JpaRepository<ExamRuleEntity,Long> {

}
