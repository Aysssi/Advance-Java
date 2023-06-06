package StreamsFilesAndDirectories;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class P01SumLines {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String pathToFile = "C:\\Users\\aysel\\OneDrive\\Работен плот\\JAVA\\Advanced-  Java\\Streams,Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        List<String> allLists = Files.readAllLines(Paths.get(pathToFile));

        for (String line : allLists) {
            int sum = 0;
            for (char currentSymbol : line.toCharArray()){
                sum += currentSymbol;
            }
            System.out.println(sum);
        }

    }
}
