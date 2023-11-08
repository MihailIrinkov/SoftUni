package bg.softuni.SpringRepositories.services;

import bg.softuni.SpringRepositories.entities.Ingredient;
import bg.softuni.SpringRepositories.repositories.IngredientsRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Service
public class IngredientsServiceImpl implements IngredientsService{

    private final IngredientsRepository ingredientsRepository;

    public IngredientsServiceImpl(IngredientsRepository ingredientsRepository) {
        this.ingredientsRepository = ingredientsRepository;
    }

    @Override
    public List<Ingredient> findAllByNameStartingWith(String letter) {
        return this.ingredientsRepository.findAllByNameStartingWith(letter);
    }

    @Override
    public List<Ingredient> findAllNameIn(List<String> names) {
        return this.ingredientsRepository.findAllByNameIn(names);
    }

    @Override
    @Transactional
    public void deleteByName(String name) {
        this.ingredientsRepository.deleteByName(name);
    }

    @Override
    @Transactional
    public void deleteByName2(String name) {
        this.ingredientsRepository.deleteByName2(name);
    }

    @Override
    @Transactional
    public void updatePriceAllByTenPercent(BigDecimal percent) {
        this.ingredientsRepository.updateAllPrice(percent);
    }

    @Override
    @Transactional
    public void updateIngredientsByName(BigDecimal percent, Set<String> name) {
        this.ingredientsRepository.updateIngredientsByName(percent, name);
    }


}
