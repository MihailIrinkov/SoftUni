package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "countries")
public class Country {

    @Id
    @Column(length = 3)
    private String id;

    @Column
    private String name;

    @ManyToMany
    @JoinTable(name = "counties_continents",
    joinColumns = @JoinColumn(name = "country_id",
            referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "continent_id",
            referencedColumnName = "id"))
    private Set<Continent> continent;
}
