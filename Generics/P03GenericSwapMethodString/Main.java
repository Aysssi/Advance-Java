package P03GenericSwapMethodString;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Box<String> box =  new Box<>();

        for (int i = 1; i <= n ; i++) {
            String text = scanner.nextLine();
            box.add(text);
        }

        int fistIndex = scanner.nextInt();
        int secondIndex = scanner.nextInt();
        box.swap(fistIndex,secondIndex);
        System.out.println(box);
    }
}
