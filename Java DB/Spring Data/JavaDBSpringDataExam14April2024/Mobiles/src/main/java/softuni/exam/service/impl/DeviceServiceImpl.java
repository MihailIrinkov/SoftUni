package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.DeviceDTO;
import softuni.exam.models.dto.DeviceRootDTO;
import softuni.exam.models.entity.Device;
import softuni.exam.models.entity.DeviceType;
import softuni.exam.models.entity.Sale;
import softuni.exam.repository.DeviceRepository;
import softuni.exam.repository.SaleRepository;
import softuni.exam.service.DeviceService;
import softuni.exam.util.ValidationUtilImpl;
import softuni.exam.util.XmlParserImpl;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import static softuni.exam.models.entity.DeviceType.SMART_PHONE;

@Service
public class DeviceServiceImpl implements DeviceService {

    private static String DEVICE_FILE_PATH = "src/main/resources/files/xml/devices.xml";
    private final DeviceRepository deviceRepository;
    private final SaleRepository saleRepository;
    private final XmlParserImpl xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtilImpl validationUtil;

    public DeviceServiceImpl(XmlParserImpl xmlParser,
                             ModelMapper modelMapper,
                             ValidationUtilImpl validationUtil,
                             DeviceRepository deviceRepository,
                             SaleRepository saleRepository) {
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.deviceRepository = deviceRepository;
        this.saleRepository = saleRepository;
    }


    @Override
    public boolean areImported() {
        return this.deviceRepository.count() > 0;
    }

    @Override
    public String readDevicesFromFile() throws IOException {
        return Files.readString(Path.of(DEVICE_FILE_PATH));
    }

    @Override
    public String importDevices() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        List<DeviceDTO> devices = xmlParser.fromFile(Path.of(DEVICE_FILE_PATH).toFile(), DeviceRootDTO.class)
                .getDevices();

        for (DeviceDTO d : devices) {
            Optional<Device> exists =
                    this.deviceRepository.findAllByModelAndBrand(d.getModel(), d.getBrand());
            Optional<Sale> saleExists =
                    this.saleRepository.findById(d.getSaleId());

            if (exists.isPresent() || saleExists.isEmpty() || !validationUtil.isValid(d)) {
                sb.append("Invalid device");
                sb.append(System.lineSeparator());

                continue;
            }

            Device deviceToSave = modelMapper.map(d, Device.class);
            deviceToSave.setSale(this.saleRepository.findById(d.getSaleId()).get());
            this.deviceRepository.save(deviceToSave);

            sb.append(String.format("Successfully imported device of type %s with brand %s%n",
                    deviceToSave.getDeviceType(),
                    deviceToSave.getBrand()));
        }

        return sb.toString().trim();
    }

    @Override
    public String exportDevices() {
        StringBuilder sb = new StringBuilder();

        List<Device> devices = this.deviceRepository.findAllByDeviceTypeAndPriceLessThanOrderByBrandAsc(
                DeviceType.SMART_PHONE, 1000.0
        );

        List<Device> filterD = new ArrayList<>();

        for (Device device : devices) {
            if (device.getStorage() >= 128) {
                filterD.add(device);
            }
        }


        for (Device d : filterD) {

            sb.append(String.format("Device brand: %s\n" +
                            "   *Model: %s\n" +
                            "   **Storage: %d\n" +
                            "   ***Price: %.2f\n",
                    d.getBrand(),
                    d.getModel(),
                    d.getStorage(),
                    d.getPrice()));
        }

        return sb.toString().trim();
    }
}
