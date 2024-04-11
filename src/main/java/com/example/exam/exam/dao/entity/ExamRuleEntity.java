package com.example.exam.exam.dao.entity;

import com.example.exam.exam.dao.entity.enums.ExamPersonType;
import com.example.exam.exam.dao.entity.enums.ExamStatus;
import com.example.exam.exam.dao.entity.enums.ExamTimeType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Data
@Entity(name = "rules")
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ExamRuleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "exam_seq_generator")
    @SequenceGenerator(name = "exam_seq_generator", sequenceName = "exam_SEQ", allocationSize = 1)
    Long id;

    String name;

    int trueCount;

    int falseCount;

    @OneToMany(mappedBy = "examRuleEntity")
    @JsonIgnoreProperties("examRuleEntity")
    List<ExamDescriptionEntity> examDescriptionEntities;

}


