package bg.softuni.pathfinder.model.entity;

import bg.softuni.pathfinder.model.enums.UserRoles;
import jakarta.persistence.*;

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
