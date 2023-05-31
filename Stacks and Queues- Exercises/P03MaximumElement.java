package ExercisesStacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P03MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> numbersStack = new ArrayDeque<>();

       int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n ; i++) {
            String [] commandArr = scanner.nextLine().split("\\s+");
            String command = commandArr[0];
            switch (command){
                case "1":
                  int element = Integer.parseInt(commandArr[1]);
                  numbersStack.push(element);
                    break;
                case "2":
                  numbersStack.pop();
                    break;
                case "3":
                    System.out.println(Collections.max(numbersStack));
                    break;
            }
        }

    }
}
