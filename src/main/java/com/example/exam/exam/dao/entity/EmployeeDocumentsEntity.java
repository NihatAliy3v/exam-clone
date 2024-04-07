package com.example.exam.exam.dao.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Table(schema = "hr",name = "employe_documents")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeDocumentsEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq_generator")
    @SequenceGenerator(name = "employee_seq_generator", sequenceName = "employee_SEQ", allocationSize = 1)
    @Column(name = "emp_id", nullable = false, unique = true)
    Long empId;

    @Column(name = "fullname")
    String fullName;

//    @ManyToMany(mappedBy = "employees")
//    List<ResultSurveyEntity> resultSurveyEntities;

    Long buroId;

}