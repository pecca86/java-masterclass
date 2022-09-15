package generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TeamDemo {

    public static void main(String[] args) {
        BaseballPlayer baseballPlayer = new BaseballPlayer("Homo-Olle");
        HockeyPlayer hockeyPlayer = new HockeyPlayer("Bob");
        PussyPlayer pussyPlayer = new PussyPlayer("Pekka");

        Team<PussyPlayer> cockers = new Team<>("Cockers");
//        cockers.addPlayer(baseballPlayer);
//        cockers.addPlayer(hockeyPlayer);
        cockers.addPlayer(pussyPlayer);

        System.out.println(cockers.getMemberCount());

        Team<HockeyPlayer> crocodiles = new Team<>("Crocodiles");
        Team<HockeyPlayer> kakkis = new Team<>("FC KakkaKlönts");
        Team<HockeyPlayer> fisarna = new Team<>("HC Fis");
        crocodiles.addPlayer(hockeyPlayer);

        Team<BaseballPlayer> homot = new Team<BaseballPlayer>("Homot");
        homot.addPlayer(baseballPlayer);

        crocodiles.announceMatchup(new Team<>("KakkaKlöntarna")); // Autoboxes into a HockeyTeam

        System.out.println(crocodiles.compareTo(kakkis));
        System.out.println(kakkis.compareTo(crocodiles));

        // === USING THE BUILT IN COLLECTIONS.SORT REQUIRES THE CLASS TO IMPLEMENT COMPARABLE
        List<Team<HockeyPlayer>> hockeyTeams = new ArrayList<>();
        hockeyTeams.add(kakkis);
        hockeyTeams.add(crocodiles);
        hockeyTeams.add(fisarna);
        System.out.println(hockeyTeams);

        kakkis.increaseGamesPlayed();
        kakkis.increaseGamesPlayed();
        crocodiles.increaseGamesPlayed();
        crocodiles.increaseGamesPlayed();

        // Sorts according to games played
        Collections.sort(hockeyTeams);
        System.out.println(hockeyTeams);



    }
}
