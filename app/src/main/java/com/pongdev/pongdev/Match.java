package com.pongdev.pongdev;

/**
 * Created by jacob on 11/9/17.
 */

public class Match {
    //Attributes
    private Team team1, team2, winner;


    //Constructor
    public Match(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
    }

    public Match(Team team1){
        this.team1 = team1;
        this.team2 = null;
    }

    public Match(){
        this.team1 = null;
        this.team2 = null;
    }

    public void addTeamToMatch(Team team2){
        this.team2 = team2;
    }


    //Setters
    public void setWinner(Team team) {
        this.winner = team;
    }


    //Getters
    public Team getWinner() {
        return this.winner;
    }

    /**
     * Checks if a given team is set.
     * @param team 1 or 2.
     * @return True if set, false if not set or invalid param.
     */
    public boolean isSet(int team) {
        switch (team) {
            case 1:
                return this.team1 != null;

            case 2:
                return this.team2 != null;

            default:
                return false;
        }
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        if (team2 != null){
            str.append("match: ")
                    .append("\n")
                    .append(this.team1.toString())
                    .append("\t")
                    .append(this.team2.toString());
        } else {
            str.append("match: ")
                    .append("\n")
                    .append(this.team1.toString());
        }

        return new String(str);

    }

    public Team getTeam1(){
        return this.team1;
    }

    public Team getTeam2(){
        return this.team2;
    }

    //Setters
    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }
}
