package glacialExpedition.models.explorers;

public class AnimalExplorer extends BaseExplorer{
    private final static double INITIAL_UNITS_OF_ENERGY = 100;

    public AnimalExplorer(String name) {
        super(name, INITIAL_UNITS_OF_ENERGY);
    }
}
