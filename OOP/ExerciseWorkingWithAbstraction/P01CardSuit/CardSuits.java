package ExerciseWorkingWithAbstraction.P01CardSuit;

public enum CardSuits {
    CLUBS(0),
    DIAMONDS(1),
    HEARTS(2),
    SPADES(3);

    private int ordinal;


    CardSuits(int ordinal) {
        this.ordinal = ordinal;
    }
}
