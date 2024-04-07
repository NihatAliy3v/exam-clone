package com.example.exam.exam.dao.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@Entity(name = "logs")
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class LogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "log_seq_generator")
    @SequenceGenerator(name = "log_seq_generator", sequenceName = "log_SEQ", allocationSize = 1)
    Long id;

    private String log_level;

    private String lo_message;

    private LocalDateTime localDateTime;
}
