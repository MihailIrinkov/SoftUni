package softuni.bg.jsoncardealer.services.supplier;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.bg.jsoncardealer.domain.entities.Supplier;
import softuni.bg.jsoncardealer.domain.models.LocalSuppliersExportModel;
import softuni.bg.jsoncardealer.repositories.SupplierRepository;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static softuni.bg.jsoncardealer.constants.Pats.THIRD_OUTPUT_JSON;

@Service
public class SupplierServiceImpl implements SupplierService{

    private final SupplierRepository supplierRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public List<Supplier> getAllByIsImporterTrue() throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting()
                .excludeFieldsWithoutExposeAnnotation().create();

        final List<Supplier> suppliers = this.supplierRepository.findAllByIsImporterFalse()
                .stream().toList();

        final List<LocalSuppliersExportModel> localSuppliersExport = suppliers.stream()
                .map(supplier -> modelMapper.map(supplier, LocalSuppliersExportModel.class))
                .toList();

        FileWriter fileWriter = new FileWriter(THIRD_OUTPUT_JSON.toFile());

        gson.toJson(localSuppliersExport, fileWriter);

        return suppliers;
    }
}
