package ExercisesInterfacesAndAbstraction.P05Telephony;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] numbersData = scanner.nextLine().split("\\s+");
        String [] urls = scanner.nextLine().split("\\s+");

        Smartphone smartphone = new Smartphone(List.of(numbersData),List.of(urls));

        System.out.print(smartphone.call());
        System.out.print(smartphone.browse());




    }
}
