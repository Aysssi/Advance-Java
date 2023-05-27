package ExercisesMultidimensionalArrays;


import java.util.Scanner;

public class P01FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      String [] inputDataArr = scanner.nextLine().split(", ");
      int size = Integer.parseInt(inputDataArr[0]);
      String pattern = inputDataArr[1];

      int [][] matrix = new int [size][size];

      if (pattern.equals( "A")){

          fillMatrixPatternA(matrix);

      }else if (pattern.equals("B")){

          fillMatrixPatternB(matrix,size);
      }

      printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrixPatternB(int[][] matrix, int size) {
        int startNumber = 1;
        for (int col = 0; col < size; col++) {
            if (col % 2 == 0){
                for (int row = 0; row < size; row++) {
                     matrix [row][col] = startNumber++;
                }

            } else  {
                for (int row = size -1 ; row >= 0 ; row--) {
                    matrix[row][col] = startNumber++;
                }
            }
        }
    }

    private static void fillMatrixPatternA(int[][] matrix) {
        int startNumber = 1;
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix [row][col] = startNumber;
                startNumber++;
            }
        }
    }
}
