package com.example.exam.exam.dao.repository;

import com.example.exam.exam.dao.entity.RoleEntity;
import com.example.exam.exam.dao.entity.AdminEntity;
import com.example.exam.exam.dao.entity.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<AdminEntity, Long> {
    @Query(value = "select r from roles r where r.role = ?1", nativeQuery = false)
    RoleEntity findByName(ERole name);
}