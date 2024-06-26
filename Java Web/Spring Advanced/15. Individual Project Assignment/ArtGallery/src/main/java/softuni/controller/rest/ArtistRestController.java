package softuni.controller.rest;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import softuni.service.ArtistService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ArtistRestController {

    public final ArtistService artistService;

    @GetMapping("artists/coordinates/{id}")
    public List<List<Double>> getArtistCoordinates(@PathVariable("id") Long artistId) {
        return artistService.getCoordinates(artistId);
    }

}
