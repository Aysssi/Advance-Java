package ExercisesMultidimensionalArrays;

import java.util.Map;
import java.util.Scanner;

public class P03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int [][] matrix = new int [size][size];

        fillMatrix( scanner,matrix,size);

        int primarySum = getSumElementsOnPrimaryDiagonal(matrix,size);
        int secondarySum = getSumElementsOnSecondaryDiagonal(matrix);

        System.out.println(Math.abs(primarySum - secondarySum));
    }

    private static int getSumElementsOnSecondaryDiagonal(int[][] matrix) {
        // ( col == size - row -1 )     ||     ( row + col == size - 1)
       int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                int currentElement = matrix[row][col];
                if (col == matrix.length - row - 1){
                    sum += currentElement;
                }
            }
        }
        return sum;
    }

    private static int getSumElementsOnPrimaryDiagonal(int[][] matrix, int size) {
        // ( row == col )

        int sum = 0;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                int currentElement = matrix[row][col];
                if (row == col){
                    sum += currentElement;
                }
            }
        }
        return sum;
    }

    private static void fillMatrix( Scanner scanner,int[][] matrix, int size) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                matrix [row][col] = scanner.nextInt();
            }
        }

    }

}
