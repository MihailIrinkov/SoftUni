package softuni.bg.exerciseJSONprocessing.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category extends BaseEntity{

    @Column(nullable = false, length = 15)
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(name, category.name)
                && Objects.equals(getId(), category.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, getId());
    }

    //    @ManyToMany
//    private Set<Product> products;
}
