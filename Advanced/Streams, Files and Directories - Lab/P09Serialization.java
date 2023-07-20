package LabStreamsFilesAndDirectories;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class P09Serialization {
    public static void main(String[] args) throws IOException, ClassNotFoundException {


        Path outPath = Paths.get("C:\\Users\\aysel\\OneDrive\\Работен плот\\JAVA\\Advanced-  Java\\Streams,Files and Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");

        ObjectOutputStream oOut = new ObjectOutputStream(new FileOutputStream(outPath.toAbsolutePath().toString()));

        List<String> list = Arrays.asList("Alex", "Miro");

        oOut.writeObject(list);

        oOut.flush();
        oOut.close();

        ObjectInputStream oIn = new ObjectInputStream(new FileInputStream(outPath.toAbsolutePath().toString()));

        List<String> deserialize = (List<String>) oIn.readObject();

        oIn.close();
        deserialize.forEach(System.out::println);;
    }
}