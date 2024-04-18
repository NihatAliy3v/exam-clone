package com.example.exam.exam.dao.entity;

import com.example.exam.exam.dao.entity.enums.ERole;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Data
@Entity(name = "persons")
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public  class PersonEntity  {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_seq_generator")
    @SequenceGenerator(name = "person_seq_generator", sequenceName = "person_SEQ", allocationSize = 1)
    Long id;

    String name;

    String surname;

    String fatherName;

    String fin;


    String cardNo;

    String phone;

    String mail;

    @Enumerated(EnumType.STRING)
    private ERole eRole;

}
