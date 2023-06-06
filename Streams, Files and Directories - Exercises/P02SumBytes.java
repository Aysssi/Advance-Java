package StreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class P02SumBytes {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String pathToFile = "C:\\Users\\aysel\\OneDrive\\Работен плот\\JAVA\\Advanced-  Java\\Streams,Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        long sum = 0;

//        BufferedReader br = new BufferedReader(new FileReader(pathToFile));
//
//        String line = br.readLine();
//        while (line != null ){
//            for (int index = 0; index < line.length(); index++) {
//                char currentSymbol = line.charAt(index);
//                sum += currentSymbol;
//            }
//
//            line = br.readLine();
//        }

           List<String> allLines = Files.readAllLines(Path.of(pathToFile));

        for (String line : allLines) {
            for (char symbol : line.toCharArray()) {
                sum += symbol;
            }
        }


        System.out.println(sum);
    }
}
