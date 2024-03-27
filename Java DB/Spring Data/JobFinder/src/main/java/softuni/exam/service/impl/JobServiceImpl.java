package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.JobDTO;
import softuni.exam.models.dto.JobRootDTO;
import softuni.exam.models.entity.Company;
import softuni.exam.models.entity.Job;
import softuni.exam.repository.CompanyRepository;
import softuni.exam.repository.JobRepository;
import softuni.exam.service.JobService;
import softuni.exam.util.ValidationUtilsImpl;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

    private static String JOBS_FILE_PATH = "src/main/resources/files/xml/jobs.xml";
    private final JobRepository jobRepository;
    private final CompanyRepository companyRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtilsImpl validationUtils;

    public JobServiceImpl(JobRepository jobRepository,
                          CompanyRepository companyRepository,
                          XmlParser xmlParser,
                          ModelMapper modelMapper,
                          ValidationUtilsImpl validationUtils) {
        this.jobRepository = jobRepository;
        this.companyRepository = companyRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return this.jobRepository.count() > 0;
    }

    @Override
    public String readJobsFileContent() throws IOException {
        return Files.readString(Path.of(JOBS_FILE_PATH));
    }

    @Override
    public String importJobs() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        List<JobDTO> jobs = xmlParser.fromFile(Path.of(JOBS_FILE_PATH).toFile(), JobRootDTO.class)
                .getJobs().stream().toList();

        for (JobDTO j : jobs) {
            Optional<Company> company = this.companyRepository.findById(j.getCompanyId());
            if (company.isEmpty() || !validationUtils.isValid(j)) {
                sb.append("Invalid job");
                sb.append(System.lineSeparator());

                continue;
            }

            Job jobToSave = modelMapper.map(j, Job.class);
            this.jobRepository.save(jobToSave);
            sb.append(String.format("Successfully imported job %s%n", jobToSave.getTitle()));
        }

        return sb.toString().trim();
    }

    @Override
    public String getBestJobs() {
        StringBuilder sb = new StringBuilder();

        List<Job> jobs = this.jobRepository.findBySalaryGreaterThanEqualOrderBySalaryDesc(5000.00);

        for (Job j : jobs) {

            if (j.getHoursAWeek() <= 30) {
                sb.append(String.format("Job title: %s%n", j.getTitle()));
                sb.append(String.format("-Salary: %.2f$%n", j.getSalary()));
                sb.append(String.format("--Hours a week: %.2fh.%n", j.getHoursAWeek()));
            }
        }
        return sb.toString().trim();
    }
}
