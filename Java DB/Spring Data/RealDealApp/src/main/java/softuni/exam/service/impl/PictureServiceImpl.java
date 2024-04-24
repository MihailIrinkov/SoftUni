package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.PictureDTO;
import softuni.exam.models.entity.Picture;
import softuni.exam.repository.CarRepository;
import softuni.exam.repository.PictureRepository;
import softuni.exam.service.PictureService;
import softuni.exam.util.ValidationUtilImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PictureServiceImpl implements PictureService {

    private static String PICTURE_FILE_PATH = "src/main/resources/files/json/pictures.json";
    private final PictureRepository pictureRepository;
    private final CarRepository carRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtilImpl validationUtil;

    public PictureServiceImpl(PictureRepository pictureRepository,
                              CarRepository carRepository,
                              Gson gson,
                              ModelMapper modelMapper,
                              ValidationUtilImpl validationUtil) {
        this.pictureRepository = pictureRepository;
        this.carRepository = carRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.pictureRepository.count() > 0;
    }

    @Override
    public String readPicturesFromFile() throws IOException {
        return Files.readString(Path.of(PICTURE_FILE_PATH));
    }

    @Override
    public String importPictures() throws IOException {
        StringBuilder sb = new StringBuilder();

        List<PictureDTO> pictures = Arrays.stream(gson.fromJson(readPicturesFromFile(), PictureDTO[].class))
                .collect(Collectors.toList());

        for (PictureDTO p : pictures) {
            Optional<Picture> exists = this.pictureRepository.findByName(p.getName());
            if (exists.isPresent() || !validationUtil.isValid(p)) {
                sb.append("Invalid picture");
                sb.append(System.lineSeparator());

                continue;
            }

            Picture pictureToSave = modelMapper.map(p, Picture.class);
            pictureToSave.setCar(this.carRepository.findById(p.getCar()).get());
            this.pictureRepository.save(pictureToSave);

            sb.append(String.format("Successfully import picture - %s%n", pictureToSave.getName()));
        }

        return sb.toString().trim();
    }
}
