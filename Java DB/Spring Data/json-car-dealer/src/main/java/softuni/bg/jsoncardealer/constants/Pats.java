package softuni.bg.jsoncardealer.constants;

import java.nio.file.Path;

public enum Pats {
    ;

    public static final Path CARS_JSON_PATH =
    Path.of("src", "main",
            "resources", "dbContent","cars.json");

    public static final Path CUSTOMERS_JSON_PATH =
            Path.of("src", "main",
                    "resources", "dbContent","customers.json");

    public static final Path PARTS_JSON_PATH =
            Path.of("src", "main",
                    "resources", "dbContent", "parts.json");

    public static final Path SUPPLIERS_JSON_PATH =
            Path.of("src", "main", "resources", "dbContent", "suppliers.json");

    public static final Path FIRST_OUTPUT_JSON =
            Path.of("src", "main", "resources", "output", "1.json");


    public static final Path SECOND_OUTPUT_JSON =
            Path.of("src", "main", "resources", "output", "Query2CarsFromMakeToyota.json");

    public static final Path THIRD_OUTPUT_JSON =
            Path.of("src", "main", "resources", "output", "Query3LocalSuppliers.json");

    public static final Path FOURTH_OUTPUT_JSON =
            Path.of("src", "main", "resources", "output", "Query4CarsWithTheirListOfParts.json.json");

}
