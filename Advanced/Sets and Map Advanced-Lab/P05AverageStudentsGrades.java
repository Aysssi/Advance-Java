package LabSetsAndMapAdvanced;

import java.util.*;

public class P05AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String , List<Double>> studentsMap = new TreeMap<>();
        int count = Integer.parseInt(scanner.nextLine());

        for (int index = 1; index <= count; index++) {
            String [] studentData = scanner.nextLine().split("\\s+");
            String name = studentData[0];
            double grades = Double.parseDouble(studentData[1]);

            if (!studentsMap.containsKey(name)){
                studentsMap.put(name,new ArrayList<>());
                studentsMap.get(name).add(grades);
            }else {
                studentsMap.get(name).add(grades);
            }
        }

        for (Map.Entry<String, List<Double>> stringListEntry : studentsMap.entrySet()) {
            double sumGrades = 0;
            for (Double grades : stringListEntry.getValue()) {
                sumGrades += grades;
            }
            double averSumGrades = sumGrades / stringListEntry.getValue().size();

            System.out.printf("%s -> ",stringListEntry.getKey());
            stringListEntry.getValue().forEach(grades -> System.out.printf("%.2f ", grades));
            System.out.printf("(avg: %.2f)%n", averSumGrades);


        }



    }
}
