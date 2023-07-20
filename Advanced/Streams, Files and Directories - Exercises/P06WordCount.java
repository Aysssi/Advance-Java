package StreamsFilesAndDirectories;

import org.w3c.dom.stylesheets.LinkStyle;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P06WordCount {

    public static void main(String[] args) throws IOException {

        String pathWords = "C:\\Users\\aysel\\OneDrive\\Работен плот\\JAVA\\Advanced-  Java\\Streams,Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";

        List<String> allLinesWithWords = Files.readAllLines(Path.of(pathWords));

        Map<String,Integer>  countWordsMap = new HashMap<>();
        for (String line : allLinesWithWords) {
          String [] wordsOnCurrentRow = line.split("\\s+");
            Arrays.stream(wordsOnCurrentRow).forEach(word -> {
                countWordsMap.put(word,0);
            });
        }

        String pathText = "C:\\Users\\aysel\\OneDrive\\Работен плот\\JAVA\\Advanced-  Java\\Streams,Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";
        List<String> allLinesWithText = Files.readAllLines(Path.of(pathText));

        for (String line : allLinesWithText) {
            line = line.replaceAll("[\\.\\,\\?\\!\\:]", "");

            String [] words = line.split("\\s+");
            for (String  word : words) {
                if (countWordsMap.containsKey(word)){
                    countWordsMap.put(word,countWordsMap.get(word) + 1);
                }
            }
        }


        PrintWriter writer = new PrintWriter("6result.txt");
        countWordsMap.entrySet().stream()
                .sorted((e1,e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(entry -> writer.println(entry.getKey() + " - " + entry.getValue()));
        writer.close();

    }
}
