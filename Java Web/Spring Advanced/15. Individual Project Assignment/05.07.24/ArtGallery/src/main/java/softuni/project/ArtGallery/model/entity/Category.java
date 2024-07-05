package softuni.project.ArtGallery.model.entity;


import jakarta.persistence.*;
import softuni.project.ArtGallery.model.enums.CategoryNames;

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
