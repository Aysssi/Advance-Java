package LabSetsAndMapAdvanced;

import java.util.*;

public class P01ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<String> parkingSet = new LinkedHashSet<>();

         while (true){
             String input = scanner.nextLine();
             if (input.equals("END")){
                 break;
             }
             String [] dataArr = input.split(",\\s+");
             String direction = dataArr[0];
             String carNumber = dataArr[1];

             if (direction.equals("IN")){
               parkingSet.add(carNumber);

             }else if (direction.equals("OUT")){
               parkingSet.remove(carNumber);

             }

         }
         if (parkingSet.isEmpty()){
             System.out.println("Parking Lot is Empty");

         }else {
             parkingSet.forEach(car -> System.out.println(car));
         }


    }
}
