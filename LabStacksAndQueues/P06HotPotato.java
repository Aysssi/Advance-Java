package LabStacksAndQueues;

        import java.util.ArrayDeque;
        import java.util.Collections;
        import java.util.Deque;
        import java.util.Scanner;

public class P06HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque <String> kidsQueue = new ArrayDeque<>();

        String inputKids = scanner.nextLine();
        String [] namesArr = inputKids.split("\\s+");

        int steps = Integer.parseInt(scanner.nextLine());

        Collections.addAll(kidsQueue,namesArr);

        while (kidsQueue.size() > 1){
            for (int i = 1; i < steps ; i++) {
                String kid =  kidsQueue.poll();
                kidsQueue.offer(kid);

            }

            String removedChild = kidsQueue.poll();
            System.out.println("Removed "+ removedChild);
        }

        System.out.println("Last is " + kidsQueue.poll());

    }
}
