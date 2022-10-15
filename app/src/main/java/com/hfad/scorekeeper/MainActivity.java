package com.hfad.scorekeeper;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 *  MainActivity.java - ScoreKeeper
 *  This program represents the role of a scorekeeper at a sporting event
 *  in which the score is tracked on a scoreboard.
 *  This application possesses the ability to run on Android devices
 *  with an application programming interface (API) of at least 21.
 *
 *  @author Joseph Traglia
 *
 */

public class MainActivity extends AppCompatActivity {

    //Fields
    private int awayScore = 0;
    private int homeScore = 0;
    private String awayName = "";
    private String homeName = "";

    //Keys for use with the bundle
    public static final String AWAY_NAME = "Away";
    public static final String HOME_NAME = "Home";
    public static final String AWAY_SCORE = "1";
    public static final String HOME_SCORE = "0";

    /**
     * Main program that builds and displays the application on the device's screen.
     * @param savedInstanceState default parameter used to save the application's data
     *                           once the screen has been rotated to landscape mode.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Setting the content view to be displayed on the device.
        setContentView(R.layout.activity_main);

        //Initialize the TextViews for the home and away team
        TextView tvAwayTeam = findViewById(R.id.tvAwayTeam);
        TextView tvHomeTeam = findViewById(R.id.tvHomeTeam);

        //Initialize the TextViews for the home and away team's score.
        TextView tvAwayScore = findViewById(R.id.tvAwayScore);
        TextView tvHomeScore = findViewById(R.id.tvHomeScore);

        //Initialize the Buttons to add to the home and away team's score.
        Button btnAway = findViewById(R.id.btnAway);
        Button btnHome = findViewById(R.id.btnHome);

        //If savedInstanceState is not null, restore the previous state of the program.
        if (savedInstanceState != null)
        {
            //Restore the properties within the bundle.
            awayName = savedInstanceState.getString(AWAY_NAME);
            tvAwayTeam.setText(awayName);

            homeName = savedInstanceState.getString(HOME_NAME);
            tvHomeTeam.setText(homeName);

            awayScore = savedInstanceState.getInt(AWAY_SCORE);
            tvAwayScore.setText("" + awayScore);

            homeScore = savedInstanceState.getInt(HOME_SCORE);
            tvHomeScore.setText("" + homeScore);
        }

        btnAway.setOnClickListener(new View.OnClickListener() {
            /**
             * Method utilized to provide functionality to the away score button,
             * which adds 1 point to the score of the away team.
             * @param view default parameter.
             */
            @Override
            public void onClick(View view) {
                awayScore++;
                tvAwayScore.setText("" + awayScore);
                awayName = tvAwayTeam.getText().toString();
            }
        });

        /**
         * Method utilized to provide functionality to the home score button,
         * which adds 1 point to the score of the home team.
         * @param view default parameter.
         */
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeScore++;
                tvHomeScore.setText("" + homeScore);
                homeName = tvHomeTeam.getText().toString();
            }
        });
    }

    /**
     * Method utilized to save the current state of the application's essential data.
     * The implementation of this method ensures no data loss when the application
     * loses the current focus of the device.
     * @param savedInstanceState default parameter used to save the application's data.
     */
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState)
    {
        super.onSaveInstanceState(savedInstanceState);

        //Save the current state of the activities' special properties
        savedInstanceState.putString(AWAY_NAME, awayName);
        savedInstanceState.putString(HOME_NAME, homeName);
        savedInstanceState.putInt(AWAY_SCORE, awayScore);
        savedInstanceState.putInt(HOME_SCORE, homeScore);
    }
}