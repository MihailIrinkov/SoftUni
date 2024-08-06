package softuni.project.ArtGallery.config;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import softuni.project.ArtGallery.service.impl.SessionRegistryImpl;
import softuni.project.ArtGallery.service.session.SessionRegistry;

@Configuration
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();

    }
}
