package ExercisesFunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P07FindTheSmallestElement {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> numbersList  = Arrays
                        .stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

//1в        Function<List<Integer>, Integer> checkSmallestNumber = list -> list.lastIndexOf(Collections.min(list));
//        System.out.println(checkSmallestNumber.apply(numbersList));

//2в
        Consumer<List<Integer>> printSmallestNumber = list -> System.out.println(list.lastIndexOf(Collections.min(list)));
        printSmallestNumber.accept(numbersList);


    }
}
