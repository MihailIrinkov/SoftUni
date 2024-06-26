package softuni.model.entity;

import jakarta.persistence.*;
import softuni.model.enums.UserRoles;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity{

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRoles name;

    public Role() {

    }

    public UserRoles getName() {
        return name;
    }

    public void setName(UserRoles name) {
        this.name = name;
    }
}
