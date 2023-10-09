package entities;

import entities.enums.Initials;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Setter
@Getter
@Entity
@Table(name = "teams")
public class Team extends BaseEntity{

    @Column(nullable = false)
    private String name;

    @Column
    private String logo;

    @Column
    @Enumerated(EnumType.STRING)
    private Initials shortName;

    //@Column(nullable = false)
    @ManyToOne
    @JoinColumn
    private Color primaryColor;

    //@Column(nullable = false)
    @ManyToOne
    @JoinColumn
    private Color secondaryColor;

    @ManyToOne
    private Town honeTown;

    @Column
    private BigDecimal budget;
}
