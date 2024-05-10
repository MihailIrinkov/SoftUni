package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.model.dto.binding.AddRouteBindingModel;
import bg.softuni.pathfinder.model.dto.view.RouteDetailsViewModel;
import bg.softuni.pathfinder.model.dto.view.RouteGetAllViewModel;

import java.util.List;

public interface RouteService {

    void add(AddRouteBindingModel routeBindingModelModel);

    List<RouteGetAllViewModel> getAll();

    RouteDetailsViewModel getDetails(Long id);
}
