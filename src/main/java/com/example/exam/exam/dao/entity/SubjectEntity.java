package com.example.exam.exam.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

import jakarta.persistence.*;

import java.util.List;

@Data
@Entity(name = "subjects")
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class SubjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subject_seq_generator")
    @SequenceGenerator(name = "subject_seq_generator", sequenceName = "subject_SEQ", allocationSize = 1)
    Long id;

    String name;

    @OneToMany(mappedBy = "subjectEntity")
    List<QuestionEntity> questionEntities;

    @OneToMany(mappedBy = "subjectEntity")
    @JsonIgnoreProperties("subjectEntity")
    List<ExamDescriptionEntity> examDescriptionEntities;
}
