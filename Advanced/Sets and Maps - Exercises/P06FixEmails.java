package ExercisesSetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P06FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String ,String > namesEmailsMap = new LinkedHashMap<>();

       String name = scanner.nextLine();
       while (!name.equals("stop")){
           String email = scanner.nextLine();

           if (!email.endsWith("us") && !email.endsWith("uk") &&  !email.endsWith("or") && !email.endsWith("com") ){
               namesEmailsMap.put(name,email);
           }

           name =scanner.nextLine();
       }

        namesEmailsMap.forEach((key, value) -> System.out.println(key + " -> " + value));

//  2в       namesEmailsMap.entrySet().forEach(entry -> System.out.println(entry.getKey() + " -> "+ entry.getValue()));

//  3в       for (Map.Entry<String, String> stringEntry : namesEmailsMap.entrySet()) {
//            System.out.println(stringEntry.getKey() + " -> " + stringEntry.getValue());
//        }


    }
}
