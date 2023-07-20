package ExerciseWorkingWithAbstraction.P03CardsWithPower;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);

        RankCards rankCards = RankCards.valueOf(scanner.nextLine());
        SuitCards suitCards = SuitCards.valueOf(scanner.nextLine());

        Card card = new Card(rankCards,suitCards);
        System.out.printf("Card name: %s of %s; Card power: %d", rankCards.name(),suitCards.name(),card.getPower());



        RankCards rankCards1 = RankCards.valueOf(scanner.nextLine());
        SuitCards suitCards1 = SuitCards.valueOf(scanner.nextLine());

        Card card1 = new Card(rankCards1,suitCards1);
    }
}

