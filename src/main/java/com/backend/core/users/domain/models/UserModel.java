package com.backend.core.users.domain.models;

import java.time.LocalDate;

public class UserModel {

    private Long id;
    private String name;
    private String lastname;
    private String document;
    private String phone;
    private String email;
    private String password;
    private LocalDate birthDate;

    private RoleModel role;

    public UserModel() {
    }    

    public UserModel(Long id, String name, String lastname, String document, String phone, String email,
            String password, LocalDate birthDate, RoleModel role) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.document = document;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
        this.role = role;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }


    public RoleModel getRole() {
        return role;
    }

    public void setRole(RoleModel role) {
        this.role = role;
    }

}
