package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.TaskImportDto;
import softuni.exam.models.dto.TaskImportRootDto;
import softuni.exam.models.entity.*;
import softuni.exam.repository.CarsRepository;
import softuni.exam.repository.MechanicsRepository;
import softuni.exam.repository.PartsRepository;
import softuni.exam.repository.TasksRepository;
import softuni.exam.service.TasksService;
import softuni.exam.util.ValidationUtilsImpl;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
// TODO: Implement all methods

@Service
public class TasksServiceImpl implements TasksService {

    private final TasksRepository taskRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtilsImpl validationUtils;
    private final MechanicsRepository mechanicsRepository;
    private final PartsRepository partsRepository;
    private final CarsRepository carsRepository;

    private static String TASKS_FILE_PATH = "src/main/resources/files/xml/tasks.xml";

    @Autowired
    public TasksServiceImpl(TasksRepository taskRepository,
                            XmlParser xmlParser,
                            ModelMapper modelMapper,
                            ValidationUtilsImpl validationUtils,
                            MechanicsRepository mechanicsRepository,
                            PartsRepository partsRepository,
                            CarsRepository carsRepository) {
        this.taskRepository = taskRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
        this.mechanicsRepository = mechanicsRepository;
        this.partsRepository = partsRepository;
        this.carsRepository = carsRepository;
    }

    @Override
    public boolean areImported() {
        return this.taskRepository.count() > 0;
    }

    @Override
    public String readTasksFileContent() throws IOException {
        return Files.readString(Path.of(TASKS_FILE_PATH));
    }

    @Override
    public String importTasks() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        List<TaskImportDto> tasks =
                xmlParser.fromFile(Path.of(TASKS_FILE_PATH).toFile(), TaskImportRootDto.class).getTasks();

        for (TaskImportDto t : tasks) {

            Optional<Mechanic> byFirstName =
                    this.mechanicsRepository.findByFirstName(t.getMechanic().getFirstName());

            if (byFirstName.isPresent() && validationUtils.isValid(t)) {

                Task taskToSave = modelMapper.map(t, Task.class);
                taskToSave.setMechanic(byFirstName.get());
                Optional<Part> partById = this.partsRepository.findById(t.getPart().getId());
                taskToSave.setPart(partById.get());

                Optional<Car> carById = this.carsRepository.findById(t.getCar().getId());
                taskToSave.setCar(carById.get());

                this.taskRepository.save(taskToSave);

                sb.append(String.format("Successfully imported task %s%n", t.getPrice().setScale(2)));

            } else {
                sb.append("Invalid task");
                sb.append(System.lineSeparator());
            }

        }

        return sb.toString().trim();
    }

    @Override
    public String getCoupeCarTasksOrderByPrice() {
        StringBuilder sb = new StringBuilder();

        List<Task> taskData = this.taskRepository.findAllByCarCarTypeOrderByPriceDesc(CarType.coupe);

        for (Task t : taskData) {
            sb.append(String.format(
                    "Car %s %s with %dkm\n" +
                            "-Mechanic: %s %s - task №%S:\n" +
                            " --Engine: %s\n" +
                            "---Price: %s$\n",
                    t.getCar().getCarMake(),
                    t.getCar().getCarModel(),
                    t.getCar().getKilometers(),
                    t.getMechanic().getFirstName(),
                    t.getMechanic().getLastName(),
                    t.getId(),
                    t.getCar().getEngine(),
                    t.getPrice().setScale(2)
            ));
        }

        return sb.toString().trim();
    }
}
