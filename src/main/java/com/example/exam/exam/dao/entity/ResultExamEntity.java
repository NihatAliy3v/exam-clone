package com.example.exam.exam.dao.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

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

    @ManyToOne(cascade = CascadeType.MERGE)
    ExamEntity examEntity;

    @ManyToMany( cascade = CascadeType.MERGE)
    @JoinTable(name = "results_options",
            joinColumns = @JoinColumn(name = "result_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "option_id", referencedColumnName = "id")
    )
    List<OptionEntity> options;
}
