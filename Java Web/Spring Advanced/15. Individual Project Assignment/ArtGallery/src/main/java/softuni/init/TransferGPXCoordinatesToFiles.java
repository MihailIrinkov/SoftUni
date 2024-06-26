package softuni.init;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.model.entity.Artist;
import softuni.repository.ArtistRepository;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class TransferGPXCoordinatesToFiles implements CommandLineRunner {

    @Value("${pathfinder.gpx-coordinates.migrate:}")
    private Boolean shouldMigrate;
    private static final String BASE_GPX_COORDINATES_PATH = ".\\src\\main\\resources\\coordinates\\";
    private final ArtistRepository artistRepository;

    @Override
    public void run(String... args) throws Exception {

        if (shouldMigrate) {

            List<Artist> artists = this.artistRepository
                    .findAll()
                    .stream()
                    .filter(artist -> artist.getGpxCoordinates().startsWith("<?xml"))
                    .toList();

            artists.forEach(artist -> {
                String gpxCoordinatesAsString = artist.getGpxCoordinates();

                String filePath = getFilePath(artist.getName(), artist.getAuthor().getUsername());

                try {
                    File file = new File(BASE_GPX_COORDINATES_PATH + filePath);

                    file.getParentFile().mkdirs();
                    file.createNewFile();

                    OutputStream outputStream = new FileOutputStream(file);
                    outputStream.write(gpxCoordinatesAsString.getBytes());

                    artist.setGpxCoordinates(filePath);
                    artistRepository.save(artist);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });

        }
    }

    private String getFilePath(String artistName, String username) {
        String pathPattern = "%s\\%s_%s.xml";
        return String.format(pathPattern,
                username,
                transformArtistName(artistName),
                UUID.randomUUID());
    }

    private String transformArtistName(String artistName) {
        return artistName.toLowerCase()
                .replaceAll("\\s+", "_")
                .replaceAll("\"", "");
    }
}
