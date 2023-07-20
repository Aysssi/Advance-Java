package P08CustomListSorter;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

       CustomListSorter<String> customList = new CustomListSorter<>();

        String commandLine = scanner.nextLine();
        while (!commandLine.equals("END")) {
            String[] commandArr = commandLine.split(" ");
            String command = commandArr[0];
            switch (command) {
                case "Add":
                    String element = commandArr[1];
                    customList.add(element);
                    break;
                case "Remove":
                    int index = Integer.parseInt(commandArr[1]);
                    customList.remove(index);
                    break;
                case "Contains":
                    String elementContains = commandArr[1];
                    System.out.println(customList.contains(elementContains));
                    break;
                case "Swap":
                    int indexFirst = Integer.parseInt(commandArr[1]);
                    int indexSecond = Integer.parseInt(commandArr[2]);
                    customList.swap(indexFirst, indexSecond);
                    break;
                case "Greater":
                    String elementGreater = commandArr[1];
                    System.out.println(customList.countGreaterThan(elementGreater));
                    break;
                case "Max":
                    System.out.println(customList.getMax());
                    break;
                case "Min":
                    System.out.println(customList.getMin());
                    break;
                case "Print":
                    customList.print();
                    break;
                case "Sort":
                    customList.sort();
                    break;
            }

            commandLine = scanner.nextLine();
        }
    }

}
