package glacialExpedition.models.explorers;

public class NaturalExplorer extends BaseExplorer{
    private final static double INITIAL_UNITS_OF_ENERGY = 60;

    public NaturalExplorer(String name) {
        super(name, INITIAL_UNITS_OF_ENERGY);
    }

    @Override
    public void search() {
        if (getEnergy() - 7 >= 0) {
            setEnergy(getEnergy() - 7);
        } else {
            setEnergy(0);
        }
    }
}
