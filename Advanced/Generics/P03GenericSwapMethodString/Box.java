package P03GenericSwapMethodString;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private List<T> elements;


    public Box(){
        this.elements = new ArrayList<>();
    }

    public void add(T element){
        this.elements.add(element);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T element : elements) {
            sb.append(element.getClass().getName()).append(": ").append(element).append("\n");
        }
        return sb.toString();
    }

    public void swap(int fistIndex, int secondIndex){
        T firstIndexElement = this.elements.get(fistIndex);
        T secondIndexElement = this.elements.get(secondIndex);
        this.elements.set(fistIndex,secondIndexElement);
        this.elements.set(secondIndex,firstIndexElement);
    }
}
