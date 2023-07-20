package LabFunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P02SumNumbers {
    public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);




        Function<String ,Integer> parseInt = str -> Integer.parseInt(str);

        List<Integer> numbersArrList = Arrays.stream(scanner.nextLine().split(", "))
                .map(element -> parseInt.apply(element))
                .collect(Collectors.toList());


        int sum = numbersArrList.stream()
                .mapToInt(n -> n)
                .sum();

        System.out.println("Count = " + numbersArrList.size());
        System.out.println("Sum = " + sum);



//        List<Integer> numbersArrList = Arrays
//                .stream(scanner.nextLine().split(", "))
//                .map(Integer::parseInt)
//                .collect(Collectors.toList());
//
//        int sum = numbersArrList.stream()
//                .mapToInt(num -> num)
//                .sum();
//
//        System.out.println("Count = " + numbersArrList.size());
//        System.out.println("Sum = " + sum);
    }
}
