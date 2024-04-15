package com.example.exam.exam.dao.entity;

import com.example.exam.exam.dao.entity.enums.EResultType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.lang.reflect.Member;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Entity(name = "exam_results")
public class ResultExamEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "result_seq_generator")
    @SequenceGenerator(name = "result_seq_generator", sequenceName = "result_SEQ", allocationSize = 1)
    Long id;

    @Enumerated(EnumType.STRING)
    EResultType eResultType;

    int totalScore;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "exam_id", referencedColumnName = "id")
    private ExamEntity examEntity;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private PersonEntity person;

//    @ManyToOne(cascade = CascadeType.MERGE)
//    @JoinColumn(name = "employee_id", referencedColumnName = "emp_id")
//    private EmployeeDocumentsEntity employee;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "results_options",
            joinColumns = @JoinColumn(name = "result_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "option_id", referencedColumnName = "id")
    )
    List<OptionEntity> options;

    @OneToMany(mappedBy = "result", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SubjectResultEntity> subjectResults;
}
