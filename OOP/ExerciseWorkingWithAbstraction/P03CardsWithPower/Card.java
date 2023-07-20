package ExerciseWorkingWithAbstraction.P03CardsWithPower;

public class Card {
    private RankCards rankCards;
    public SuitCards suitCards;

    public Card(RankCards rankCards, SuitCards suitCards) {
        this.rankCards = rankCards;
        this.suitCards = suitCards;
    }

    public int getPower(){
        return rankCards.getPower() + suitCards.getPower();
    }
}
