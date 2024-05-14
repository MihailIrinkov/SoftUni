package bg.softuni.pathfinder.service.impl;

import bg.softuni.pathfinder.exceptions.RouteNotFoundException;
import bg.softuni.pathfinder.model.dto.binding.AddRouteBindingModel;
import bg.softuni.pathfinder.model.dto.binding.UploadPictureRouteBindingModel;
import bg.softuni.pathfinder.model.dto.view.RouteCategoryViewModel;
import bg.softuni.pathfinder.model.dto.view.RouteDetailsViewModel;
import bg.softuni.pathfinder.model.dto.view.RouteGetAllViewModel;
import bg.softuni.pathfinder.model.entity.Category;
import bg.softuni.pathfinder.model.entity.Route;
import bg.softuni.pathfinder.model.entity.User;
import bg.softuni.pathfinder.model.enums.CategoryNames;
import bg.softuni.pathfinder.repository.CategoryRepository;
import bg.softuni.pathfinder.repository.RouteRepository;
import bg.softuni.pathfinder.service.RouteService;
import bg.softuni.pathfinder.service.UserService;
import bg.softuni.pathfinder.service.session.LoggedUser;
import bg.softuni.pathfinder.util.YouTubeUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class RouteServiceImpl implements RouteService {

    private static final String BASE_GPX_COORDINATES_PATH = ".\\src\\main\\resources\\coordinates\\";
    private static final String BASE_IMAGES_PATH = ".\\src\\main\\resources\\images\\";
    private final RouteRepository routeRepository;
    private final CategoryRepository categoryRepository;

    private final UserService userService;
    private final ModelMapper modelMapper;
    private final LoggedUser loggedUser;

    private final ModelMapper mapper;

    public RouteServiceImpl(RouteRepository repository,
                            CategoryRepository categoryRepository,
                            UserService userService,
                            ModelMapper modelMapper,
                            LoggedUser user,
                            ModelMapper mapper) {
        this.routeRepository = repository;
        this.categoryRepository = categoryRepository;
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.loggedUser = user;
        this.mapper = mapper;
    }

    @Override
    public void add(AddRouteBindingModel addRouteBindingModel) {
        Route route = mapper.map(addRouteBindingModel, Route.class);
        route.getCategories().clear();

        String filePath = getFilePath(route.getName());
        boolean isUploaded = uploadGpxCoordinates(addRouteBindingModel.getGpxCoordinates(), filePath);

        if (isUploaded) {
            route.setGpxCoordinates(filePath);
        }


        Set<Category> categories = categoryRepository
                .findByNameIn(addRouteBindingModel.getCategories());
        route.addCategories(categories);

        User user = userService.getLoggedUser();
        route.setAuthor(user);

        route.setVideoUrl(YouTubeUtil.getUrl(addRouteBindingModel.getVideoUrl()));

        this.routeRepository.save(route);
    }

    private boolean uploadGpxCoordinates(MultipartFile file, String filePath) {

        try {
            File newFile = new File(BASE_GPX_COORDINATES_PATH + filePath);
            newFile.getParentFile().mkdirs();
            newFile.createNewFile();

            OutputStream outputStream = new FileOutputStream(newFile);
            outputStream.write(file.getBytes());

            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public List<RouteGetAllViewModel> getAll() {
        return routeRepository.findAll().stream()
                .map(route -> modelMapper.map(route, RouteGetAllViewModel.class))
                .toList();

    }

    @Override
    public RouteDetailsViewModel getDetails(Long id) {
        Route route = routeRepository.findById(id)
                .orElseThrow(() -> new RouteNotFoundException(
                        "Route with id: " + id + " was not found!"));

        return modelMapper.map(route, RouteDetailsViewModel.class);
    }

    @Override
    public void uploadPicture(UploadPictureRouteBindingModel uploadPictureRouteBindingModel) {
        MultipartFile pictureFile = uploadPictureRouteBindingModel.getPicture();

        String picturePath = getPicturePath(pictureFile);

        try {
            File file = new File(BASE_IMAGES_PATH + picturePath);
            file.getParentFile().mkdirs();
            file.createNewFile();

            OutputStream outputStream = new FileOutputStream(file);
            outputStream.write(pictureFile.getBytes());

            Optional<Route> optionalRoute =
                    routeRepository.findById(uploadPictureRouteBindingModel.getId());

            if (optionalRoute.isPresent()) {
                Route route = optionalRoute.get();
                route.setImageUrl(picturePath);
                routeRepository.save(route);
            }
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }

    }

    @Override
    public List<RouteCategoryViewModel> getAllByCategory(CategoryNames categoryName) {
        List<Route> routes = routeRepository.findAllByCategories_Name(categoryName);

        List<RouteCategoryViewModel> viewRoutes = routes
                .stream()
                .map(route -> modelMapper.map(route, RouteCategoryViewModel.class))
                .toList();

        return viewRoutes;
    }

    private String getPicturePath(MultipartFile pictureFile) {
        String[] splitPictureName = pictureFile.getOriginalFilename().split("\\.");
        String ext = splitPictureName[splitPictureName.length - 1];

        String pathPattern = "%s\\%s." + ext;

        return String.format(pathPattern,
                loggedUser.getUsername(),
                UUID.randomUUID());
    }

    private String getFilePath(String routeName) {
        String pathPattern = "%s\\%s_%s.xml";
        return String.format(pathPattern,
                loggedUser.getUsername(),
                transformRouteName(routeName),
                UUID.randomUUID());
    }

    private String transformRouteName(String routeName) {
        return routeName.toLowerCase()
                .replaceAll("\\s+", "_");
    }
}
