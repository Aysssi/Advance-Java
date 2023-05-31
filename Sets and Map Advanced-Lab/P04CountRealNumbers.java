package LabSetsAndMapAdvanced;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P04CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<Double,Integer>  valueWithOccurrencesMap = new LinkedHashMap<>();

     double [] numbersArr = Arrays
             .stream(scanner.nextLine().split("\\s+"))
             .mapToDouble(Double::parseDouble)
             .toArray();;


        for (double number : numbersArr) {

            if (!valueWithOccurrencesMap.containsKey(number)){
                valueWithOccurrencesMap.put(number,1);

            }else {
                int currentCount =  valueWithOccurrencesMap.get(number) + 1;
                valueWithOccurrencesMap.put(number,currentCount);
            }

        }

        for (Map.Entry<Double, Integer> entry : valueWithOccurrencesMap.entrySet()) {
            System.out.printf("%.1f -> %d%n", entry.getKey(),entry.getValue());
        }


    }
}
