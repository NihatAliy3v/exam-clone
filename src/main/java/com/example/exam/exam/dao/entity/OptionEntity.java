package com.example.exam.exam.dao.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Entity(name = "options")
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class OptionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "option_seq_generator")
    @SequenceGenerator(name = "option_seq_generator", sequenceName = "option_SEQ", allocationSize = 1)
    Long id;

    String name;

    @Builder.Default
    Boolean type=false;

    @ManyToOne
    @JoinColumn(name = "question_id")
    QuestionEntity questionEntity;

}
