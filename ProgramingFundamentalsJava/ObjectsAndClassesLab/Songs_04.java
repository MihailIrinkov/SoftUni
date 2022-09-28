import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Songs_04 {

    static class Songs {
        String typeList;
        String name;
        String time;

        public void setTypeList(String typeList) {
            this.typeList = typeList;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getTypeList() {
            return this.typeList;
        }

        public String getName() {
            return this.name;
        }

        public String getTime() {
            return this.time;
        }

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Songs> listSongs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] inputSongsArr = scanner.nextLine().split("_");
            String inputType = inputSongsArr[0];
            String inputName = inputSongsArr[1];
            String inputTime = inputSongsArr[2];

            Songs currentSong = new Songs();
            currentSong.setTypeList(inputType);
            currentSong.setName(inputName);
            currentSong.setTime(inputTime);

            listSongs.add(currentSong);

        }

        String command = scanner.nextLine();

        if (command.equals("all")) {
            for (Songs item : listSongs) {
                System.out.println(item.getName());
            }
        } else {
            for (Songs item : listSongs) {
                if (item.getTypeList().equals(command)) {
                    System.out.println(item.getName());
                }
            }
        }

    }
}
