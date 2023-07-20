package P04ListUtilitiesLab;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> items = Arrays.asList( 1,7,19,26,28 );

        System.out.println(ListUtils.getMax(items));
        System.out.println(ListUtils.getMin(items));
    }
}
