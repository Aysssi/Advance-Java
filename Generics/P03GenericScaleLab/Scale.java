package P03GenericScaleLab;

public class Scale<T extends Comparable<T>> {

    private T left;
    private T right;

    public Scale(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T getHeavier (){
        int compareResult = this.left.compareTo (this.right);

        if (compareResult == 0){
            return null;
        }

        if (compareResult > 0){
            return this.left;

        }else {
            return  this.right;

        }

       // return compareResult > 0 ? this.left : this.right;
    }
}
