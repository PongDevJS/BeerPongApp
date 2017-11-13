package com.pongdev.pongdev;

import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jacob on 11/9/17.
 */

public class Tournament implements Serializable {
    //Attributes
    private int numTeams, numOfRounds, currentRound, roundOneCali, firstRoundMatches, secondRoundMatches;
    private boolean secondRoundSingleMatch;
    private ArrayList<Team> teams;
    private ArrayList<Round> rounds;
    private Round firstRound;
    private Round secondRound;
    private int teamIndex = 0;

    //Constructor
    public Tournament() {
        this.teams = new ArrayList();
        this.rounds = new ArrayList();
    }

    public Tournament(ArrayList<Team> teams) {
        this.teams = teams;
        this.rounds = new ArrayList();
    }

    //Add, remove and access teams
    public boolean addTeam(Team team) {
        if (this.getTeams().size() < 16) {
            this.getTeams().add(team);
            return true;
        }

        return false;
    }

    public void removeTeam(String teamName) {
        for (int i = 0; i < this.getTeams().size(); i++) {
            if (this.getTeams().get(i).getName().equals(teamName)) {
                this.getTeams().remove(i);
                break;
            }
        }
    }

    public Team getLatestTeam() {
        return this.getTeams().get(this.getTeams().size() - 1);
    }

    //Starting tournament and stuff
    public void startTournament() {
        this.numTeams = getTeams().size();
        if (numTeams > 8) {
            numOfRounds = 4;
            firstRoundMatches = numTeams - 8;
            this.secondRoundMatches = 4;
        } else if (numTeams <= 8 && numTeams > 4) {
            numOfRounds = 3;
            firstRoundMatches = numTeams - 4;
            secondRoundMatches = 2;
        } else if (numTeams == 4) {
            numOfRounds = 2;
            firstRoundMatches = 2;
            secondRoundMatches = 1;
        } else {
            numOfRounds = 0;
            firstRoundMatches = 0;
            secondRoundMatches = 0;

        }

        firstRound = new Round();
        secondRound = new Round();
        secondRoundSingleMatch = numTeams % 2 == 0;


        createFirstRound();


        for (int i = 0; i < 4; i++) {
            if (getTeams().size() - teamIndex == 1) {
                secondRound.addSingleTeamMatch(getTeams().get(teamIndex));
                Log.d("single round: ", String.valueOf(teamIndex));
            } else {
                Log.d("double round: ", String.valueOf(teamIndex));
                secondRound.addMatch(getTeams().get(teamIndex), getTeams().get(teamIndex + 1));
                teamIndex += 2;

            }

        }

        //Find the number of rounds (maybe add check for at least 3 or 4 teams idk)
//        if (this.teams.size() <= 4) {
//            this.numOfRounds = 2;
//            this.roundOneCali = 2;
//
//        } else if (this.teams.size() > 4 && this.teams.size() <= 8) {
//            this.numOfRounds = 3;
//            this.roundOneCali = 4;
//
//        } else if (this.teams.size() > 8 && this.teams.size() <= 16) {
//            this.numOfRounds = 4;
//            this.roundOneCali = 8;
//        }
//
//
//        //Add the rounds to this tournament
//        for (int i = 0; i < this.numOfRounds; i++) {
//            this.rounds.add(new Round());
//        }
    }

    private void createFirstRound() {

        for (int i = 0; i < firstRoundMatches; i++) {
            firstRound.addMatch(getTeams().get(teamIndex), getTeams().get(teamIndex + 1));
            teamIndex += 2;
        }
    }

    public void printRounds() {
        System.out.println("FIRST ROUND:");
        System.out.println(firstRound.getAllMatches().toString());
        System.out.println("SECOND ROUND:");
        System.out.println(secondRound.getAllMatches().toString());
    }

    //Proceed with the rounds
    public void proceedTournament() {

        //First setup matches for the round
        //for (int i = 1; i < )
    }

    public boolean isTournamentFull(){
        return teams.size() == 15;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public Round getFirstRound(){
        return this.firstRound;
    }
}
