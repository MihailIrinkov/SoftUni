package CarSalesman_05;

public class Car {
    private String model;
    private Engine engine;
    private int weight;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    private String color;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
    }

    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.model + ":" + "\n");
        stringBuilder.append(this.engine.getModel() + ":" + "\n");
        stringBuilder.append("Power: " + this.engine.getPower() + "\n");
        if (this.engine.getDisplacement() == 0) {
            stringBuilder.append("Displacement: " + "n/a" + "\n");
        } else {
            stringBuilder.append("Displacement: " + this.engine.getDisplacement() + "\n");
        }
        stringBuilder.append("Efficiency: " + this.engine.getEfficiency() + "\n");
        if (this.weight == 0) {
            stringBuilder.append("Weight: " + "n/a" + "\n");
        } else{
            stringBuilder.append("Weight: " + this.getWeight() + "\n");
        }
        stringBuilder.append("Color: " + this.getColor());

        return stringBuilder.toString();
    }

}
