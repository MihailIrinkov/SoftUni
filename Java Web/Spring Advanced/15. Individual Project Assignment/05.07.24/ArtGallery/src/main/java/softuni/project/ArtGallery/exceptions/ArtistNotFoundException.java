package softuni.project.ArtGallery.exceptions;

public class ArtistNotFoundException extends RuntimeException{

    public ArtistNotFoundException(String message) {
        super(message);
    }

    public ArtistNotFoundException(String message, Throwable ex) {
        super(message, ex);
    }

}
