package ExercisesStacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P04BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> numbersQueue = new ArrayDeque<>();
        String [] fistLineNumArr = scanner.nextLine().split("\\s+");
        String [] secondLineNumArr = scanner.nextLine().split("\\s+");

        int n = Integer.parseInt( fistLineNumArr[0]);
        int s = Integer.parseInt( fistLineNumArr[1]);
        int x = Integer.parseInt( fistLineNumArr[2]);

        for (int i = 0; i < n; i++) {
            numbersQueue.offer(Integer.parseInt( secondLineNumArr[i]));
        }

        for (int i = 1; i <= s ; i++) {
          numbersQueue.poll();
        }
        if (numbersQueue.isEmpty()){
            System.out.println(0);
        }else {

            if (numbersQueue.contains(x)) {
                System.out.println("true");

            } else {
                int smallestElement = Collections.min(numbersQueue);
                System.out.println(smallestElement);
            }
        }
    }
}
