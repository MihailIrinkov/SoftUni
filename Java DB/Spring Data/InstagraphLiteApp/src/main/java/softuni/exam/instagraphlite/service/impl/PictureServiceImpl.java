package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dto.PictureDTO;
import softuni.exam.instagraphlite.models.entity.Picture;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.util.ValidationUtilsImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class PictureServiceImpl implements PictureService {

    private static String PICTURE_FILE_PATH = "src/main/resources/files/pictures.json";
    private final PictureRepository pictureRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtilsImpl validationUtils;

    public PictureServiceImpl(PictureRepository pictureRepository,
                              Gson gson,
                              ModelMapper modelMapper,
                              ValidationUtilsImpl validationUtils) {
        this.pictureRepository = pictureRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return this.pictureRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(PICTURE_FILE_PATH));
    }

    @Override
    public String importPictures() throws IOException {
        StringBuilder sb = new StringBuilder();

        List<PictureDTO> puctures = Arrays.stream(gson.fromJson(readFromFileContent(), PictureDTO[].class))
                .toList();

        for (PictureDTO p : puctures) {
            Optional<Picture> exist = this.pictureRepository.findByPath(p.getPath());
            if (exist.isPresent() || !validationUtils.isValid(p)) {
                sb.append("Invalid Picture");
                sb.append(System.lineSeparator());

                continue;
            }

            Picture pictureToSave = modelMapper.map(p, Picture.class);
            this.pictureRepository.save(pictureToSave);

            sb.append(String.format("Successfully imported Picture, with size %.2f%n",
                    pictureToSave.getSize()));
        }


        return sb.toString().trim();
    }

    @Override
    public String exportPictures() {
        StringBuilder sb = new StringBuilder();

        List<Picture> pictures = this.pictureRepository.findAllBySizeGreaterThanOrderBySizeAsc(30000.0);

        for (Picture p : pictures) {
            sb.append(String.format("%.2f - %s%n", p.getSize(), p.getPath()));
        }

        return sb.toString().trim();
    }
}
