package com.pongdev.pongdev;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by jacob on 11/9/17.
 */

public class Round {
    //Attributes
    private ArrayList<Match> matches;
    private int currentMatch = 0;


    //Constructor
    public Round() {
        this.matches = new ArrayList();
    }


    //Add stuff
    public void addMatch(Team team1, Team team2) {
        this.matches.add(new Match(team1, team2));
    }

    //Add stuff
    public void addMatch() {
        this.matches.add(new Match());
    }

    public void addSingleTeamMatch(Team team1){
        this.matches.add(new Match(team1));
    }

    public void addEmptyMatch(){
        this.matches.add(new Match());
    }

    public ArrayList<Match> getAllMatches(){
        return matches;
    }

    public Match getNextMatch(){
        Log.d("Current match", String.valueOf(currentMatch));
        Log.d("Matches size", String.valueOf(matches.size()));
        Match returnMatch = matches.get(currentMatch);
        currentMatch++;
        return returnMatch;
    }

    /**
     * Checks if team1 is set, and sets it if not. Else same for team2.
     * @param match number of match in the round. Starts at 0.
     * @param t
     * @return True if a team was set. False if not.
     */
    public boolean addTeamToMatch(int match, Team t) {
        if (match < this.matches.size() && match >= 0) {

            if (!this.matches.get(match).isSet(1)) {
                this.matches.get(match).setTeam1(t);
                return true;

            } else if (!this.matches.get(match).isSet(2)) {
                this.matches.get(match).setTeam2(t);
                return true;
            }
            return false;
        }
        return false;
    }
}
