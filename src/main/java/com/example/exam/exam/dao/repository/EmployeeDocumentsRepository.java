package com.example.exam.exam.dao.repository;

import com.example.exam.exam.dao.entity.EmployeeDocumentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface EmployeeDocumentsRepository extends JpaRepository<EmployeeDocumentsEntity, Long> {
    @Query(value = "SELECT a.emp_id, b.FULLNAME, a.buro_id FROM HR.EMPLOYE_POSITIONS a " +
            "LEFT JOIN HR.EMPLOYE_DOCUMENTS b ON a.emp_id = b.EMP_ID " +
            "WHERE a.date_to = TO_DATE('01.01.3000', 'dd.MM.yyyy') and b.FULLNAME is not null " , nativeQuery = true)
    List<EmployeeDocumentsEntity> findAllEmployees();


    @Query(value = "SELECT a.emp_id, b.FULLNAME, a.buro_id FROM HR.EMPLOYE_POSITIONS a " +
            "LEFT JOIN HR.EMPLOYE_DOCUMENTS b ON a.emp_id = b.EMP_ID " +
            "WHERE a.date_to = TO_DATE('01.01.3000', 'dd.MM.yyyy') and a.EMP_ID=:id"
            , nativeQuery = true)
    EmployeeDocumentsEntity findEmployeeWithID(Long id);
}
