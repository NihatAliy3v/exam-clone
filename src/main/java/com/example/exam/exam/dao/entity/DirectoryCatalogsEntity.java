package com.example.exam.exam.dao.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;


@Entity
@Table(schema = "hr",name = "directory_catalogs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DirectoryCatalogsEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "directory_seq_generator")
    @SequenceGenerator(name = "directory_seq_generator", sequenceName = "directory_SEQ", allocationSize = 1)
    Long id;

    String label;

}