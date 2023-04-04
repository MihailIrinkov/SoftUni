package garage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GarageTests {
    //TODO: Test Garage class
    private Garage garage;

    @Before
    public void setUp() {
        garage = new Garage();
    }

    @Test
    public void testAddNewCar() {
        Assert.assertEquals(0, garage.getCount());

        Car car = new Car("BMW", 250, 8000);
        this.garage.addCar(car);

        Assert.assertEquals(1, garage.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCarWhenCarIsNull() {
        this.garage.addCar(null);
    }

    @Test
    public void testFindAllCarsByBrand() {
        Car carBMW5 = new Car("BMW", 250, 8000);
        Car carBMW6 = new Car("BMW", 260, 9000);
        Car carBMW7 = new Car("BMW", 270, 10000);
        Car ford = new Car("FordCmax", 165, 7000);
        this.garage.addCar(carBMW5);
        this.garage.addCar(carBMW6);
        this.garage.addCar(carBMW7);
        this.garage.addCar(ford);

        List<Car> returnedCars = this.garage.findAllCarsByBrand("BMW");
        Assert.assertEquals(3, returnedCars.size());
        Assert.assertEquals(carBMW5, returnedCars.get(0));
        Assert.assertEquals(carBMW6, returnedCars.get(1));
        Assert.assertEquals(carBMW7, returnedCars.get(2));
    }

    @Test
    public void testFindAllCarsWithMaxSpeedAbove() {
        Car carBMW5 = new Car("BMW", 250, 8000);
        Car carBMW6 = new Car("BMW", 260, 9000);
        Car carBMW7 = new Car("BMW", 270, 10000);
        Car ford = new Car("FordCmax", 165, 7000);
        this.garage.addCar(carBMW5);
        this.garage.addCar(carBMW6);
        this.garage.addCar(carBMW7);
        this.garage.addCar(ford);

        List<Car> result = this.garage.findAllCarsWithMaxSpeedAbove(200);

        Assert.assertEquals(3, result.size());
    }

    @Test
    public void testGetTheMostExpensiveCar() {
        Car carBMW5 = new Car("BMW", 250, 8000);
        Car carBMW6 = new Car("BMW", 260, 9000);
        Car carBMW7 = new Car("BMW", 270, 10000);
        Car ford = new Car("FordCmax", 165, 7000);
        this.garage.addCar(carBMW5);
        this.garage.addCar(carBMW6);
        this.garage.addCar(carBMW7);
        this.garage.addCar(ford);

        Car car = this.garage.getTheMostExpensiveCar();

        Assert.assertEquals(car.getBrand(), "BMW");
        Assert.assertEquals(car.getPrice(), 10000, 0.01);
    }

    @Test
    public void testGetCars() {
        List<Car> expectedCars = new ArrayList<>();
        Car carBMW5 = new Car("BMW", 250, 8000);
        Car carBMW6 = new Car("BMW", 260, 9000);
        Car carBMW7 = new Car("BMW", 270, 10000);
        Car ford = new Car("FordCmax", 165, 7000);
        this.garage.addCar(carBMW5);
        expectedCars.add(carBMW5);
        this.garage.addCar(carBMW6);
        expectedCars.add(carBMW6);
        this.garage.addCar(carBMW7);
        expectedCars.add(carBMW7);
        this.garage.addCar(ford);
        expectedCars.add(ford);

        List<Car> cars = this.garage.getCars();

        Assert.assertEquals(expectedCars, cars);
    }
}