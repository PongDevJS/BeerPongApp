package com.pongdev.pongdev;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.*;

public class StartScreen extends AppCompatActivity {

    String teamName, player1Name, player2Name;
    ArrayList<Team> teamsArray;

    EditText teamNameText, player1Text, player2Text;

    Button addTeamBTN, startBTN;

    String teamsString;

    TextView teamsList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

        teamNameText = findViewById(R.id.teamNamePT);
        player1Text = findViewById(R.id.player1TB);
        player2Text = findViewById(R.id.player2TB);
        this.teamsArray = new ArrayList<>();
        addTeamBTN = findViewById(R.id.addTeamBTN);
        startBTN = findViewById(R.id.startBTN);
        teamsList = findViewById(R.id.teamsList);
        teamsString = "";
        teamsList.setMovementMethod(new ScrollingMovementMethod());

        addTeamBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(teamsArray.size() < 16) {
                    teamName = teamNameText.getText().toString();
                    player1Name = player1Text.getText().toString();
                    player2Name = player2Text.getText().toString();
                    Team newTeam = new Team(teamName, player1Name, player2Name);
                    teamsArray.add(newTeam);
                    teamsString += " " + newTeam.getName() + "\n";
                    teamsList.setText(teamsString);
                }

                if (teamsArray.size() == 15){
                    addTeamBTN.setEnabled(false);
                    addTeamBTN.setText(R.string.full_tournament);
                }
            }
        });

        startBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startTournament(view);
            }
        });
    }

    public void startTournament(View view){
        Intent intent = new Intent(this, MatchScreen.class);
        intent.putExtra("teamsList", this.teamsArray);
        startActivity(intent);

    }

}
