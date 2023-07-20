package P03GenericScaleLab;

public class Main {
    public static void main(String[] args) {

        Scale<String> stringScale = new Scale<>("a", "r");
        System.out.println(stringScale.getHeavier());

        Scale<Integer> integerScale = new Scale<>(28, 19);
        System.out.println(integerScale.getHeavier());
    }
}