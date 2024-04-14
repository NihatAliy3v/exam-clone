package com.example.exam.exam.dao.entity;

import com.example.exam.exam.dao.entity.enums.ERole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "roles")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleEntity  {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_seq_generator")
    @SequenceGenerator(name = "role_seq_generator", sequenceName = "role_SEQ", allocationSize = 1)
    private Long id;

    private ERole role;

}