package ExercisesMultidimensionalArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P07Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] inputData = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = inputData[0];
        int cols = inputData[1];

//        String inputData = scanner.nextLine();
//        int rows = Integer.parseInt(inputData.split("\\s+")[0]);
//        int cols = Integer.parseInt(inputData.split("\\s+")[1]);


        List<List<Integer>> matrix = new ArrayList<>();

        fillTheMatrix(matrix, rows, cols);

        String command = scanner.nextLine();
        while (!command.equals("Nuke it from orbit")) {
            int row = Integer.parseInt(command.split("\\s+")[0]);
            int col = Integer.parseInt(command.split("\\s+")[1]);
            int radius = Integer.parseInt(command.split("\\s+")[2]);

            for (int currentRow = row - radius; currentRow <= row + radius; currentRow++) {
                if (isInMatrix(currentRow, col, matrix)) {
                    matrix.get(currentRow).set(col, 0);
                }
            }
            for (int currentColumn = col - radius; currentColumn <= col + radius; currentColumn++) {
                if (isInMatrix(row, currentColumn, matrix)) {
                    matrix.get(row).set(currentColumn, 0);
                }
            }
            for (int i = 0; i < matrix.size(); i++) {
                matrix.get(i).removeAll(new ArrayList<Integer>(){{add(0);}});

                if (matrix.get(i).size() == 0) {
                    matrix.remove(i);
                    i--;
                }
            }
            command = scanner.nextLine();
        }
        printMatrix(matrix);
    }
    private static boolean isInMatrix(int m, int n, List<List<Integer>> matrix) {
        return m >= 0 && m < matrix.size() && n >= 0 && n < matrix.get(m).size();
    }
    private static void fillTheMatrix(List<List<Integer>> matrix, int rows, int cols) {
        int startNumber = 1;
        for (int row = 0; row < rows; row++) {
            matrix.add(new ArrayList<>());
            for (int col = 0; col < cols; col++) {
                matrix.get(row).add(startNumber);
                startNumber++;
            }
        }
    }
    public static void printMatrix(List<List<Integer>> matrix) {
        for (List<Integer> row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}


