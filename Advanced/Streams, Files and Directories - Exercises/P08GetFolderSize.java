package StreamsFilesAndDirectories;

import java.io.File;

public class P08GetFolderSize {

    public static void main(String[] args) {

        String pathToFolder = "C:\\Users\\aysel\\OneDrive\\Работен плот\\JAVA\\Advanced-  Java\\Streams,Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";
        File folder = new File(pathToFolder);

        File[] files = folder.listFiles();

        int folderSize = 0;
        if (files != null){
            for (File f : files) {
                folderSize += f.length();
            }
        }
        System.out.println("Folder size: " + folderSize);
    }



}
