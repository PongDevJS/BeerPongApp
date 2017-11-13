package com.pongdev.pongdev;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MatchScreen extends AppCompatActivity {

    Button teamOneBTN, teamTwoBTN, nextMatchBTN;
    TournamentTest t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_screen);
        ArrayList<Team> teamsArray = (ArrayList<Team>) getIntent().getSerializableExtra("teamsList");

        t = new TournamentTest(teamsArray);
        t.startTournament();
        teamOneBTN = findViewById(R.id.teamOneBTN);
        teamTwoBTN = findViewById(R.id.teamTwoBTN);
        nextMatchBTN = findViewById(R.id.nextGameBTN);



        String team1 = t.getCurrentRound().getNextMatch().getTeam1().getName();
        String team2 = t.getCurrentRound().getNextMatch().getTeam2().getName();

        teamOneBTN.setText(team1);
        teamTwoBTN.setText(team2);

        nextMatchBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String team1 = t.getCurrentRound().getNextMatch().getTeam1().getName();
                String team2 = t.getCurrentRound().getNextMatch().getTeam2().getName();
                teamOneBTN.setText(team1);
                teamTwoBTN.setText(team2);
            }
        });


        teamOneBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmWinnerBox(new Team("10", "dkl", "dsklf"));
            }
        });
    }

    private void confirmWinnerBox(final Team team){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle("Confirm winner");
        builder.setMessage(String.format("Confirm %s as winner?", team.getName()));
        builder.setPositiveButton("Confirm",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //do nothing
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
