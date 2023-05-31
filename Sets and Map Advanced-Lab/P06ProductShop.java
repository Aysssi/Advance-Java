package LabSetsAndMapAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P06ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,Map<String ,Double>> shopProductPriceMap = new TreeMap<>();


        String inputData = scanner.nextLine();
        while (!inputData.equals("Revision")){
            String [] dataArr = inputData.split(", ");
            String shop = dataArr[0];
            String product = dataArr[1];
            Double price = Double.parseDouble( dataArr[2]);

            if (!shopProductPriceMap.containsKey(shop)){
                shopProductPriceMap.put(shop,new LinkedHashMap<>());
                shopProductPriceMap.get(shop).put(product,price);

            }else {
                if (!shopProductPriceMap.containsKey(product)){
                    shopProductPriceMap.get(shop).put(product,price);
                }

            }

            inputData = scanner.nextLine();
        }

        for (Map.Entry<String, Map<String, Double>> stringMapEntry : shopProductPriceMap.entrySet()) {
            System.out.printf("%s->%n",stringMapEntry.getKey());
            for (Map.Entry<String, Double> entry : stringMapEntry.getValue().entrySet()) {
                System.out.printf("Product: %s, Price: %.1f%n",entry.getKey(),entry.getValue());
            }

        }

    }
}
