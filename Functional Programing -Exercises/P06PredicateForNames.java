package ExercisesFunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class P06PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String [] namesArr = scanner.nextLine().split(" ");

        Predicate<String > checkLength = name -> name.length() <= n;
        Arrays.stream(namesArr).filter(checkLength).forEach(name -> System.out.println(name));

    }
}
