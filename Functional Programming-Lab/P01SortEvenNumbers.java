package LabFunctionalProgramming;

import org.w3c.dom.ls.LSInput;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> numbersArrList = Arrays.stream(scanner.nextLine().split(", "))
                .map(element -> Integer.parseInt(element))
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList());

      //  numbersArrList.removeIf(num -> num % 2 != 0);

        printNumbers(numbersArrList);
        System.out.println();

        List<Integer> sortedNumbers = numbersArrList
                .stream()
                .sorted()
                .collect(Collectors.toList());

        printNumbers(sortedNumbers);


    }

    private static void printNumbers(List<Integer> numbers) {

        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i));
            if (i < numbers.size() - 1) {
                System.out.print(", ");


            }
        }
    }
}
