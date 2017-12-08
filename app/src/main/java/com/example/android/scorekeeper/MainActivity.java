package com.example.android.scorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Saves the scores of both teams in case of changing activity
    static final String STATE_SCORE_A = "scoreTeamA";
    static final String STATE_SCORE_B = "scoreTeamB";
    static final String STATE_FOULS_A = "foulsTeamA";
    static final String STATE_FOULS_B = "foulsTeamB";
    //Tracks the score for Team A
    int scoreTeamA = 0;
    //Tracks the score for Team B
    int scoreTeamB = 0;
    // Tracks the fouls for Team A
    int foulsTeamA = 0;
    // Tracks the fours for Team B
    int foulsTeamB = 0;

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current game state
        savedInstanceState.putInt(STATE_SCORE_A, scoreTeamA);
        savedInstanceState.putInt(STATE_SCORE_B, scoreTeamB);
        savedInstanceState.putInt(STATE_FOULS_A, foulsTeamA);
        savedInstanceState.putInt(STATE_FOULS_B, foulsTeamB);
        super.onSaveInstanceState(savedInstanceState);
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);
        // Restore state members from saved instance
        scoreTeamA = savedInstanceState.getInt(STATE_SCORE_A);
        scoreTeamB = savedInstanceState.getInt(STATE_SCORE_B);
        foulsTeamA = savedInstanceState.getInt(STATE_FOULS_A);
        foulsTeamB = savedInstanceState.getInt(STATE_FOULS_B);
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displayFoulsTeamA(foulsTeamA);
        displayFoulsTeamB(foulsTeamB);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Displays the given score for Team A.
    public void displayForTeamA(int score) {
        TextView scoreView = findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    // Displays the given score for Team B.
    public void displayForTeamB(int score) {
        TextView scoreView = findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    // Displays the given fouls for Team A.
    public void displayFoulsTeamA(int fouls) {
        TextView foulsView = findViewById(R.id.fouls_score_team_a);
        foulsView.setText(String.valueOf(fouls));
    }

    // Displays the given fouls for Team B.
    public void displayFoulsTeamB(int fouls) {
        TextView foulsView = findViewById(R.id.fouls_score_team_b);
        foulsView.setText(String.valueOf(fouls));
    }

    // This method is called when the +3 Points/TeamA button is clicked.
    public void addThreeForTeamA(View view) {
        scoreTeamA += 3;
        displayForTeamA(scoreTeamA);
    }

    // This method is called when the +3 Points/TeamB button is clicked.
    public void addThreeForTeamB(View view) {
        scoreTeamB += 3;
        displayForTeamB(scoreTeamB);
    }

    // This method is called when the +2 Points/TeamA button is clicked.
    public void addTwoForTeamA(View view) {
        scoreTeamA += 2;
        displayForTeamA(scoreTeamA);
    }

    // This method is called when the +2 Points/TeamB button is clicked.
    public void addTwoForTeamB(View view) {
        scoreTeamB += 2;
        displayForTeamB(scoreTeamB);
    }

    // This method is called when the Free Throw/Team A button is clicked.
    public void addOneForTeamA(View view) {
        scoreTeamA += 1;
        displayForTeamA(scoreTeamA);
    }

    // This method is called when the Free Throw/Team B button is clicked.
    public void addOneForTeamB(View view) {
        scoreTeamB += 1;
        displayForTeamB(scoreTeamB);
    }

    // This method is called when the Fouls/Team A button is clicked.
    public void addFoulsForTeamA(View view) {
        foulsTeamA += 1;
        displayFoulsTeamA(foulsTeamA);
    }

    // This method is called when the Fouls/Team B button is clicked.
    public void addFoulsForTeamB(View view) {
        foulsTeamB += 1;
        displayFoulsTeamB(foulsTeamB);
    }

    // This method is called when the Reset button is clicked.
    public void resetScore(View view) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        foulsTeamA = 0;
        foulsTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displayFoulsTeamA(foulsTeamA);
        displayFoulsTeamB(foulsTeamB);
    }

}
