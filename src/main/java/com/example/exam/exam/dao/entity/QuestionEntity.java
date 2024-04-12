package com.example.exam.exam.dao.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Entity(name = "questions")
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class QuestionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_seq_generator")
    @SequenceGenerator(name = "question_seq_generator", sequenceName = "question_SEQ", allocationSize = 1)
    Long id;

    String name;



    byte score;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(referencedColumnName = "id", name = "subject_id")
    SubjectEntity subjectEntity;

    @OneToMany(mappedBy = "questionEntity", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("questionEntity")
    List<OptionEntity> optionEntities;

    @ManyToMany(mappedBy = "questionEntities")
    @JsonIgnoreProperties("questionEntities")
    List<ExamDescriptionEntity> examDescriptionEntities;

    @OneToOne(mappedBy = "questionEntity")
    @JsonIgnoreProperties("questionEntity")
    Image image;

}
