package bg.softuni.pathfinder.model.entity;

import bg.softuni.pathfinder.model.enums.Level;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "routes")
public class Route extends BaseEntity{

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "gpx_coordinates", columnDefinition = "LONGTEXT")
    private String gpxCoordinates;

    @Column
    @Enumerated(EnumType.STRING)
    private Level level;

    @Column(nullable = false)
    private String name;


    @Column(name = "video_url")
    private String videoUrl;

    @Column(name = "image_url")
    private String imageUrl;

    @ManyToOne
    private User author;

    @ManyToMany
    private Set<Category> categories;

    public Route() {
        this.categories = new HashSet<>();
    }

    public Route setVideoUrl (String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Route setImageUrl (String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public void setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVideoUrl() {
        return videoUrl;
    }


    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addCategories(Set<Category> categories) {
        this.categories.addAll(categories);
    }
}
