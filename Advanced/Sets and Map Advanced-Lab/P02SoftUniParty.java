package LabSetsAndMapAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P02SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeSet<String> partyQuestSet = new TreeSet<>();

        String guest = scanner.nextLine();
        while (!guest.equals("PARTY")){

            partyQuestSet.add(guest);

            guest =scanner.nextLine();
        }

        String removeQuest = scanner.nextLine();
        while (!removeQuest.equals("END")){

            partyQuestSet.remove(removeQuest);

            removeQuest = scanner.nextLine();
        }

        System.out.println(partyQuestSet.size());
        partyQuestSet.forEach(person -> System.out.println(person));

    }
}
