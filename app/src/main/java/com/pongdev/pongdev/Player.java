package com.pongdev.pongdev;

import java.io.Serializable;

/**
 * Created by jacob on 11/9/17.
 */

public class Player implements Serializable {
    //Attributes
    private String name;


    //Constructor
    public Player(String name) {
        this.name = name;
    }


    //Getters
    public String getName() {
        return this.name;
    }


    @Override
    public String toString() {
        return this.name;
    }
}
