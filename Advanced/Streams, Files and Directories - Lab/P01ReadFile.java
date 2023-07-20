package LabStreamsFilesAndDirectories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class P01ReadFile {
    public static void main(String[] args) throws IOException {


        Path pathToFile = Path.of("C:\\Users\\aysel\\OneDrive\\Работен плот\\JAVA\\Advanced-  Java\\Streams,Files and Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");

        byte[] bytes = Files.readAllBytes(pathToFile);

        for (byte b : bytes) {
            System.out.print(Integer.toBinaryString ( b ) + " ");
        }
    }
}
