package ExercisesStacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

public class P05BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputParentheses = scanner.nextLine();
        ArrayDeque<Character> openBracketsStack = new ArrayDeque<>();

        boolean areBalanced = false;
        for (int i = 0; i < inputParentheses.length(); i++) {
            char currentBracket = inputParentheses.charAt(i);

            if (currentBracket == '(' || currentBracket == '{' || currentBracket == '['){
                openBracketsStack.push(currentBracket);

            }else if (currentBracket == ')' || currentBracket == '}' || currentBracket == ']'){

                if (openBracketsStack.isEmpty()){
                    areBalanced = false;
                    break;
                }

                char lastOpenBracket = openBracketsStack.pop();
                if (currentBracket == ')' && lastOpenBracket == '('){
                    areBalanced = true;

                } else if (currentBracket == '}' && lastOpenBracket == '{') {
                    areBalanced = true;

                } else if (currentBracket == ']' && lastOpenBracket == '[') {
                    areBalanced =  true;

                }else {
                    areBalanced = false;
                    break;
                }
            }
        }

        if (areBalanced) {
            System.out.println("YES");

        }else {
            System.out.println("NO");

        }

    }
}
