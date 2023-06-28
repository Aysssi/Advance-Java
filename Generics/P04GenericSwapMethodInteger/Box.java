package P04GenericSwapMethodInteger;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
        private List<T> elements;

    public Box() {
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

    public void swap(int firstIndex, int secondIndex){
        T firstElementIndex = this.elements.get(firstIndex);
        T secondElementIndex = this.elements.get(secondIndex);
        this.elements.set(firstIndex,secondElementIndex);
        this.elements.set(secondIndex,firstElementIndex);
    }
}
