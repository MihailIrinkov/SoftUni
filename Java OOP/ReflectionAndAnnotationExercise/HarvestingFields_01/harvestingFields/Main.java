package HarvestingFields_01.harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.function.Consumer;

public class Main {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		String command = scanner.nextLine();

		Consumer<Field> printer = field -> {
			System.out.println(

					Modifier.toString(field.getModifiers())
							+ " "
							+ field.getType().getSimpleName()
							+ " "
							+ field.getName()
			);
		};

		Map<String, List<Field>> fieldsMap = getFieldsMap();

		while (!command.equals("HARVEST")) {

			switch (command) {
				case "private":
					fieldsMap.get("private").forEach(field -> printer.accept(field));
					break;
				case "protected":
					fieldsMap.get("protected").forEach(field -> printer.accept(field));
					break;
				case "public":
					fieldsMap.get("public").forEach(field -> printer.accept(field));
					break;
				case "all":
					fieldsMap.get("all").forEach(field -> printer.accept(field));
					break;
			}
			command = scanner.nextLine();
		}



	}

	private static Map<String, List<Field>> getFieldsMap() {
		Map<String, List<Field>> map = new HashMap<>();
		map.put("private", new ArrayList<>());
		map.put("protected", new ArrayList<>());
		map.put("public", new ArrayList<>());

		List<Field> allFields = Arrays.asList(RichSoilLand.class.getDeclaredFields());
		map.put("all", allFields);

		allFields.forEach(f -> {

					String modifier = Modifier.toString(f.getModifiers());

					switch (modifier) {
						case "private":
							map.get("private").add(f);
							break;
						case "protected":
							map.get("protected").add(f);
							break;
						case "public":
							map.get("public").add(f);
							break;

					}
				}
		);

		return map;

	}
}

