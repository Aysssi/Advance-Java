package P02CompanyRosterLab;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Employee>employees;

    public Department(String name){
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public String getName(){
        return  this.name;
    }
    public List<Employee> getEmployees (){
        return this.employees;
    }

    public double getAverageSalary(){
        double sum = 0;

        for (Employee employee : employees) {
            sum +=  employee.getSalary();
        }
        return  sum / this.getEmployees().size();
    }
//        return this .employees
//                .stream()
//                .mapToDouble(e -> e.getSalary())
//                .average()
//                .orElse(0.0);
//    }



}
