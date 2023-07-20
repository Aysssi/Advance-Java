package ExerciseWorkingWithAbstraction.P03CardsWithPower;

public enum SuitCards {
    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    int power;

    SuitCards(int power) {
        this.power= power;
    }

    public int getPower() {
        return power;
    }
}
