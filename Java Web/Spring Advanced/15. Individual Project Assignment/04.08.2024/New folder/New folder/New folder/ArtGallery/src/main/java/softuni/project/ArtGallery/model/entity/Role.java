package softuni.project.ArtGallery.model.entity;

import jakarta.persistence.*;
import softuni.project.ArtGallery.model.enums.UserRoles;

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

    public Role(UserRoles name) {
        this.name = name;
    }

    public void setName(UserRoles name) {
        this.name = name;
    }
}
