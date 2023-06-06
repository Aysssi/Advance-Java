package LabStreamsFilesAndDirectories;

import java.io.*;
import java.util.Scanner;

public class P05WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {


        String path = "C:\\Users\\aysel\\OneDrive\\Работен плот\\JAVA\\Advanced-  Java\\Streams,Files and Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";


        FileReader reader = new FileReader(path);
        Scanner scanner = new Scanner(reader);

        PrintStream printStream = new PrintStream("5output-third-line.txt");

        int lineNumber = 0;

        while (scanner.hasNext()) {
            lineNumber++;
            if (lineNumber % 3 == 0) {
                printStream.println(scanner.nextLine());

            } else {
                scanner.nextLine();
            }
        }
    }
}