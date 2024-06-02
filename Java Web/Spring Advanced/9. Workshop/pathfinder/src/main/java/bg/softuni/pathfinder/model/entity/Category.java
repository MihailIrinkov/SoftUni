package bg.softuni.pathfinder.model.entity;

import bg.softuni.pathfinder.model.enums.CategoryNames;
import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{

    @Enumerated(EnumType.STRING)
    @Column(name = "name", nullable = false)
    private CategoryNames name;

    @Column(columnDefinition = "TEXT")
    private String description;

    public Category() {
    }

    public CategoryNames getName() {
        return name;
    }

    public void setName(CategoryNames name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
