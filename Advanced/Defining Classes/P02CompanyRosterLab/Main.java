package P02CompanyRosterLab;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

      Map< String ,Department> departmentMap = new HashMap<>();

        while (n --> 0){
            String [] tokes = scanner.nextLine().split(" ");
            String name = tokes[0];
            double salary = Double.parseDouble(tokes[1]);
            String position = tokes[2];
            String department = tokes[3];

            Employee employee;
            if (tokes.length == 4){
           employee = new Employee(name,salary,position,department);
            } else if (tokes.length == 6) {
                employee = new Employee(name,salary,position,department,tokes[4], Integer.parseInt(tokes[5]));
            } else  {
               try {
               int age =  Integer.parseInt(tokes[4]);
                employee = new Employee(name,salary,position,department,age);
               }catch (NumberFormatException ex){
                   String email = tokes[4];
                employee = new Employee(name,salary,position,department, email);
               }
            }

            departmentMap.putIfAbsent(department,new Department(department));
            departmentMap.get(department).getEmployees().add(employee);
        }

      Department maxDepartment = departmentMap
              .entrySet()
              .stream()
              .max(Comparator.comparing(f-> f.getValue().getAverageSalary()))
              .get()
              .getValue();

        System.out.println("Highest Average Salary: " + maxDepartment.getName());
        maxDepartment.getEmployees()
                .stream()
                .sorted((f,s) -> Double.compare(s.getSalary(), f.getSalary()))
                .forEach(e -> {
            System.out.println(e);
        });
    }
}
