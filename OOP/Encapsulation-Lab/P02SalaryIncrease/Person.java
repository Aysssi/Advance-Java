package LabEncapsulation.P02SalaryIncrease;

public class Person {
    private String firstName;
    private String lastname;
    private int age;
    private double salary;

    public Person(String firstName, String lastname, int age, double salary) {
        this.firstName = firstName;
        this.lastname = lastname;
        this.age = age;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void increaseSalary(double bonus){
        if (this.getAge() > 30){
            this.setSalary(this.getSalary() + (this.getSalary() * bonus /100 ));
        }else {
            this.setSalary(this.getSalary() + (this.getSalary() * bonus / 200));
        }

    }

    @Override
    public String toString() {
        return String.format("%s %s gets %.01f leva",this.getFirstName(),this.getLastname(),this.getSalary());
    }
}
