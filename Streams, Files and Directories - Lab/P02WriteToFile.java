package LabStreamsFilesAndDirectories;

import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;
;

public class P02WriteToFile {
    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\aysel\\OneDrive\\Работен плот\\JAVA\\Advanced-  Java\\Streams,Files and Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");

        FileInputStream inputStream = new FileInputStream(file);

        Scanner scanner = new Scanner(inputStream);

        StringBuilder sb = new StringBuilder();

        String  line  = scanner.nextLine();
        while ( line != null){

            sb .append(line.replaceAll("[,\\.!\\?]+", ""));

             sb .append(System.lineSeparator());
            try {
                line =scanner.nextLine();
            }catch (NoSuchElementException ex){
                inputStream.close();
                break;
            }

        }

      String  string = sb.toString();

        OutputStream outputStream = new FileOutputStream("outputs.txt");

        PrintWriter printWriter = new PrintWriter(outputStream);

        printWriter.print(string);

        printWriter.close();

    }
}


