package com.pongdev.pongdev;

import java.util.ArrayList;

/**
 * Created by jacob on 11/12/17.
 */

public class TournamentTest {

    //Attributes
    private int x, numOfTeams, currentRound, numOfRounds, numOfFirstRoundMatches, numOfSecondRoundEmptyMatches, numOfSecondRoundMatches, teamToGet;
    private boolean secondRoundSingleMatch;
    private ArrayList<Team> teams;
    private ArrayList<Round> rounds;


    //Constructor
    public TournamentTest() {
        this.teams = new ArrayList();
        this.rounds = new ArrayList();
    }

    public TournamentTest(ArrayList<Team> teams){
        this.teams = teams;
        this.rounds = new ArrayList();
    }


    //Add and remove teams
    public void addTeam(Team t) {
        if (this.teams.size() < 17) {
            this.teams.add(t);
        }
    }

    public void removeTeam(String teamName) {
        for (int i = 0; i < this.teams.size(); i++) {
            if (this.teams.get(i).getName().equals(teamName)) {
                this.teams.remove(i);
                break;
            }
        }
    }


    //Getters
    public ArrayList<Team> getTeams() {
        return this.teams;
    }

    public int getNumOfRounds() {
        return this.numOfRounds;
    }

    public int getNumOfSecondRoundMatches() {
        return this.numOfSecondRoundMatches;
    }

    public Round getRound(int r) {
        return this.rounds.get(r - 1);
    }


    //Starting tournament and stuff
    public void startTournament() {

        this.currentRound = 0;
        //Setting attributes given from the number of teams
        this.numOfTeams = this.teams.size();

        if (this.numOfTeams > 8 && this.numOfTeams < 17) {
            this.numOfRounds = 4;
            this.numOfSecondRoundMatches = 4;
            this.x = 8;

        } else if (this.numOfTeams > 4 && this.numOfTeams < 9) {
            this.numOfRounds = 3;
            this.numOfSecondRoundMatches = 2;
            this.x = 4;

        } else if (this.numOfTeams == 4) {
            this.numOfRounds = 2;
            this.numOfSecondRoundMatches = 1;
            this.x = 2;
        }

        for (int i = 0; i < this.numOfRounds; i++) {
            this.rounds.add(new Round());
        }

        this.numOfFirstRoundMatches = this.numOfTeams - this.x;
        this.secondRoundSingleMatch = this.numOfTeams % 2 != 0;

        //System.out.println("Number of first round matches: " + numOfFirstRoundMatches);
        //System.out.println("Second round single match: " + secondRoundSingleMatch);

        for (int i = 1; i < this.numOfFirstRoundMatches; i+=2) {
            this.numOfSecondRoundEmptyMatches++;
        }

        // System.out.println("Number of second round single matches: " + numOfSecondRoundEmptyMatches);


        //MARK: FIRST ROUND STUFF

        for (int i = 0; i < this.numOfFirstRoundMatches; i++) {
            this.rounds.get(0).addMatch();
            this.rounds.get(0).addTeamToMatch(i, this.getNextTeam());
            this.rounds.get(0).addTeamToMatch(i, this.getNextTeam());
        }


        int teamsSize = teams.size();
        // Should add the remaining teams after round one.
        for (int i = 0; i <= teamsSize; i++) {
            this.rounds.get(1).addMatch();
            //System.out.println("next team add to match : " + this.getNextTeam());
            this.rounds.get(1).addTeamToMatch(i, this.getNextTeam());
            this.rounds.get(1).addTeamToMatch(i, this.getNextTeam());

        }
//        //Setup first round matches
//        for (int i = 0; i < this.numOfFirstRoundMatches; i++) {
//            this.rounds.get(0).addMatch();
//            this.rounds.get(0).addTeamToMatch(i, this.teams.get(this.teamToGet));
//            this.rounds.get(0).addTeamToMatch(i, this.teams.get(this.teamToGet+1));
//            this.teamToGet += 2;
//        }
//
//        //Add the second round half-empty match
//        if (this.secondRoundSingleMatch) {
//            this.rounds.get(1).addMatch();
//            this.rounds.get(1).addTeamToMatch(this.numOfFirstRoundMatches - 1, this.teams.get(this.teamToGet));
//            this.teamToGet++;
//        }
//
//        //Fill the second round matches
//        for (int i = 0; i < (this.numOfSecondRoundMatches - this.numOfSecondRoundEmptyMatches - 1); i++) {
//            this.rounds.get(1).addMatch();
//            this.rounds.get(1).addTeamToMatch(i, this.teams.get(this.teamToGet));
//            this.rounds.get(1).addTeamToMatch(i, this.teams.get(this.teamToGet+1));
//            this.teamToGet += 2;
//        }

    }


    private Team getNextTeam() {
        if (!this.teams.isEmpty()) {
            Team returnTeam = this.teams.get(0);
            this.teams.remove(0);
            return returnTeam;
        }

        return null;
    }

    public Round getCurrentRound(){
        return this.rounds.get(currentRound);
    }

    public void proceedTournament() {
        this.currentRound++;
    }
}
