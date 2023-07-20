package LabStreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class P06SortLines {
    public static void main(String[] args) throws IOException {

        String inputPath = "C:\\Users\\aysel\\OneDrive\\Работен плот\\JAVA\\Advanced-  Java\\Streams,Files and Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        List<String > allLines = Files.readAllLines(Path.of(inputPath));
        Collections.sort(allLines);

        Files.write(Path.of("6s.txt"),allLines);


//        List<String > allLines = Files.readAllLines(Paths.get(inputPath))
//                .stream()
//                .sorted(String::compareTo)
//                .collect(Collectors.toList());

//        Files.write(Paths.get("6sortedLines.txt"),allLines);

    }
}
