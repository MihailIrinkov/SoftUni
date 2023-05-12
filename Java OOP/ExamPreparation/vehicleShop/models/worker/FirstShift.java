package vehicleShop.models.worker;

public class FirstShift extends BaseWorker{
    private static final int INITIAL_STRENGTH = 100;

    public FirstShift(String name) {
        super(name, INITIAL_STRENGTH);
    }
}
