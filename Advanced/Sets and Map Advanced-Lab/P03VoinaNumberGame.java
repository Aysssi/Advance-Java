package LabSetsAndMapAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P03VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Set<Integer> firstPlayerSet = new LinkedHashSet<>();
        Set<Integer> secondPlayerSet = new LinkedHashSet<>();

        String[] inputOne = scanner.nextLine().split(" ");
        for (int i = 0; i < inputOne.length; i++) {
            int current = Integer.parseInt(inputOne[i]);
            firstPlayerSet.add(current);

        }

        String[] inputTwo = scanner.nextLine().split(" ");
        for (int i = 0; i < inputTwo.length; i++) {
            int current = Integer.parseInt(inputTwo[i]);
            secondPlayerSet.add(current);
        }

        for (int step = 1; step <= 50; step++) {

            if (firstPlayerSet.isEmpty() || secondPlayerSet.isEmpty()) {
                break;
            }

            Integer playerOne = firstPlayerSet.iterator().next();
            Integer playerTwo = secondPlayerSet.iterator().next();

            firstPlayerSet.remove(playerOne);
            secondPlayerSet.remove(playerTwo);

            if (playerOne > playerTwo) {

                firstPlayerSet.add(playerOne);
                firstPlayerSet.add(playerTwo);

            } else if (playerOne < playerTwo) {

                secondPlayerSet.add(playerOne);
                secondPlayerSet.add(playerTwo);

            }
        }

        if (firstPlayerSet.size() > secondPlayerSet.size()) {
            System.out.println("First player win!");

        } else if (firstPlayerSet.size() < secondPlayerSet.size()) {
            System.out.println("Second player win!");

        } else {
            System.out.println("Draw!");

        }
    }

}