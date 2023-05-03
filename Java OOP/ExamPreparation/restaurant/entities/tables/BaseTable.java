package restaurant.entities.tables;

import restaurant.common.ExceptionMessages;
import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.tables.interfaces.Table;

import java.util.*;

public abstract class BaseTable implements Table {
    private List<HealthyFood> healthyFood;
    private List<Beverages> beverages;
    private int number;
    private int size;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReservedTable;
    private double allPeople;

    public BaseTable(int number, int size, double pricePerPerson) {
        this.number = number;
        this.setSize(size);
        this.pricePerPerson = pricePerPerson;
        this.healthyFood = new ArrayList<>();
        this.beverages = new ArrayList<>();
    }

//    public void setHealthyFood(Collection<HealthyFood> healthyFood) {
//        this.healthyFood = new LinkedHashMap<>();
//    }
//
//    public void setBeverages(Collection<Beverages> beverages) {
//        this.beverages = new LinkedHashMap<>();
//    }
//
//    public void setNumber(int number) {
//        this.number = number;
//    }

    protected void setSize(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_TABLE_SIZE);
        }
        this.size = size;
    }

//    public void setNumberOfPeople(int numberOfPeople) {
//        if (numberOfPeople <= 0) {
//            throw new IllegalArgumentException(ExceptionMessages.INVALID_NUMBER_OF_PEOPLE);
//        }
//        this.numberOfPeople = numberOfPeople;
//    }
//
    protected void setPricePerPerson(double pricePerPerson) {
        this.pricePerPerson = pricePerPerson;
    }
//
//    public void setReservedTable(boolean reservedTable) {
//        isReservedTable = reservedTable;
//    }
//
//    public void setAllPeople(double allPeople) {
//        this.allPeople = allPeople;
//    }

    @Override
    public int getTableNumber() {
        return number;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int numberOfPeople() {
        return numberOfPeople;
    }

    @Override
    public double pricePerPerson() {
        return pricePerPerson;
    }

    @Override
    public boolean isReservedTable() {
        return isReservedTable;
    }

    @Override
    public double allPeople() {
        return pricePerPerson * numberOfPeople;
    }

    @Override
    public void reserve(int numberOfPeople) {
//        if (size <= numberOfPeople) {
//            isReservedTable = true;
//        }
        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
        this.isReservedTable = true;
    }

    @Override
    public void orderHealthy(HealthyFood food) {
        healthyFood.add(food);
    }

    @Override
    public void orderBeverages(Beverages beverage) {
        beverages.add(beverage);
    }

    @Override
    public double bill() {
//        double sum = 0;
//        for (Beverages b : beverages) {
//            sum += b.getPrice();
//        }
//        for (HealthyFood f: healthyFood) {
//            sum += f.getPrice();
//        }
//        return sum;
        double billBeverages = beverages.stream().mapToDouble(Beverages::getPrice).sum();
        double billFoods = healthyFood.stream().mapToDouble(HealthyFood::getPrice).sum();

        return billBeverages + billFoods + (numberOfPeople * pricePerPerson);
    }

    @Override
    public void clear() {
        healthyFood.clear();
        beverages.clear();
        isReservedTable = false;
        numberOfPeople = 0;
    }

    @Override
    public String tableInformation() {
        return null;
    }
}
