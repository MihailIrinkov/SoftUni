package com.ownproject.BreakControl.model.entity;

import com.ownproject.BreakControl.model.enums.EmployeeRoles;
import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity{

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EmployeeRoles role;

    public Role() {
    }

    public Role(EmployeeRoles role) {
        this.role = role;
    }

    public EmployeeRoles getRole() {
        return role;
    }

    public Role setRole(EmployeeRoles role) {
        this.role = role;
        return this;
    }
}
