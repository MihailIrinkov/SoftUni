package entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.loader.plan.build.internal.returns.ScalarReturnImpl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "continents")
public class Continent extends BaseEntity{

    @Column
    private String name;
}
