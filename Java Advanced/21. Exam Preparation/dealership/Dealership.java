package dealership;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Dealership {
    private List<Car> data;
    public String name;
    public int capacity;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public List<Car> getData() {
        return data;
    }

    public void setData(List<Car> data) {
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


    public void add(Car car) {
        if (this.data.size() < this.capacity) {
            this.data.add(car);
        }
    }


    public boolean buy(String manufacturer, String model) {

        for (Car c : this.data) {
            if (c.getManufacturer().equals(manufacturer) && c.getModel().equals(model)) {
                 this.data.remove(c);
                 return true;
            }
        }
        return false;
    }


    public Car getLatestCar() {
//        if (data.isEmpty()) {
//            return null;
//        }
        Car latest = null;
        int max = Integer.MIN_VALUE;
        for (Car c : data) {

            if (c.getYear() > max) {
                max = c.getYear();
                latest = c;
            }
           //int latestY = c.getYear();

        }
        //return data.stream().max((c, c1) -> c.getYear()).orElse(null);
         return latest;
    }

    public Car getCar(String manufacturer, String model) {
        for (Car c :this. data) {

            if (c.getManufacturer().equals(manufacturer) && c.getModel().equals(model)) {
                return c;
            }
        }
        return null;
    }

    public int getCount() {
       return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("The cars are in a car dealership %s:%n", this.name));
//        sb.append("\n");
        for (Car c : data) {
//            sb.append(c.toString());
//            sb.append("\n");
            sb.append(c.toString()).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
