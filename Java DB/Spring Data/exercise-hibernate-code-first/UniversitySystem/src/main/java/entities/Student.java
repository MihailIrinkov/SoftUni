package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table
public class Student extends BaseEntity{

    @Column(nullable = false, length = 50)
    private String firstName;

    @Column(nullable = false, length = 60)
    private String lastName;

    @Column
    private String phoneNumber;

    @Column(scale = 2, precision = 4)
    // max averageGrade = 99,99
    private Double averageGrade;

    @Column
    private Boolean attendance;

    @OneToMany
    @JoinColumn
    private Set<Course> courses;
}
