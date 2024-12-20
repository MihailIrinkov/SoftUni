package softuni.project.ArtGallery.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "pictures")
public class Picture extends BaseEntity{

    @Column
    @NotNull
    private String title;

    @Column(columnDefinition = "TEXT")
    @NotNull
    private String url;

    @ManyToOne
    private User author;

    @ManyToOne
    private Artist artist;

    public Picture() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist route) {
        this.artist = route;
    }
}
