package bg.softuni.pathfinder.config;

import bg.softuni.pathfinder.model.dto.binding.UserRegisterBindingModel;
import bg.softuni.pathfinder.model.dto.view.RouteCategoryViewModel;
import bg.softuni.pathfinder.model.dto.view.RouteDetailsViewModel;
import bg.softuni.pathfinder.model.entity.Route;
import bg.softuni.pathfinder.model.entity.User;
import bg.softuni.pathfinder.repository.CategoryRepository;
import bg.softuni.pathfinder.repository.UserRepository;
import bg.softuni.pathfinder.service.session.LoggedUser;
import bg.softuni.pathfinder.util.YouTubeUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.Provider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AppConfig {

    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final LoggedUser loggedUser;

//    private final RoleService roleService;

    public AppConfig(CategoryRepository categoryRepository, UserRepository userRepository, LoggedUser loggedUser) {
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
        this.loggedUser = loggedUser;
    }


    @Bean
    public ModelMapper modelMapper() {
        final ModelMapper modelMapper = new ModelMapper();

//        Provider<User> loggedUserProvider = req -> getLoggeduser();
//        Provider<String> youtubeSubUrlProvider = req -> YouTubeUtil.getUrl((String) req.getSource());

        modelMapper.createTypeMap(Route.class, RouteDetailsViewModel.class)
                .addMappings(mapper -> mapper
                        .map(route -> route.getAuthor().getUsername(),
                                RouteDetailsViewModel::setAuthorName));

        // RouteCategoryViewModel
        modelMapper
                .createTypeMap(Route.class, RouteCategoryViewModel.class)
                .addMappings(mapper -> mapper
                        .map(Route::getName, RouteCategoryViewModel::setTitle));

        return modelMapper;
    }


//    @Bean
//    public ModelMapper modelMapper(){
//        return new ModelMapper();
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
