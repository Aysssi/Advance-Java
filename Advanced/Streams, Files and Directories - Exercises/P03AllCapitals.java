package StreamsFilesAndDirectories;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P03AllCapitals {
    public static void main(String[] args) throws IOException {

        String pathOfFile = "C:\\Users\\aysel\\OneDrive\\Работен плот\\JAVA\\Advanced-  Java\\Streams,Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter("3output.txt"));

       List<String> allLines = Files.readAllLines(Path.of(pathOfFile));
        for (String line : allLines) {
           writer.write(line.toUpperCase());
           writer.newLine();

       }
       writer.close();

//        BufferedReader reader = new BufferedReader(new FileReader(pathOfFile));
//        String line = reader.readLine();
//
//        while (line != null){
//            writer.write(line.toUpperCase());
//            writer.newLine();
//
//            line     = reader.readLine();
//        }
//          writer.close();
    }
}
