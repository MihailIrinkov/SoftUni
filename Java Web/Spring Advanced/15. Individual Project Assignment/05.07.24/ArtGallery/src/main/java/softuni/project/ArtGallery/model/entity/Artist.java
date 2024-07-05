package softuni.project.ArtGallery.model.entity;



import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "artists")
public class Artist extends BaseEntity {

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "gpx_coordinates", columnDefinition = "LONGTEXT")
    private String gpxCoordinates;

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

    @OneToMany(mappedBy = "artists")
    private List<Comment> comments;
    @OneToMany(mappedBy = "artist")
    private List<Picture> pictures;

    public Artist() {
        this.categories = new HashSet<>();
        this.comments = new ArrayList<>();
        this.pictures = new ArrayList<>();
    }

    public Artist setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public List<Comment> getComments() {
        return comments;
    }

//    public void setComments(List<Comment> comments) {
//        this.comments = comments;
//    }

    public Artist setComments(List<Comment> comments) {
        this.comments = comments;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Artist setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public void setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
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

    public List<Picture> getPictures() {
        return pictures;
    }

    public Artist setPictures(List<Picture> pictures) {
        this.pictures = pictures;
        return this;
    }
}
