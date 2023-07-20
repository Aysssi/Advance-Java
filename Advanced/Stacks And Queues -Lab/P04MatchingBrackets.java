package LabStacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P04MatchingBrackets {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<Integer> indexesStack = new ArrayDeque<>();

        String inputExpression = scanner.nextLine();

        for (int i = 0; i < inputExpression.length() ; i++) {
           char currentSymbol = inputExpression.charAt(i);

           if (currentSymbol == '('){
               indexesStack.push(i);

           }else if (currentSymbol == ')'){

               int openBracketIndex  = indexesStack.pop();
               String  subExpression = inputExpression.substring(openBracketIndex, i + 1);

               System.out.println(subExpression);
           }
        }

    }
}
