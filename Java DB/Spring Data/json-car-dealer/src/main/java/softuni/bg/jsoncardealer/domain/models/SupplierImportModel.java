package softuni.bg.jsoncardealer.domain.models;

public class SupplierImportModel {

    private String name;

    private boolean isImporter;

    public SupplierImportModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isImporter() {
        return isImporter;
    }

    public void setImporter(boolean importer) {
        isImporter = importer;
    }
}
