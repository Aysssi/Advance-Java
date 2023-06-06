package StreamsFilesAndDirectories;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P05LineNumbers {
    public static void main(String[] args) throws IOException {

        String  path = "C:\\Users\\aysel\\OneDrive\\Работен плот\\JAVA\\Advanced-  Java\\Streams,Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";

        List<String> allLines = Files.readAllLines(Path.of(path));
        PrintWriter writer = new PrintWriter("5outLineNumbers.txt");

        int number = 1;
        for (String line : allLines) {
           writer.println(number +". " + line);
           number++;
        }

        writer.close();
    }
}
