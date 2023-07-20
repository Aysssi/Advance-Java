package LabSetsAndMapAdvanced;

import java.util.*;

public class P08AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String , double[] > academyGraduationMap = new TreeMap<>();

        int count = Integer.parseInt(scanner.nextLine());
        for (int index = 1; index <= count; index ++) {
            String name = scanner.nextLine();
            double [] differentNumbers = Arrays
                 .stream(scanner.nextLine().split(" "))
                 .mapToDouble(Double::parseDouble)
                 .toArray();

            academyGraduationMap.put(name,differentNumbers);

        }

        for (Map.Entry<String, double[]> stringListEntry : academyGraduationMap.entrySet()) {
            double sumGrades = 0;
            for (double grades : stringListEntry.getValue()) {
                sumGrades += grades;
            }
            double average = sumGrades / stringListEntry.getValue().length;
            System.out.printf("%s is graduated with %s%n", stringListEntry.getKey(), average);
;        }


    }
}
