package bg.softuni.pathfinder.model.entity;

import bg.softuni.pathfinder.model.enums.CategoryName;
import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{

    @Enumerated(EnumType.STRING)
    @Column(name = "name", nullable = false)
    private CategoryName name;

    @Column(columnDefinition = "TEXT")
    private String description;

    public Category() {
    }

    public CategoryName getName() {
        return name;
    }

    public void setName(CategoryName name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
