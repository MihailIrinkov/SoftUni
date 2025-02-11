package com.ownproject.BreakApp.model.entity;

import com.ownproject.BreakApp.model.enums.UserRoles;
import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity{

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRoles role;

    public Role() {
    }

    public Role(UserRoles role) {
        this.role = role;
    }

    public UserRoles getRole() {
        return role;
    }

    public Role setRole(UserRoles role) {
        this.role = role;
        return this;
    }
}
