package bg.softuni.mvcdemo.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Configuration
public class ApplicationBeanConfig {

    @Bean
    public ModelMapper createModelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.addConverter(
                mappingContext -> LocalDate.parse(mappingContext.getSource(),
                        DateTimeFormatter.ofPattern("yyyy-MM-dd")),
//                DateTimeFormatter.ISO_DATE),
                        String.class,
                        LocalDate.class
                );

        return modelMapper;
    }
}
