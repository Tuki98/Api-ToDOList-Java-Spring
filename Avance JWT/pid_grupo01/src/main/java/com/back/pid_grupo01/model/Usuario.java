package com.back.pid_grupo01.model;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USUARIO", uniqueConstraints = {
        @UniqueConstraint(columnNames = "dni"),
        @UniqueConstraint(columnNames = "email"),
        @UniqueConstraint(columnNames = "nombre")
})
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue
    private Integer id;

    private String nombre;
    private String apellido;

    @Column(nullable = false, unique = true)
    private String email;

    private String password;

    private Date fecha;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String dni;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public String getUsername() {
        return this.getEmail();  
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
