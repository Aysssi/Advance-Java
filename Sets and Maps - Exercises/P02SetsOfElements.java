package ExercisesSetsAndMapsAdvanced;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P02SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] lineDataArr = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int numberN = lineDataArr[0];
        int numberM = lineDataArr[1];

        Set<Integer> elementsNSet = new LinkedHashSet<>();
        Set<Integer> elementsMSet = new LinkedHashSet<>();

        for (int n = 1; n <= numberN; n++) {
            int inputNum = Integer.parseInt(scanner.nextLine());
            elementsNSet.add(inputNum);
        }

        for (int m = 1; m <= numberM; m++) {
            int inputNum = Integer.parseInt(scanner.nextLine());
            elementsMSet.add(inputNum);
        }

        elementsNSet.retainAll(elementsMSet);

        elementsNSet.forEach(element -> System.out.print(element + " "));

        // 2В
//        Set<Integer> duplicateElements = new LinkedHashSet<>();
//        for (int number : elementsNSet) {
//            if (elementsMSet.contains(number)){
//                duplicateElements.add(number);
//            }
//        }
//
//        duplicateElements.forEach(element -> System.out.print(element + " "));

    }
}
