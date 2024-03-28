package softuni.exam.service;

import softuni.exam.repository.OfferRepository;

import javax.xml.bind.JAXBException;
import java.io.IOException;

// TODO: Implement all methods
public interface OfferService {

    boolean areImported();

    String readOffersFileContent() throws IOException;
	
	String importOffers() throws IOException, JAXBException;

    String exportOffers();
}
