package P01CarLab;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);


       int countOfCar = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= countOfCar; i++) {
            Car current = new Car();
            String [] carArr = scanner.nextLine().split(" ");

            current.setBrand(carArr[0]);
            current.setModel(carArr[1]);
            int horsepower = Integer.parseInt(carArr[2]);
            current.setHorsePower(horsepower);

            System.out.println(current.carInfo());
        }



    }
}
