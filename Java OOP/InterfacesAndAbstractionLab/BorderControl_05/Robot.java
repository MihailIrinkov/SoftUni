package BorderControl_05;

public class Robot implements Identifiable{
    private String model;
    private String id;


    public Robot(String model, String id) {
        this.model = model;
        this.id = id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String getId() {
        return id;
    }
}
