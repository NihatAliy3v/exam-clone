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
public  class PersonEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_seq_generator")
    @SequenceGenerator(name = "person_seq_generator", sequenceName = "person_SEQ", allocationSize = 1)
    Long id;

    String name;

    String surname;

    String password;

    String username;

    String fatherName;

    String fin;

    String cardNo;

    String phone;

    String mail;

    @Enumerated(EnumType.STRING)
    private ERole eRole;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.eRole == null) {
            return Collections.emptyList();
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.eRole.name()));
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
