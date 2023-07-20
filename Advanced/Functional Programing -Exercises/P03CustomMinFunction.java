package ExercisesFunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P03CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer>  inputNumbersList =  Arrays
                        .stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        Consumer<List<Integer>> getPrintMinNumber = number -> System.out.println(Collections.min(number));
        getPrintMinNumber.accept(inputNumbersList);


//        Function<List<Integer>, Integer> getPrintMinNumber = list -> Collections.min(list);
//        int minNumber = getPrintMinNumber.apply(inputNumbersList);
//        System.out.println(minNumber);


    }
}
