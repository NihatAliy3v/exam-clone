package com.example.exam.exam.dao.repository;

import com.example.exam.exam.dao.entity.Image;
import com.example.exam.exam.dao.entity.QuestionImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuestionImageRepository extends JpaRepository<QuestionImageEntity, Long> {
    Optional<QuestionImageEntity> findByName(String name);
}
