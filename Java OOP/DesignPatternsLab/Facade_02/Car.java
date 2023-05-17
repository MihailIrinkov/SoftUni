package Facade_02;

public class Car {
    private String type;
    private String color;
    private int numberOfDoors;
    private String city;
    private String address;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format("CarType: %s, " +
                "Color: %s, Number of Doors:, %d, " +
                "Manufactured in %s, at address: %s",
                this.type, this.color, this.numberOfDoors, this.getCity(), this.getAddress());
    }
}
