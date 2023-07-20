package ExercisesSetsAndMapsAdvanced;

import java.util.*;

public class P03PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> chemicalCompoundsSet = new TreeSet<>();
      int count = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= count; i++) {
            String [] inputChemicalCompounds = scanner.nextLine().split("\\s+");

           chemicalCompoundsSet.addAll(Arrays.asList(inputChemicalCompounds));

//  2в         Collections.addAll(chemicalCompoundsSet, inputChemicalCompounds);

//  3в         for (String chemical : inputChemicalCompounds) {
//            chemicalCompoundsSet.add(chemical);
 //            }

        }

        chemicalCompoundsSet.forEach(chemical -> System.out.print(chemical + " "));



    }
}
