package restaurant.repositories;

import restaurant.entities.drinks.BaseBeverage;
import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.repositories.interfaces.BeverageRepository;

import java.util.*;

public class BeverageRepositoryImpl implements BeverageRepository<Beverages> {
    private Map<String, Beverages> beverages;

    public BeverageRepositoryImpl() {
        this.beverages = new LinkedHashMap<>();
    }

    @Override
    public Beverages beverageByName(String drinkName, String drinkBrand) {
        return beverages.get(drinkName);
    }

    @Override
    public Collection<Beverages> getAllEntities() {
        return beverages.values();
    }

    @Override
    public void add(Beverages beverage) {
        beverages.put(beverage.getName(), beverage);
    }
}
