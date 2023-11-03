package bg.softuni.usersystem.domain_entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "albums")
public class Album extends BaseEntity {

    @Column
    private String name;

    @Column
    private String backgroundColor;

    @Column
    private Boolean isPublic;

    @ManyToMany(mappedBy = "albums")
    private Set<Picture> pictures;

    @ManyToOne(optional = false)
    private SecurityProperties.User owner;

}
