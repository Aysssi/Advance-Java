package LabFunctionalProgramming;

import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class P06FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String [] input = scanner.nextLine().split(" ");
        int lowerBound = Integer.parseInt(input[0]);
        int upperBound = Integer.parseInt(input[1]);

        String evenOrOdd = scanner.nextLine();

        Predicate<Integer> filterCondition = getPredicate(evenOrOdd);

        IntStream.range(lowerBound,upperBound + 1)
                .filter(num -> filterCondition.test(num ))
                .forEach(num -> System.out.print(num + " "));

    }

    private static Predicate<Integer> getPredicate(String evenOrOdd) {
        if (evenOrOdd.equals("even")){
            return x -> x % 2 == 0;

        } else if (evenOrOdd.equals("odd")) {
           return x -> x %2 != 0;
        }
        throw new RuntimeException(" Use 'even' or 'odd'");
    }
}
