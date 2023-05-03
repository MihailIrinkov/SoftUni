package restaurant.entities.tables;

public class Indoors extends BaseTable{
    private static final double PRICE_PER_PERSON = 3.50;

    public Indoors(int number, int size) {
        super(number, size, PRICE_PER_PERSON);
    }

    @Override
    public String tableInformation() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Table - %d", getTableNumber()));
        sb.append(System.lineSeparator());
        sb.append(String.format("Size - %d", getSize()));
        sb.append(System.lineSeparator());
        sb.append(String.format("Type - %s", getClass().getSimpleName()));
        return sb.toString();
    }
}
