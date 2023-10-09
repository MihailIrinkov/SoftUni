package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "competition_types")
public class CompetitionType extends BaseEntity{

    @Column(nullable = false)
    private String name;
}
