package com.example.exam.exam.dao.repository;

import com.example.exam.exam.dao.entity.DirectoryCatalogsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface  DirectoryCatalogsRepository extends JpaRepository<DirectoryCatalogsEntity, Long> {
    @Query(value = "select id,label from hr.Directory_catalogs  where type_id=2", nativeQuery = true)
    List<DirectoryCatalogsEntity> findAllBuro();

    @Query(value = "select id,label from hr.Directory_catalogs  where type_id=2 and id=:id", nativeQuery = true)
    DirectoryCatalogsEntity findBuroWithId(Long id);

}
