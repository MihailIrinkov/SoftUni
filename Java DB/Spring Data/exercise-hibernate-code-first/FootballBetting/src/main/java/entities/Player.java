package entities;

import entities.BaseEntity;
import entities.Team;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "players")
public class Player extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column
    private Short squadNumber;

    @ManyToOne
    private Team team;

    @ManyToOne
    private Position position;

    @Column(name = "is_currently_injured")
    private Boolean isInjured;
}
