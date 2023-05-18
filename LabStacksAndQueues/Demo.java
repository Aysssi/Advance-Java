package LabStacksAndQueues;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        ArrayDeque<String> childrenQueue = new ArrayDeque<>();
        String  [] inputChildren = scanner.nextLine().split("\\s+");
        int counter =  Integer.parseInt(scanner.nextLine());

        Collections.addAll(childrenQueue,inputChildren);

        while (childrenQueue.size() > 1){

            for (int i = 1; i <= counter ; i++) {
                String nameKid = childrenQueue.poll();
                childrenQueue.offer(nameKid);
            }
            System.out.println("Removed "+ childrenQueue.poll());
        }

        System.out.println("Last is " + childrenQueue.poll());

    }


}
