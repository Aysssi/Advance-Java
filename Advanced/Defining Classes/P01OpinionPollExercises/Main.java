package P01OpinionPollExercises;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Person> personList = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int row = 1; row <= n; row++) {
            String personalData = scanner.nextLine();

            String name = personalData.split(" ")[0];
            int age = Integer.parseInt(personalData.split(" ")[1]);
            if (age > 30) {

                Person person = new Person(name, age);
                personList.add(person);
            }
        }

        personList
                .stream()
                .filter(p -> p.getAge() > 0)
                .sorted(Comparator.comparing(person -> person.getName()))
                .forEach(System.out::println);

        }


//        personList.sort((Comparator.comparing(f-> f.getName())));
//
//        for (Person person : personList) {
//            System.out.println(person.getName() + " - " + person.getAge());
//        }
    }


