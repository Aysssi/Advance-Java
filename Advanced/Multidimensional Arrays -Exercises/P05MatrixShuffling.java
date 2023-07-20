package ExercisesMultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class P05MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       int [] dimensions = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows =  dimensions[0];
        int cols =  dimensions[1];

        //  String [] inputDataArr = scanner.nextLine().split("\\s+");
        //        int rows = Integer.parseInt( inputDataArr[0]);
        //        int cols = Integer.parseInt( inputDataArr[1]);

        String [][] matrix = new String[rows][cols];

        fillMatrix(scanner,matrix,rows,cols);

        String inputCommand = scanner.nextLine();
        while (!inputCommand.equals("END")){

            if (validCommand(inputCommand,rows,cols)){
              String [] commandArr = inputCommand.split("\\s+");

                int row1 = Integer.parseInt(commandArr[1]);
                int col1 = Integer.parseInt(commandArr[2]);
                int row2 = Integer.parseInt(commandArr[3]);
                int col2 = Integer.parseInt(commandArr[4]);

                String  firstElement = matrix[row1][col1];
                String  secondElement = matrix[row2][col2];

                matrix[row1][col1] = secondElement;
                matrix[row2][col2] = firstElement;

                printMatrix (matrix,rows,cols);

            }else {
                System.out.println("Invalid input!");
            }

            inputCommand = scanner.nextLine();
        }
    }

    private static void printMatrix(String[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }

    }

    private static boolean validCommand( String inputCommand, int rows, int cols) {
         String [] commandArr = inputCommand.split("\\s+");
         String command = commandArr[0];

         if (!command.equals("swap")){
             return false;
         }

         if (commandArr.length != 5){
             return false;
         }

         int row1 = Integer.parseInt(commandArr[1]);
         int col1 = Integer.parseInt(commandArr[2]);
         int row2 = Integer.parseInt(commandArr[3]);
         int col2 = Integer.parseInt(commandArr[4]);

         if (row1 < 0 || row1 >= rows || col1 < 0 || col1 >= cols || row2 < 0 || row2 >= rows || col2 < 0 || col2 >= cols){
             return false;
         }

       //командата е валидна по всички параметри
         return  true;
    }


    private static void fillMatrix(Scanner scanner,String[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
    }
}
