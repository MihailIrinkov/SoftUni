package goldDigger.models.disocverer;

public class Geologist extends BaseDiscoverer{
    private static final double INITIAL_UNITS_OF_ENERGY = 100;

    public Geologist(String name) {
        super(name, INITIAL_UNITS_OF_ENERGY);
    }

//    @Override
//    public void dig() {
//        if ((getEnergy() - 15) < 0) {
//            setEnergy(0);
//        } else {
//            setEnergy(getEnergy() - 15);
//        }
//    }
}
