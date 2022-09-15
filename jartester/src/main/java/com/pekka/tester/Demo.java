package com.pekka.tester;

import generics.HockeyPlayer;
import generics.Team;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Trying to import own library (generics) to new project
 */
public class Demo {

    public static void main(String[] args) {
        Team<HockeyPlayer> myTeam = new Team<>("Fuck cocks");
        myTeam.addPlayer(new HockeyPlayer("Fuck boy"));

        Team<HockeyPlayer> pekkers = new Team<>("Peckers");
        pekkers.addPlayer(new HockeyPlayer("Timothy"));

        List<Team<HockeyPlayer>> hockeyTeams = new ArrayList<>();
        hockeyTeams.add(myTeam);
        hockeyTeams.add(pekkers);
        System.out.println(hockeyTeams);
        pekkers.increaseGamesPlayed();
        Collections.sort(hockeyTeams);
        System.out.println(hockeyTeams);

    }
}
