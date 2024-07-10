package com.softuni.battleships.service.impl;

import com.softuni.battleships.model.dto.ship.CreateShipBindingModel;
import com.softuni.battleships.model.dto.ship.ShipDTO;
import com.softuni.battleships.model.dto.ship.ShipViewDTO;
import com.softuni.battleships.model.entity.Category;
import com.softuni.battleships.model.entity.Ship;
import com.softuni.battleships.repository.CategoryRepository;
import com.softuni.battleships.repository.ShipRepository;
import com.softuni.battleships.repository.UserRepository;
import com.softuni.battleships.service.LoggedUser;
import com.softuni.battleships.service.ShipService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShipServiceImpl implements ShipService {

    private final ShipRepository shipRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    private final LoggedUser loggedUser;

    public ShipServiceImpl(ShipRepository shipRepository,
                           UserRepository userRepository,
                           CategoryRepository categoryRepository,
                           LoggedUser loggedUser) {
        this.shipRepository = shipRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.loggedUser = loggedUser;
    }

    @Override
    public boolean createShip(CreateShipBindingModel createShipBindingModel) {

        Optional<Ship> optionalShip = this.shipRepository.findByName(createShipBindingModel.getName());

        if (optionalShip.isPresent()) {
            return false;
        }

        Category category = this.categoryRepository.findById(createShipBindingModel.getCategory().getId()).get();

        Ship shipToSave = new Ship()
                .setUser(this.userRepository.findById(loggedUser.getId()).get())
                .setCreated(LocalDate.now())
                .setName(createShipBindingModel.getName())
                .setHealth(createShipBindingModel.getHealth())
                .setPower(createShipBindingModel.getPower())
                .setCategory(category);

        this.shipRepository.save(shipToSave);

        return true;
    }

    @Override
    public List<ShipDTO> getOwnShips(Long id) {
        return this.shipRepository.findAllByUserId(id).stream().map(ship -> new ShipDTO()
                        .setName(ship.getName())
                        .setHealth(ship.getHealth())
                        .setPower(ship.getPower())
                        .setId(ship.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public List<ShipDTO> getNotOwnShips(Long id) {
        return this.shipRepository.findAllByUserIdNot(id).stream().map(ship -> new ShipDTO()
                        .setName(ship.getName())
                        .setHealth(ship.getHealth())
                        .setPower(ship.getPower())
                        .setId(ship.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public List<ShipDTO> getSortedAllShips() {
        return this.shipRepository.findByOrderByNameAscHealthAscPowerAsc().stream().map(ship -> new ShipDTO()
                        .setName(ship.getName())
                        .setHealth(ship.getHealth())
                        .setPower(ship.getPower())
                        .setId(ship.getId()))
                .collect(Collectors.toList());
    }

}
