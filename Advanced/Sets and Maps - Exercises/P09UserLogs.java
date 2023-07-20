package ExercisesSetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P09UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        TreeMap<String, LinkedHashMap<String, Integer>> dataMap = new TreeMap<>();

        String inputData = scanner.nextLine();

        while (!inputData.equals("end")) {
            String [] dataArr = inputData.split("\\s+");
            String [] ipArr = dataArr[0].split("=");
            String ip = ipArr[1];
            String [] messageArr = dataArr[1].split("=");
            String message = messageArr[1];
            String [] usernameArr = dataArr[2].split("=");
            String username = usernameArr[1];


            if (!dataMap.containsKey(username)) {
                dataMap.put(username, new LinkedHashMap<>());

            }


            Map<String, Integer> currentIps = dataMap.get(username);

            if (!currentIps.containsKey(ip)) {
                currentIps.put(ip, 1);

            } else {
                currentIps.put(ip, currentIps.get(ip) + 1);

            }

            inputData = scanner.nextLine();
        }

        for (String username : dataMap.keySet()) {
            //dataMap.keySet() -> списък с всички usernames
            System.out.println(username + ": ");

            Map<String, Integer> currentIps = dataMap.get(username);

            int countIps = currentIps.size();
            //currentIps: ip (key) -> count(value)
            for (String ip : currentIps.keySet()) {
                if (countIps == 1) {
                    System.out.println(ip + " => " + currentIps.get(ip) + ".");

                } else {
                    System.out.print(ip + " => " + currentIps.get(ip) + ", ");
                }
                countIps--;
            }

        }
    }
}