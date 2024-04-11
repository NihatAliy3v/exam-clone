package com.example.exam.exam.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Entity(name = "exam_description")
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ExamDescriptionEntity {

    @Id
    @GeneratedValue(strategy
            = GenerationType.SEQUENCE, generator = "exam_seq_generator")
    @SequenceGenerator(name = "exam_seq_generator", sequenceName = "exam_SEQ", allocationSize = 1)
    Long id;


    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    SubjectEntity subjectEntity;



    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "exam_id", referencedColumnName = "id")
    ExamEntity examEntity;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "rule_id", referencedColumnName = "id")
    ExamRuleEntity examRuleEntity;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "descryption_question",
            joinColumns = @JoinColumn(name = "descprytion_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "question_id", referencedColumnName = "id")
    )
    List<QuestionEntity> questionEntities;



    int questionScore;
}


