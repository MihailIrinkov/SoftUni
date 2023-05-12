package vehicleShop.models.worker;

public class SecondShift extends BaseWorker{
    private static final int INITIAL_STRENGTH = 70;

    public SecondShift(String name) {
        super(name, INITIAL_STRENGTH);
    }

    @Override
    public void working() {
        if ((getStrength() - 15) < 0) {
            setStrength(0);
        } else {
            setStrength(getStrength() - 10);
        }
    }
}
