package com.example.android.scorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    // Saves the scores and names of both teams in case of changing activity
    static final String STATE_SCORE_A = "scoreTeamA";
    static final String STATE_SCORE_B = "scoreTeamB";
    static final String STATE_FOULS_A = "foulsTeamA";
    static final String STATE_FOULS_B = "foulsTeamB";
    static final String STATE_TEAM_A = "teamANameView";
    static final String STATE_TEAM_B = "teamBNameView";
    // Tracks the name view for the Team A
    EditText teamANameView;
    // Tracks the name view for the Team B
    EditText teamBNameView;
    //Tracks the points score for Team A
    int scoreTeamA = 0;
    //Tracks the points score for Team B
    int scoreTeamB = 0;
    // Tracks the fouls score for Team A
    int foulsTeamA = 0;
    // Tracks the fouls score for Team B
    int foulsTeamB = 0;
    // Tracks the points score view for Team A
    TextView teamAScoreView;
    // Tracks the points score view for Team B
    TextView teamBScoreView;
    // Tracks the fouls score view for Team A
    TextView teamAFoulsView;
    // Tracks the fouls score view for Team B
    TextView teamBFoulsView;

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current game state
        // Save the name of the team A
        savedInstanceState.putString(STATE_TEAM_A, teamANameView.getText().toString());
        // Save the name of the team B
        savedInstanceState.putString(STATE_TEAM_B, teamBNameView.getText().toString());
        // Save the score for the team A
        savedInstanceState.putInt(STATE_SCORE_A, scoreTeamA);
        // Save the score for the team B
        savedInstanceState.putInt(STATE_SCORE_B, scoreTeamB);
        // Save the fouls for the team A
        savedInstanceState.putInt(STATE_FOULS_A, foulsTeamA);
        // Save the fouls for the team B
        savedInstanceState.putInt(STATE_FOULS_B, foulsTeamB);
        super.onSaveInstanceState(savedInstanceState);
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Call the superclass to restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);
        // Restore state members from saved instance
        // Restore the name of the team A
        teamANameView.setText(savedInstanceState.getString(STATE_TEAM_A));
        // Restore the name of the team B
        teamBNameView.setText(savedInstanceState.getString(STATE_TEAM_B));
        // Restore the score of the team A
        scoreTeamA = savedInstanceState.getInt(STATE_SCORE_A);
        // Restore the score of the team B
        scoreTeamB = savedInstanceState.getInt(STATE_SCORE_B);
        // Restore the fouls for the team A
        foulsTeamA = savedInstanceState.getInt(STATE_FOULS_A);
        // Restore the fouls for the team B
        foulsTeamB = savedInstanceState.getInt(STATE_FOULS_B);
        // Display the score for team A
        displayForTeamA(scoreTeamA);
        // Display the score for team B
        displayForTeamB(scoreTeamB);
        // Display the fouls for team A
        displayFoulsTeamA(foulsTeamA);
        // Display the fouls for team B
        displayFoulsTeamB(foulsTeamB);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initializes the name edit text for Team A
        teamANameView = findViewById(R.id.team_a_name);
        // Initializes the name edit text for Team B
        teamBNameView = findViewById(R.id.team_b_name);
        // Initializes the points score view for Team A
        teamAScoreView = findViewById(R.id.team_a_score);
        // Initializes the points score view for Team B
        teamBScoreView = findViewById(R.id.team_b_score);
        // Initializes the fouls score view for Team A
        teamAFoulsView = findViewById(R.id.fouls_score_team_a);
        // Initializes the fouls score view for Team B
        teamBFoulsView = findViewById(R.id.fouls_score_team_b);
    }

    // Displays the given score for Team A.
    public void displayForTeamA(int score) {
        teamAScoreView.setText(String.valueOf(score));
    }

    // Displays the given score for Team B.
    public void displayForTeamB(int score) {
        teamBScoreView.setText(String.valueOf(score));
    }

    // Displays the given fouls for Team A.
    public void displayFoulsTeamA(int fouls) {
        teamAFoulsView.setText(String.valueOf(fouls));
    }

    // Displays the given fouls for Team B.
    public void displayFoulsTeamB(int fouls) {
        teamBFoulsView.setText(String.valueOf(fouls));
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
        teamANameView.setText(null);
        teamBNameView.setText(null);
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