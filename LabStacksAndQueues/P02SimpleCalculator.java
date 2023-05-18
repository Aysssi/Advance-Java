package LabStacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P02SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        ArrayDeque<String> stack = new ArrayDeque<>();

        String expression = scanner.nextLine();
        String [] expressionPartsArr = expression.split("\\s+");

        List<String> partsList =  Arrays.asList(expressionPartsArr);

        stack.addAll(partsList);

//        Collections.reverse(partsList);
//
//        for (String  part : partsList) {
//            stack.push(part);
//        }

        while (stack. size() > 1){
            int first = Integer.parseInt(stack.pop());
            String  op = stack.pop();
            int second = Integer.parseInt(stack.pop());

            int result = 0;
            switch (op){
                case "+":
                    result = first + second;

                    break;
                case "-":
                    result = first - second;

                    break;
                default:
                    System.out.println("Unknown operation" + op);

            }

            stack.push("" + result);

        }


        System.out.println(stack.peek());

    }
}
