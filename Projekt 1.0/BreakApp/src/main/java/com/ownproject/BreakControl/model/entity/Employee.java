package com.ownproject.BreakControl.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee extends BaseEntity{

    @Column(nullable = false, unique = true)
    @Size(min = 4)
    private String username;

    @Column(nullable = false)
    @Email
    private String email;

    @ManyToMany
    private List<Role> roles;

    @ManyToMany
    private List<Chanel> chanels;

    @OneToOne
    private Availability availability;

    public Employee() {
        this.roles = new ArrayList<>();
        this.chanels = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public Employee setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Employee setEmail(String email) {
        this.email = email;
        return this;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public Employee setRoles(List<Role> roles) {
        this.roles = roles;
        return this;
    }
}
