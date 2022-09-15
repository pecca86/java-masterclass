package generics;

import java.util.ArrayList;
import java.util.List;

public class Team<T extends Player> implements Comparable<Team<T>> {
    private String teamName;
    private int playedGames = 0;

    private List<T> members = new ArrayList<>();

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void addPlayer(T t) {
        this.members.add(t);
        System.out.println(t.getName() + " added to " + this.teamName);
    }

    public int getPlayedGames() {
        return playedGames;
    }

    public void increaseGamesPlayed() {
        this.playedGames++;
    }

    public int getMemberCount() {
        return this.members.size();
    }

    public void announceMatchup(Team<T> opponent) {
        System.out.println(opponent.getTeamName() + " vs. " + this.teamName);
        increaseGamesPlayed();
    }

    @Override
    public int compareTo(Team<T> o) {
        if (this.getPlayedGames() == o.getPlayedGames()) {
            return 0;
        } else if (this.getPlayedGames() > o.getPlayedGames()) {
            return -1;
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamName='" + teamName + '\'' +
                ", playedGames=" + playedGames +
                '}';
    }
}
