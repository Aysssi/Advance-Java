package ExercisesEncapsulation.P05FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        setName(name);
        this.players = new ArrayList<>();
    }

    private void setName(String name) {
        validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(String playerName) {
        int toRemoveIndex = -1;
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getName().equals(playerName)) {
                toRemoveIndex = i;
                break;
            }
        }

        if (toRemoveIndex == -1) {
            throw new IllegalArgumentException("Player " + playerName + " is not in " + getName() + " team.");
        }

        players.remove(toRemoveIndex);
    }

    public double getRating() {
        return Math.round(players.stream().mapToDouble(Player::overallSkillLevel).average().orElse(0));
    }


    public static void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
    }
}

