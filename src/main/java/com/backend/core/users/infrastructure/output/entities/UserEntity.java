package com.backend.core.users.infrastructure.output.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @NotEmpty
    private String name;
    
    @NotEmpty
    private String lastname;
    
    @NotEmpty
    private String document;
    
    @NotEmpty
    private String phone;
    
    @NotEmpty
    @Email
    @Column( unique = true )
    private String email;
    
    @NotEmpty
    private String password;

    private LocalDate birthDate;

    @ManyToOne( fetch = FetchType.LAZY )
    private RoleEntity role;

}

