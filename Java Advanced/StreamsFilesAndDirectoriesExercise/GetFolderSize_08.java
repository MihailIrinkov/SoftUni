import java.io.File;
import java.util.ArrayDeque;

public class GetFolderSize_08 {
    public static void main(String[] args) {

        File order = new File(".idea/resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/Exercises Resources");

        ArrayDeque<File> directories = new ArrayDeque<>();
        directories.offer(order);

        int size = 0;

        while (!directories.isEmpty()) {

            File current = directories.poll();
            File[] files = current.listFiles();

            for (File f : files) {
                if (f.isDirectory()) {
                    directories.offer(f);
                } else {
                    size += f.length();
                }
            }


        }

        System.out.println("Folder size: " + size);
    }

}
