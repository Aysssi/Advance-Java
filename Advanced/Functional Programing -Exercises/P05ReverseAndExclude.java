package ExercisesFunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P05ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        List<Integer> numbersList = Arrays
                        .stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        int n = Integer.parseInt(scanner.nextLine());

        Collections.reverse(numbersList);


        Predicate<Integer> checkDivisible = number -> number % n == 0;
        numbersList.removeIf(checkDivisible);

// 2в       Predicate<Integer> checkDivisible = number -> number % n != 0;
//      numbersList = numbersList.stream().filter(checkDivisible).collect(Collectors.toList());


        numbersList.forEach(num -> System.out.print(num + " "));
    }
}
