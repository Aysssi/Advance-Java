package ExercisesStacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P07SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        StringBuilder currentTextSb = new StringBuilder();
        ArrayDeque<String> textStack = new ArrayDeque<>();

        for (int i = 1; i <= n ; i++) {
            String [] commandsArr = scanner.nextLine().split("\\s+");
            String command = commandsArr[0];
            switch (command){
                case "1":
                    String textToAppends = commandsArr[1];

                   textStack.push(currentTextSb.toString());
                   currentTextSb.append(textToAppends);

                    break;
                case "2":
                    int count = Integer.parseInt(commandsArr[1]);

                    textStack.push(currentTextSb.toString());
                    int startIndexErases = currentTextSb.length() - count;
                    currentTextSb.delete(startIndexErases,currentTextSb.length());

                    break;
                case "3":
                    int index = Integer.parseInt(commandsArr[1]);

                    System.out.println(currentTextSb.charAt(index -1 ));

                    break;
                case "4":
                    if (!textStack.isEmpty()){
                        String last = textStack.pop();
                        currentTextSb = new StringBuilder(last);
                    }
                    break;
            }
        }

    }
}
