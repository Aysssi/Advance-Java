package LabInterfacesAndAbstraction.P05BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String inputData = scanner.nextLine();

        List<Identifiable> identifiableList = new ArrayList<>();

        while (!inputData.equals("End")) {
            String[] dataArr = inputData.split("\\s+");

            Identifiable identifiable;

            if (dataArr.length == 3) {
                String name = dataArr[0];
                int age = Integer.parseInt(dataArr[1]);
                String id = dataArr[2];
                identifiable = new Citizen(name, age, id);
            } else {
                String model = dataArr[0];
                String id = dataArr[1];
                identifiable = new Robot(model, id);
            }

            identifiableList.add(identifiable);

            inputData = scanner.nextLine();
        }

        String lastDigits = scanner.nextLine();

        identifiableList.stream().filter(i -> i.getId().endsWith(lastDigits))
                .forEach((Identifiable i) -> System.out.println(i.getId()));
    }
}