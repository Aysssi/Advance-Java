package LabStreamsFilesAndDirectories;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class P03CopyBytes {
    public static void main(String[] args) throws IOException {



        String path = "C:\\Users\\aysel\\OneDrive\\Работен плот\\JAVA\\Advanced-  Java\\Streams,Files and Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        byte [] bytes = Files.readAllBytes(Path.of(path));

        Writer writer = new FileWriter("3text-as-bytes.txt");

        for (byte b : bytes) {
            String out = String.valueOf(b);
            if (b == 32){
                out =" ";
            }else if ( b == 10){
                out = System.lineSeparator();
            }
            writer.write( String.valueOf(out));

        }

        writer.close();


        }
    }
