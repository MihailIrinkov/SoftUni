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
@Table(name = "competitions")
public class Competition extends BaseEntity{

    @Column(nullable = false)
    private String name;

    @ManyToOne
    private CompetitionType competitionType;
}
