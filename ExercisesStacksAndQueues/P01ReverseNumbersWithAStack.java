package ExercisesStacksAndQueues;

import java.util.*;

public class P01ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


       ArrayDeque<String> numbersStack = new ArrayDeque<>();

       String [] numbersArr = scanner.nextLine().split("\\s+");

       for (String number : numbersArr){
           numbersStack.push(number);
       }

//        for (int i = 0; i < numbersArr.length; i++) {
//            numbersStack.push(numbersArr[i]);
//
//        }

        while (!numbersStack.isEmpty()){
            System.out.print(numbersStack.pop() +" ");
        }
    }
}
