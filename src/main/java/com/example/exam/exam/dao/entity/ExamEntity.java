package com.example.exam.exam.dao.entity;

import com.example.exam.exam.dao.entity.enums.ExamPersonType;
import com.example.exam.exam.dao.entity.enums.ExamStatus;
import com.example.exam.exam.dao.entity.enums.ExamTimeType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import lombok.experimental.FieldDefaults;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Data
@Entity(name = "exams")
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ExamEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "exam_seq_generator")
    @SequenceGenerator(name = "exam_seq_generator", sequenceName = "exam_SEQ", allocationSize = 1)
    Long id;

    String name;

    @Temporal(TemporalType.DATE)
    Date startTime;

    @Temporal(TemporalType.DATE)
    Date endTime;

    int expirationTime;

    @Enumerated(EnumType.STRING)
    ExamStatus examStatus;

    @Enumerated(EnumType.STRING)
    ExamPersonType examPersonType;

    @Enumerated(EnumType.STRING)
    ExamTimeType examTimeType;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "exam_employees",
            joinColumns = @JoinColumn(name = "exam_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id", referencedColumnName = "emp_id")
    )
    List<EmployeeDocumentsEntity> employees;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "exam_person",
            joinColumns = @JoinColumn(name = "exam_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "person_id", referencedColumnName = "id")
    )
    List<PersonEntity> personEntities;

    @OneToMany(mappedBy = "examEntity", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("examEntity")
    List<Image> imageEntities;


    @OneToMany(mappedBy = "examEntity")
    @JsonIgnoreProperties("examEntity")
    List<ExamDescriptionEntity> examDescriptionEntities;
}


