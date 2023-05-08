package carShop;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CarShopTests {

    @Test(expected = UnsupportedOperationException.class)
    public void testGetCars() {
        CarShop carShop1 = new CarShop();
        carShop1.getCars().remove(0);
    }

    @Test
    public void testGetCount() {
        CarShop carShop1 = new CarShop();
        Assert.assertEquals(0, carShop1.getCount());
        Car car1 = new Car("boko", 10, 100);
        carShop1.add(car1);
        Assert.assertEquals(1, carShop1.getCount());
    }

    @Test
    public void testGetCarMaxHorsePower() {
        CarShop carShop1 = new CarShop();
        Car car1 = new Car("boko", 10, 100);
        carShop1.add(car1);
        Car car2 = new Car("4oko", 20, 200);
        carShop1.add(car2);

        List<Car> carList = carShop1.findAllCarsWithMaxHorsePower(10);

        Assert.assertEquals(carList, carShop1.findAllCarsWithMaxHorsePower(10));
        Assert.assertEquals(1, carList.size());
    }



//    @Test
//    public void testGetCarMaxHorsePowerWhenNoCars() {
//        CarShop carShop1 = new CarShop();
//        Car car1 = new Car("boko", 10, 100);
//        carShop1.add(car1);
//        Car car2 = new Car("4oko", 20, 200);
//        carShop1.add(car2);
//
//        List<Car> carList = carShop1.findAllCarsWithMaxHorsePower(500);
//
//        Assert.assertEquals(carList, carShop1.findAllCarsWithMaxHorsePower(500));
//        Assert.assertEquals(0, carList.size());
//    }



    @Test(expected = NullPointerException.class)
    public void testAddCarWhenCarIsNull() {
        CarShop carShop1 = new CarShop();
        Car carNull = null;
        carShop1.add(carNull);
    }

    @Test
    public void testRemoveCar() {
        CarShop carShop1 = new CarShop();
        Car car1 = new Car("boko", 10, 100);
        carShop1.add(car1);
        Car car2 = new Car("4oko", 20, 200);
        carShop1.add(car2);

        Assert.assertEquals(2, carShop1.getCount());

        boolean carIsRemoved = carShop1.remove(car1);
        Assert.assertTrue(carIsRemoved);
        Assert.assertEquals(1, carShop1.getCount());
    }

    @Test
    public void testGetLuxCar() {
        CarShop carShop1 = new CarShop();
        Car car1 = new Car("boko", 10, 100);
        carShop1.add(car1);
        Car car2 = new Car("4oko", 20, 200);
        carShop1.add(car2);

        Assert.assertEquals(car2, carShop1.getTheMostLuxuryCar());
    }

    @Test
    public void testFindCarByModel() {
        CarShop carShop1 = new CarShop();
        Car car1 = new Car("boko", 10, 100);
        carShop1.add(car1);
        Car car2 = new Car("4oko", 20, 200);
        carShop1.add(car2);

        List<Car> carList = carShop1.findAllCarByModel("boko");

        Assert.assertEquals(carList, carShop1.findAllCarByModel("boko"));
        Assert.assertEquals(1, carList.size());
    }

}

