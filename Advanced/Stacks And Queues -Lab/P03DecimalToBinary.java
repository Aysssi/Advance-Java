package LabStacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P03DecimalToBinary {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<Integer> bitsStack = new ArrayDeque<>();

        int number = Integer.parseInt(scanner.nextLine());

        if (number < 0 ){
            System.out.println("Cannot handle negative integer");
            return;

        }

        if (number == 0 ) {
            System.out.println(0);
            return;
        }

        while (number > 0){
            int bit = number % 2;
            bitsStack.push(bit);

            number = number / 2;
        }

        while (!bitsStack.isEmpty()){
            System.out.print(bitsStack.pop());
        }

    }
}
