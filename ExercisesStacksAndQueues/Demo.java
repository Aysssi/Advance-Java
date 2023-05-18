package ExercisesStacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Character> openBracketsStack = new ArrayDeque<>();
       String  inputParentheses = scanner.nextLine();
         boolean areBalance = false;
        for (int i = 0; i < inputParentheses.length(); i++) {
            char currentBracket = inputParentheses.charAt(i);

            if (currentBracket == '(' || currentBracket == '{' || currentBracket == '[') {
                openBracketsStack.push(currentBracket);

            } else if (currentBracket == ')' || currentBracket == '}' || currentBracket == ']') {

                if (openBracketsStack.isEmpty()){
                    areBalance =false;
                    break;
                }
                char lastOpenBracket = openBracketsStack.pop();
                if (currentBracket == ')' &&  lastOpenBracket == '('){
                    areBalance = true;

                } else if (currentBracket == '}' && lastOpenBracket == '{') {
                    areBalance = true;

                } else if (currentBracket == ']'&& lastOpenBracket == '[') {
                    areBalance = true;

                }else {
                    areBalance =false;
                    break;
                }

            }
        }

        if (areBalance){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}
