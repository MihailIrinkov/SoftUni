package softuni.bg.jsoncardealer.services.supplier;

import softuni.bg.jsoncardealer.domain.entities.Supplier;

import java.io.IOException;
import java.util.List;

public interface SupplierService {

    List<Supplier> getAllByIsImporterTrue() throws IOException;

}
