package com.pongdev.pongdev;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by jacob on 11/9/17.
 */

public class Team implements Serializable{
    //Attributes
    private String name;
    private Player player1, player2;


    //Constructor
    public Team(String teamName, String playerName1, String playerName2) {
        this.name = teamName;
        this.player1 = new Player(playerName1);
        this.player2 = new Player(playerName2);
    }


    //Getters
    public String getName() {
        return this.name;
    }


    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        str.append(this.name)
                .append("\n")
                .append(this.player1.toString())
                .append("\t")
                .append(this.player2.toString());

        return new String(str);
    }
}
