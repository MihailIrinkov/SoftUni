package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@Table
public class Course extends BaseEntity{

    @Column(nullable = false, length = 50)
    private String name;

    @Column(length = 250)
    private String description;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column
    private Short credits;

    @OneToMany
    @JoinColumn
    private Set<Student> students;

    @OneToOne
    private Teacher teacher;
}
