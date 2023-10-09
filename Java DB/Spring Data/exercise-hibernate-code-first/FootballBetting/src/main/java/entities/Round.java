package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "rounds")
public class Round extends BaseEntity{

    @Column(nullable = false)
    private String name;
}
