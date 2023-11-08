package bg.softuni.SpringRepositories.services;

import bg.softuni.SpringRepositories.entities.Shampoo;
import bg.softuni.SpringRepositories.entities.Size;
import bg.softuni.SpringRepositories.repositories.ShampooRepository;
import jakarta.persistence.Id;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ShampooServiceImpl implements ShampooService{

    private final ShampooRepository shampooRepository;

    public ShampooServiceImpl(ShampooRepository shampooRepository) {
        this.shampooRepository = shampooRepository;
    }


    @Override
    public List<Shampoo> findShampoosBySizeOrderById(Size size) {
        return this.shampooRepository.findAllBySizeOrderById(size);
    }

    @Override
    public List<Shampoo> findAllBySizeOrLabelId(Size size, Long labelId) {
        return this.shampooRepository.findAllBySizeOrLabelIdOrderByPrice(size, labelId);
    }

    @Override
    public List<Shampoo> findAllByPriceGreaterThanDesc(BigDecimal price) {
        return this.shampooRepository.findAllByPriceGreaterThanOrderByPriceDesc(price);
    }

    @Override
    public Integer countByPriceLessThan(BigDecimal price) {
        return this.shampooRepository.countByPriceLessThan(price);
    }

    @Override
    public List<Shampoo> findAllWithIngredients(List<String> names) {
        return this.shampooRepository.findAllWithIngredients(names);
    }

    @Override
    public List<Shampoo> getAllWithIngredientsCountLessThen(int count) {
        return this.shampooRepository.findByIngredientCountLessThan(count);
    }
}
