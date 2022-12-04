package Google_07;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Person> personMap = new HashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] data = input.split("\\s+");
            String nameIn = data[0];
            String typeClas = data[1];

            if(!personMap.containsKey(nameIn)){

                personMap.put(nameIn, new Person());
            }

            switch (typeClas){
                case "car":
                    String carModelIn = data[2];
                    int carSpeedIn = Integer.parseInt(data[3]);
                    Car car = new Car(carModelIn, carSpeedIn);
                    personMap.get(nameIn).setCar(car);
                    break;
                case "children":
                    String childrenNameIn = data[2];
                    String childrenBirthdayIn = data[3];
                    Children children = new Children(childrenNameIn, childrenBirthdayIn);
                    personMap.get(nameIn).getChildren().add(children);
                    break;
                case "parents":
                    String parentNameIn = data[2];
                    String parentBirthDayIn = data[3];
                    Parents parents = new Parents(parentNameIn, parentBirthDayIn);
                    personMap.get(nameIn).getParents().add(parents);
                    break;
                case "pokemon":
                    String pokemonNameIn = data[2];
                    String pokemonTypeIn = data[3];
                    Pokemon pokemon = new Pokemon(pokemonNameIn, pokemonTypeIn);
                    personMap.get(nameIn).getPokemons().add(pokemon);
                    break;
                case "company":
                    String companyNameIn = data[2];
                    String companyDepartmentIn = data[3];
                    double salaryIn = Double.parseDouble(data[4]);
                    Company company = new Company(companyNameIn, companyDepartmentIn, salaryIn);
                    personMap.get(nameIn).setCompany(company);
                    break;

            }

            input = scanner.nextLine();
        }
        String singleName = scanner.nextLine();
        System.out.println(singleName);
        System.out.println(personMap.get(singleName));

    }
}
