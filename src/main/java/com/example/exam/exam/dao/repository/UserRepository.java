package com.example.exam.exam.dao.repository;

import com.example.exam.exam.dao.entity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<AdminEntity, Long> {
    Optional<AdminEntity> findUserByUsername(String username);
}