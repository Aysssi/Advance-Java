package LabInterfacesAndAbstraction.P06Ferrari;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String driveName = scanner.nextLine();
        Car car = new Ferrari(driveName);
        System.out.println(car);

    }
}
