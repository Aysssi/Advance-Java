package P02CarConstructorsExercises;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int countOfCar = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= countOfCar ; i++) {
            Car currentCar;
            String [] carDataArr = scanner.nextLine().split(" ");

            String brand = carDataArr[0];
            if (carDataArr.length == 1){
                currentCar = new Car(brand);

            }else {
                String  model = carDataArr[1];
                int horsePower = Integer.parseInt( carDataArr[2]);
               currentCar = new Car(brand,model,horsePower);

            }

            System.out.println(currentCar.carInfo());

        }
    }
}
