package ExercisesStacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P02BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer > numbersStack = new ArrayDeque<>();

       String [] fistLineArr = scanner.nextLine().split("\\s+");
       String [] secondLineArr = scanner.nextLine().split("\\s+");

       int n = Integer.parseInt( fistLineArr[0]);
       int s = Integer.parseInt(fistLineArr[1]);
       int x = Integer.parseInt(fistLineArr[2]);


        for (int i = 0; i < n; i++) {
            numbersStack.push (Integer.parseInt( secondLineArr[i]));
        }

        for (int i = 1; i <= s ; i++) {
            numbersStack.pop();
        }

          if (numbersStack.isEmpty()){
              System.out.println(0);

          }else {
              if (numbersStack.contains(x)) {
                  System.out.println("true");

              } else {
                int minElement = Collections.min(numbersStack);
                System.out.println(minElement);

              //    System.out.println(getMinElement(numbersStack)); *****

              }

          }
    }

    private static int getMinElement(ArrayDeque<Integer> numbersStack) {
        int min = Integer.MAX_VALUE;
        for (int number : numbersStack) {
            if (number < min){
                min = number;
            }

        }
        return min;
    }


}
