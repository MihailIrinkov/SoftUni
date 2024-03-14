package softuni.exam.models.dto;

import softuni.exam.models.enums.Genre;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class BookImportDTO {

    @Size(min = 3, max = 40)
    @NotNull
    private String author;

    @NotNull
    private boolean available;

    @Size(min = 5)
    @NotNull
    private String description;

    @NotNull
    private Genre genre;

    @NotNull
    @Size(min = 3, max = 40)
    private String title;

    @NotNull
    @Positive
    private Double rating;

    public BookImportDTO() {
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
