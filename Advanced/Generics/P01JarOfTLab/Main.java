package P01JarOfTLab;

public class Main {
    public static void main(String[] args) {

        Jar<Integer> jar = new Jar<>();

        jar.add(1);
        jar.add(26);
        jar.add(7);

        Jar<String > stringJar = new Jar<>();
        stringJar.add("first");
        stringJar.add("second");
        stringJar.add("third");

        System.out.println(jar.remove());
        System.out.println(stringJar.remove());

    }


}
