package restaurant.core;

import restaurant.common.ExceptionMessages;
import restaurant.common.OutputMessages;
import restaurant.core.interfaces.Controller;
import restaurant.entities.drinks.Fresh;
import restaurant.entities.drinks.Smoothie;
import restaurant.entities.healthyFoods.Food;
import restaurant.entities.healthyFoods.Salad;
import restaurant.entities.healthyFoods.VeganBiscuits;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.tables.InGarden;
import restaurant.entities.tables.Indoors;
import restaurant.entities.tables.interfaces.Table;
import restaurant.repositories.interfaces.*;

public class ControllerImpl implements Controller {


    private final HealthFoodRepository<HealthyFood> healthFoodRepository;
    private final BeverageRepository<Beverages> beverageRepository;
    private final TableRepository<Table> tableRepository;
    private double totalMoney;

    public ControllerImpl(HealthFoodRepository<HealthyFood> healthFoodRepository, BeverageRepository<Beverages> beverageRepository, TableRepository<Table> tableRepository) {
        this.healthFoodRepository = healthFoodRepository;
        this.beverageRepository = beverageRepository;
        this.tableRepository = tableRepository;
    }

    @Override
    public String addHealthyFood(String type, double price, String name) {
        //TODO:
        HealthyFood healthyFood;
        if (healthFoodRepository.getAllEntities().contains(name)) {
            throw new IllegalArgumentException(
                    String.format(ExceptionMessages.FOOD_EXIST, name));
        }

        switch (type) {
            case "Salad":
                healthyFood = new Salad(name, price);
                healthFoodRepository.add(healthyFood);
                break;
            case "VeganBiscuits":
                healthyFood = new VeganBiscuits(name, price);
                healthFoodRepository.add(healthyFood);
                break;
        }

        return String.format(String.format(OutputMessages.FOOD_ADDED, name));
    }

    @Override
    public String addBeverage(String type, int counter, String brand, String name) {
        //TODO:
        Beverages beverages;
        if (beverageRepository.getAllEntities().contains(name)) {
            throw new IllegalArgumentException(
                    String.format(ExceptionMessages.BEVERAGE_EXIST, name));
        }

        switch (type) {
            case "Fresh":
                beverages = new Fresh(name, counter, brand);
                beverageRepository.add(beverages);
                break;
            case "Smoothie":
                beverages = new Smoothie(name, counter, brand);
                beverageRepository.add(beverages);
                break;
        }
        return String.format(OutputMessages.BEVERAGE_ADDED, type, brand);
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        //TODO:
        Table table = null;
        switch (type) {
            case "InGarden":
                table = new InGarden(tableNumber, capacity);
                break;
            case "Indoors":
                table = new Indoors(tableNumber, capacity);
                break;
        }
        boolean tableExist = false;
        //if (tableRepository.getAllEntities().contains(tableNumber)) {

        for (Table t : tableRepository.getAllEntities()) {
            if (t.getTableNumber() == tableNumber) {
                tableExist = true;
            }
        }

        if (tableExist) {
            throw new IllegalArgumentException(String.format(
                    ExceptionMessages.TABLE_IS_ALREADY_ADDED, tableNumber));
        } else {
            tableRepository.add(table);
        }
        //}

        return String.format(ExceptionMessages.TABLE_EXIST, tableNumber);
    }

    @Override
    public String reserve(int numberOfPeople) {
        //TODO:
        boolean haveSuitableTable = false;
        int tableNr = 0;
        for (Table t : tableRepository.getAllEntities()) {
            if (!t.isReservedTable() && t.getSize() >= numberOfPeople) {
                t.reserve(numberOfPeople);
                haveSuitableTable = true;
                tableNr = t.getTableNumber();
                break;
            }
        }
        String massage;
        if (haveSuitableTable) {
            massage = String.format(OutputMessages.TABLE_RESERVED,
                    tableNr, numberOfPeople);
        } else {
            massage = String.format(OutputMessages.RESERVATION_NOT_POSSIBLE, numberOfPeople);
        }
        return massage;
    }

    @Override
    public String orderHealthyFood(int tableNumber, String healthyFoodName) {
        //TODO:
        boolean tableExist = false;
        String massage = null;
        Table searchedTable = null;
        for (Table t : tableRepository.getAllEntities()) {
            if (t.getTableNumber() == tableNumber) {
                tableExist = true;
                searchedTable = t;
            }
        }

        boolean foodExist = false;
        HealthyFood healthyFoodToOrder = null;
        for (HealthyFood f : healthFoodRepository.getAllEntities()) {
            if (f.getName() == healthyFoodName) {
                foodExist = true;
                healthyFoodToOrder = f;
            }
        }

        if (!tableExist) {
            massage = String.format(OutputMessages.WRONG_TABLE_NUMBER, tableNumber);
        } else if (!foodExist) {
            massage = String.format(OutputMessages.NONE_EXISTENT_FOOD, healthyFoodName);
        } else {
            searchedTable.orderHealthy(healthyFoodToOrder);
            massage = String.format(OutputMessages.FOOD_ORDER_SUCCESSFUL,
                    healthyFoodName, tableNumber);
        }
        return massage;
    }

    @Override
    public String orderBeverage(int tableNumber, String name, String brand) {
        //TODO:
        boolean tableExist = false;
        String massage = null;
        Table searchedTable = null;
        for (Table t : tableRepository.getAllEntities()) {
            if (tableNumber == t.getTableNumber()) {
                tableExist = true;
                searchedTable = t;
            }
        }

        boolean beverageExist = false;
        Beverages beveragesToOrder = null;
        for (Beverages b : beverageRepository.getAllEntities()) {
            if (b.getName() == name) {
                beverageExist = true;
                beveragesToOrder = b;
            }
        }

        if (!tableExist) {
            massage = String.format(OutputMessages.WRONG_TABLE_NUMBER, tableNumber);
        } else if (!beverageExist) {
            massage = String.format(OutputMessages.NON_EXISTENT_DRINK, name, brand);
        } else {
            searchedTable.orderBeverages(beveragesToOrder);
            massage = String.format(OutputMessages.BEVERAGE_ORDER_SUCCESSFUL, name, tableNumber);
        }

        return massage;
    }

    @Override
    public String closedBill(int tableNumber) {
        //TODO:
       // String massage = null;
        double tableBill = 0;
        for (Table t : tableRepository.getAllEntities()) {
            if (t.getTableNumber() == tableNumber) {
                tableBill = t.bill();
                totalMoney += tableBill;
                //massage = String.format(OutputMessages.BILL, tableNumber, t.bill());
                t.clear();
            }
        }

        return String.format(String.format(OutputMessages.BILL, tableNumber, tableBill));
    }


    @Override
    public String totalMoney() {
        //TODO:
        return String.format(OutputMessages.TOTAL_MONEY, totalMoney);
    }
}
