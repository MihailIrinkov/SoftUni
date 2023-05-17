package Facade_02;

public class Main {
    public static void main(String[] args) {
        Car car = new CarBuilderFacade().info()
                .withType("BMW")
                .withColor("Black")
                .withNumberOfDoors(5)
                .built()
                .inCity("Leipzig")
                .atAddress("Some Address 123")
                .build();

        System.out.println(car);
    }
}
