package BorderControl_05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Identifiable> identifiables = new ArrayList<>();

//        List<Citizen> citizenList = new ArrayList<>();
//        List<Robot> robotList = new ArrayList<>();

        while (!input.equals("End")) {

            String[] data = input.split("\\s+");

            Identifiable identifiable;

            if (data.length == 3) {

                String name = data[0];
                int age = Integer.parseInt(data[1]);
                String id = data[2];

                identifiable = new Citizen(name, age, id);

            } else {

                String model = data[0];
                String id = data[1];

                identifiable = new Robot(model, id);
            }

            identifiables.add(identifiable);

            input = scanner.nextLine();
        }

        String fakeId = scanner.nextLine();


        identifiables.stream().map(Identifiable -> Identifiable.getId())
                .filter(idf -> idf.endsWith(fakeId))
                .forEach(System.out::println);

//        List<String> fakeIdList = new ArrayList<>();

//        for (Identifiable idf : identifiable) {
//
//           String[] id = idf.getId().split("");
//           StringBuilder sb = new StringBuilder();
//
//            for (int i = id.length - 3 ; i <= id.length - 1; i++) {
//                sb.append(id[i]);
//            }
//
//            if(sb.toString().equals(fakeId)) {
//                fakeIdList.add(idf.getId());
//            }
//
//        }


//        for (Robot r : robotList) {
//
//            String[] id = r.getId().split("");
//            StringBuilder sb = new StringBuilder();
//
//            for (int i = id.length - 3 ; i <= id.length - 1; i++) {
//                sb.append(id[i]);
//            }
//
//            if(sb.toString().equals(fakeId)) {
//                fakeIdList.add(r.getId());
//            }
//
//        }
//
//
//        for (String s : fakeIdList) {
//            System.out.println(s);
//        }
    }
}
