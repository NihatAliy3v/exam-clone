package com.example.exam.exam.dao.repository;

import com.example.exam.exam.dao.entity.LogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogMessageRepository extends JpaRepository<LogEntity, Long> {
}
