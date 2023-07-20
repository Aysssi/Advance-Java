package ExercisesSetsAndMapsAdvanced;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P04CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<Character,Integer> countSymbolsMap = new TreeMap<>();
     String inputText = scanner.nextLine();

        for (int i = 0; i < inputText.length(); i++) {
            char currentSymbol = inputText.charAt(i);

            if (!countSymbolsMap.containsKey(currentSymbol)){
                countSymbolsMap.put(currentSymbol,1);

            }else {
                int currentCounts = countSymbolsMap.get(currentSymbol) + 1;
                countSymbolsMap.put(currentSymbol,currentCounts);

            }

        }

        for (Map.Entry<Character, Integer> characterIntegerEntry : countSymbolsMap.entrySet()) {
            System.out.printf("%s: %d time/s%n",characterIntegerEntry.getKey(),characterIntegerEntry.getValue());
        }

    }
}
