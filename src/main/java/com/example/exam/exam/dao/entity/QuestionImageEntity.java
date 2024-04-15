package com.example.exam.exam.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "question_image")
public class QuestionImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_image_seq_generator")
    @SequenceGenerator(name = "question_image_seq_generator", sequenceName = "question_image_SEQ", allocationSize = 1)
    private Long id;

    private String name;

    private String type;

    private String url;

    @Lob
    private byte[] imageData;


    @OneToOne
    @JoinColumn(name = "question_id")
    QuestionEntity questionEntity;
}
