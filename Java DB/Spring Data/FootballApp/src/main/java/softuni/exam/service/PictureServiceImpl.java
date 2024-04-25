package softuni.exam.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.domain.dto.PictureDTO;
import softuni.exam.domain.dto.PictureRootDTO;
import softuni.exam.domain.entities.Picture;
import softuni.exam.repository.PictureRepository;
import softuni.exam.util.ValidatorUtilImpl;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PictureServiceImpl implements PictureService {

    private static String PICTURES_FILE_PATH = "src/main/resources/files/xml/pictures.xml";
    private final PictureRepository pictureRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidatorUtilImpl validatorUtil;

    public PictureServiceImpl(PictureRepository pictureRepository,
                              XmlParser xmlParser,
                              ModelMapper modelMapper,
                              ValidatorUtilImpl validatorUtil) {
        this.pictureRepository = pictureRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
    }

    @Override
    public String importPictures() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        List<PictureDTO> pictures = xmlParser.fromFile(Path.of(PICTURES_FILE_PATH).toFile(), PictureRootDTO.class)
                .getPictures().stream().collect(Collectors.toList());

        for (PictureDTO p : pictures) {
            if (!validatorUtil.isValid(p)) {
                sb.append("Invalid picture");
                sb.append(System.lineSeparator());

                continue;
            }

            Picture pictureToSave = modelMapper.map(p, Picture.class);
            this.pictureRepository.save(pictureToSave);
            sb.append(String.format("Successfully imported picture - %s%n",
                    pictureToSave.getUrl()));
        }

        return sb.toString().trim();
    }

    @Override
    public boolean areImported() {
        return this.pictureRepository.count() > 0;
    }

    @Override
    public String readPicturesXmlFile() throws IOException {
        return Files.readString(Path.of(PICTURES_FILE_PATH));
    }

}
