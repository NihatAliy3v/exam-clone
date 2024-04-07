package com.example.exam.exam.dao.repository;

import com.example.exam.exam.dao.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
    PersonEntity findByFin(String fin);
}
