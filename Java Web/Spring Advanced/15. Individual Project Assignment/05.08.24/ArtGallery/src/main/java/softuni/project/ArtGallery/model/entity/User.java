package softuni.project.ArtGallery.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(nullable = false, unique = true)
    @Size(min = 3)
    private String username;

    @Column(nullable = false)
    @Size(min = 4)
    private String password;

    @Column(name = "full_name", nullable = false)
    @Size(min = 3)
    private String fullName;

    @Column
    @Positive
    private Integer age;

    @Column
    @Email
    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "users_roles",
//            joinColumns = {
//                    @JoinColumn(name = "user_id", referencedColumnName = "id")},
//            inverseJoinColumns = {
//                    @JoinColumn(name = "role_id", referencedColumnName = "id")}
//    )
    private Set<Role> roles;


    public User() {
        this.roles = new HashSet<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
