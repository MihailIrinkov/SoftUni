package goldDigger.models.disocverer;

public class Anthropologist extends BaseDiscoverer{
    private static final double INITIAL_UNITS_OF_ENERGY = 40;

    public Anthropologist(String name) {
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
