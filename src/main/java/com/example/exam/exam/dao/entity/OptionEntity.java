package com.example.exam.exam.dao.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank(message = "TESTTTT")
    String name;

    @Builder.Default
    Boolean type=false;

    @ManyToOne
    @JsonIgnoreProperties("optionEntities")
    @JoinColumn(name = "question_id")
    QuestionEntity questionEntity;

}
