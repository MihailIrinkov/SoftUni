package BirthdayCelebrations_03;

public class Robot implements Identifiable{
    private String id;
    private String model;

    public Robot(String id, String model) {
        this.id = id;
        this.model = model;
    }

    public String getId() {
        return this.id;
    }

    public String getModel() {
        return model;
    }
}
