package com.example.exam.exam.dao.repository;

import com.example.exam.exam.dao.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
    PersonEntity findByFin(String fin);
}
