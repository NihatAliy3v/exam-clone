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
@Table(name = "Images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "image_seq_generator")
    @SequenceGenerator(name = "image_seq_generator", sequenceName = "image_SEQ", allocationSize = 1)
    private Long id;

    private String name;

    private String type;

    private String url;

    @Lob
    private byte[] imageData;

    @ManyToOne
    @JoinColumn(name = "exam_id", referencedColumnName = "id")
    ExamEntity examEntity;
}
