package ExercisesSetsAndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> usernamesSet = new LinkedHashSet<>();
        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= count; i++) {
            String inputLine = scanner.nextLine();
            usernamesSet.add(inputLine);
        }



       usernamesSet.forEach(username -> {
           System.out.println(username);
        });


//  2в            usernamesSet.forEach(System.out::println);

//  3в           for (String username : usernamesSet) {
//                System.out.println(username);
//                 }

        }
    }

