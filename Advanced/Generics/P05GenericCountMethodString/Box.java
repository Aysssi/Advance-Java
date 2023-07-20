package P05GenericCountMethodString;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable> {
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
    public void swap (int firstIndex , int secondIndex){
        T firstElementIndex = this.elements.get(firstIndex);
        T secondElementIndex = this.elements.get(secondIndex);
        this.elements.set(firstIndex,secondElementIndex);
        this.elements.set(secondIndex,firstElementIndex);
    }

    public int countGreaterThan(T element){
        int count = 0;
        for (T elementInList : this.elements) {
            if (elementInList.compareTo(element) > 0){
                count++;
            }
        }
        return count;
    }
}
