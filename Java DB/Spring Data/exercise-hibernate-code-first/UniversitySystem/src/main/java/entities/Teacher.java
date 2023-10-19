package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@Entity
@Table
public class Teacher extends BaseEntity{

    @Column(nullable = false, length = 50)
    private String firstName;

    @Column(nullable = false, length = 60)
    private String lastName;

    @Column(nullable = false, length = 30)
    private String phoneNumber;

    @Column
    private String email;

    @Column(scale = 2, precision = 5)
    private BigDecimal salaryPerHour;

    @OneToMany
    @JoinColumn
    private Set<Course> courses;
}
