package LabFunctionalProgramming;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class P05FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> peopleMap = new LinkedHashMap<>();

        for (int i = 1; i <= n; i++) {
            String [] inputDataArr = scanner.nextLine().split(", ");
            String name = inputDataArr[0];
            int age =Integer.parseInt(inputDataArr[1]);
            peopleMap.put(name,age);
        }

        String condition = scanner.nextLine();
        int ageLimit = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        Predicate<Integer> filter = getPredicate(condition, ageLimit);
        Consumer<Map.Entry<String, Integer>> print = getPrintConsumer(format);


        peopleMap
                .entrySet()
                .stream()
                .filter(entry -> filter.test(entry.getValue()))
                .forEach(entry -> print.accept(entry));


    }

    private static Consumer<Map.Entry<String, Integer>> getPrintConsumer(String format) {
        if(format.equals("name")) {
            return e -> System.out.println(e.getKey());

        } else if(format.equals("age")) {
            return e -> System.out.println(e.getValue());

        } else if(format.equals("name age")) {
            return e -> System.out.printf("%s - %d%n", e.getKey(), e.getValue());

        }
        throw new RuntimeException("Bad format!");
    }

    private static Predicate<Integer> getPredicate(String condition, int ageLimit) {
        if(condition.equals("older")) {
            return x -> x >= ageLimit;

        } else if (condition.equals("younger")) {
            return x -> x <= ageLimit;
        }

        throw new RuntimeException("Bad condition! Use 'older' or 'younger'");
    }
}
