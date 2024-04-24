package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.OfferDTO;
import softuni.exam.models.dto.OfferRootDTO;
import softuni.exam.models.entity.Offer;
import softuni.exam.models.entity.Picture;
import softuni.exam.repository.CarRepository;
import softuni.exam.repository.OfferRepository;
import softuni.exam.repository.PictureRepository;
import softuni.exam.repository.SellerRepository;
import softuni.exam.service.OfferService;
import softuni.exam.util.ValidationUtilImpl;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class OfferServiceImpl implements OfferService {

    private static String OFFER_FILE_PATH = "src/main/resources/files/xml/offers.xml";
    private final OfferRepository offerRepository;
    private final PictureRepository pictureRepository;
    private final CarRepository carRepository;
    private final SellerRepository sellerRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtilImpl validationUtil;

    public OfferServiceImpl(OfferRepository offerRepository,
                            PictureRepository pictureRepository,
                            CarRepository carRepository,
                            SellerRepository sellerRepository,
                            XmlParser xmlParser,
                            ModelMapper modelMapper,
                            ValidationUtilImpl validationUtil) {
        this.offerRepository = offerRepository;
        this.pictureRepository = pictureRepository;
        this.carRepository = carRepository;
        this.sellerRepository = sellerRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.offerRepository.count() > 0;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return Files.readString(Path.of(OFFER_FILE_PATH));
    }

    @Override
    public String importOffers() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        List<OfferDTO> offers = xmlParser.fromFile(Path.of(OFFER_FILE_PATH).toFile(), OfferRootDTO.class)
                .getOffers();

//        String str = "2016-03-04 11:30";
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//        LocalDateTime dateTime = LocalDateTime.parse(str, formatter);

        for (OfferDTO o : offers) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime addedOn = LocalDateTime.parse(o.getAddedOn(), formatter);
            Optional<Offer> exists =
                    this.offerRepository.findByDescriptionAndAddedOn(o.getDescription(), addedOn);
            if (exists.isPresent() || !validationUtil.isValid(o)) {
                sb.append("Invalid offer");
                sb.append(System.lineSeparator());

                continue;
            }

            Offer offerToSave = modelMapper.map(o, Offer.class);
            List<Picture> pictures = this.pictureRepository.findAllByCar(
                    this.carRepository.findById(o.getCar().getId()).get());

            offerToSave.setPictures(pictures);
            offerToSave.setCar(this.carRepository.findById(o.getCar().getId()).get());
            offerToSave.setSeller(this.sellerRepository.findById(o.getSeller().getId()).get());
            this.offerRepository.save(offerToSave);
            sb.append(String.format("Successfully import offer %s - %s%n",
                    offerToSave.getAddedOn(), offerToSave.getHasGoldStatus()));
        }

        return sb.toString().trim();
    }
}
