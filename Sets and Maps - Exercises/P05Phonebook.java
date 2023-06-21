package ExercisesSetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class P05Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String ,String > phonebookMap = new LinkedHashMap<>();
       String dataName =scanner.nextLine();
        while (!dataName.equals("search")) {
            String[] dataArr = dataName.split("-");
            String name = dataArr[0];
            String number = dataArr[1];

            phonebookMap.put(name,number);

            dataName =scanner.nextLine();

        }

        String inputName = scanner.nextLine();
        while (!inputName.equals("stop")){
            if (phonebookMap.containsKey(inputName)){

                System.out.println(inputName + " -> " + phonebookMap.get(inputName));

            }else {
                System.out.printf("Contact %s does not exist.%n",inputName);
            }

            inputName =scanner.nextLine();
        }

    }
}
