package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "towns")
public class Town extends BaseEntity{

    @Column(nullable = false)
    private String name;

    @ManyToOne
    private Country country;
}
