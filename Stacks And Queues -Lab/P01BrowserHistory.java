package LabStacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P01BrowserHistory {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);

        ArrayDeque<String > historyStack = new ArrayDeque<>();

        String  currentInput = scanner.nextLine();
        while (!currentInput.equals("Home")){

            if (currentInput.equals("back")){
             if (historyStack.isEmpty() || historyStack.size() == 1) {
                 System.out.println("no previous URLs");

                 currentInput =scanner.nextLine();
                 continue;
             }

             historyStack.pop();
            }else {
               historyStack.push(currentInput);

            }

            System.out.println(historyStack.peek());

            currentInput = scanner.nextLine();
        }
    }
}
