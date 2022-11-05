import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class NestedFolders_08 {
    public static void main(String[] args) {

        String path = ".idea/resources/Files-and-Streams";

        File file = new File(path);

        int countFiles = 0;

        if (file.isDirectory()) {

            System.out.println(file.getName());

            countFiles++;
        }

        Deque<File> dirs = new ArrayDeque<>();
        dirs.offer(file);

        while (!dirs.isEmpty()) {
            File currentFile = dirs.poll();
            File[] nestedFiles = currentFile.listFiles();
            for (File f : nestedFiles) {
                if(f.isDirectory()){
                    dirs.offer(f);
                    countFiles++;
                    System.out.println(f.getName());
                }
            }
        }

//        if (file.isDirectory()) {
//            File[] files = file.listFiles();
//
//            for (int i = 0; i < files.length; i++) {
//                if (files[i].isDirectory()) {
//                    File[] files1 = files[i].listFiles();
//                    for (File f : files1) {
//                        System.out.println(f.getName());
//                    }
//                    countFiles++;
//
//                } else {
//                    System.out.println(files[i].getName());
//
//                    countFiles++;
//                }
//            }
//
//        }



        System.out.printf("%d folders", countFiles);

    }
}
