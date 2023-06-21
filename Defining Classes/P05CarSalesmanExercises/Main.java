package P05CarSalesmanExercises;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Engine> enginesList = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            String[] dataArr = scanner.nextLine().split(" ");
            Engine en = new Engine();

            en.setModel(dataArr[0]);
            en.setPower(Integer.parseInt(dataArr[1]));

            if (dataArr.length == 3) {
                try {
                    en.setDisplacement(Integer.parseInt(dataArr[2]));
                } catch (NumberFormatException e) {
                    en.setEfficiency(dataArr[2]);
                }

            } else if (dataArr.length == 4) {
                en.setDisplacement(Integer.parseInt(dataArr[2]));
                en.setEfficiency(dataArr[3]);

            }

            enginesList.add(en);
        }

        List<Car> carsList = new ArrayList<>();
        int m = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= m; i++) {
            String[] dataArr = scanner.nextLine().split(" ");

            Car car = new Car();
            car.setModel(dataArr[0]);

            Engine thisEngine = new Engine();
            for (Engine en : enginesList) {
                if (en.getModel().equals(dataArr[1])) {
                    thisEngine = en;
                }
            }

            car.setEngine(thisEngine);

            if (dataArr.length == 3) {
                try {
                    car.setWeight(Integer.parseInt(dataArr[2]));
                } catch (NumberFormatException e) {
                    car.setColor(dataArr[2]);
                }

            } else if (dataArr.length == 4) {
                car.setWeight(Integer.parseInt(dataArr[2]));
                car.setColor(dataArr[3]);
            }

            carsList.add(car);
        }

        for (Car c : carsList) {
            c.toString();
        }


    }
}
