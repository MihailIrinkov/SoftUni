package bg.softuni.pathfinder.service.impl;

import bg.softuni.pathfinder.exceptions.RouteNotFoundException;
import bg.softuni.pathfinder.model.dto.binding.AddRouteBindingModel;
import bg.softuni.pathfinder.model.dto.view.RouteDetailsViewModel;
import bg.softuni.pathfinder.model.dto.view.RouteGetAllViewModel;
import bg.softuni.pathfinder.model.entity.Category;
import bg.softuni.pathfinder.model.entity.Route;
import bg.softuni.pathfinder.model.entity.User;
import bg.softuni.pathfinder.repository.CategoryRepository;
import bg.softuni.pathfinder.repository.RouteRepository;
import bg.softuni.pathfinder.service.RouteService;
import bg.softuni.pathfinder.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;
    private final CategoryRepository categoryRepository;

    private final UserService userService;
    private final ModelMapper modelMapper;

    private final ModelMapper mapper;

    public RouteServiceImpl(RouteRepository repository, CategoryRepository categoryRepository, UserService userService, ModelMapper modelMapper, ModelMapper mapper) {
        this.routeRepository = repository;
        this.categoryRepository = categoryRepository;
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.mapper = mapper;
    }

    @Override
    public void add(AddRouteBindingModel addRouteBindingModel) {
        Route route = mapper.map(addRouteBindingModel, Route.class);
        route.getCategories().clear();

        String regex = "v=(.*)";
        Pattern compile = Pattern.compile(regex);

        Matcher matcher = compile.matcher(addRouteBindingModel.getVideoUrl());
        if (matcher.find()) {
            String url = matcher.group(1);
            route.setVideoUrl(url);
        }

        Set<Category> categories = categoryRepository
                .findByNameIn(addRouteBindingModel.getCategories());
        route.addCategories(categories);

        User user = userService.getLoggedUser();
        route.setAuthor(user);

        this.routeRepository.save(route);
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
}
