package ExercisesFunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class P01ConsumerPrint {
    public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);

        String [] inputNames = scanner.nextLine().split("\\s+");

        Consumer<String> print = str -> System.out.println(str);

        Arrays.stream(inputNames).
                forEach(name -> print.accept(name));

    }
}
