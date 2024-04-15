package com.example.exam.exam.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "subject_result")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubjectResultEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subject_result_seq_generator")
    @SequenceGenerator(name = "subject_result_seq_generator", sequenceName = "subject_result_SEQ", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "result_id", nullable = false)
    private ResultExamEntity result;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private SubjectEntity subject;

    private int trueCount;
    private int falseCount;
    private int score;

}