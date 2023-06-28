package P02GenericArrayCreatorLab;

public class Main {
    public static void main(String[] args) {


        String [] strings = ArrayCreator.create(String.class,7,"asd" );

        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }
    }
}
