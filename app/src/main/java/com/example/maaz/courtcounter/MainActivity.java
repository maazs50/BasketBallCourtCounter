package com.example.maaz.courtcounter;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.app.Notification;
public class MainActivity extends AppCompatActivity {

    int scoreTeamA=0;
    int scoreTeamB=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayScore(scoreTeamA);
        displayScoreForB(scoreTeamB);

    }

    public void addThree(View v){
        scoreTeamA=scoreTeamA+3;
        displayScore(scoreTeamA);
        showDialog();
    }
    public void addTwo(View v){
        scoreTeamA=scoreTeamA+2;
        displayScore(scoreTeamA);
        showDialog();
    }
    public void addOne(View v){
        scoreTeamA=scoreTeamA+1; // increases the value score by 1 for team A
        displayScore(scoreTeamA);
        showDialog();
    }
    public void displayScore(int s){
        TextView scoreText=(TextView)findViewById(R.id.textView1);
        scoreText.setText(""+s);// sets the text of score board when called
    }
    public void addThreeForB(View v){
        scoreTeamB=scoreTeamB+3;
        displayScoreForB(scoreTeamB);
        showDialog();
    }
    public void addTwoForB(View v){
        scoreTeamB=scoreTeamB+2;
        displayScoreForB(scoreTeamB);
        showDialog();
    }
    public void addOneForB(View v){
        scoreTeamB=scoreTeamB+1;// increases the value score by 1 for team B
        displayScoreForB(scoreTeamB);
        showDialog();
    }

    public void displayScoreForB(int s){
        TextView scoreText=(TextView)findViewById(R.id.textView4);
        scoreText.setText(""+s); //sets the text of scoreBoard
    }

    public void Reset(View v){
        scoreTeamA=0;
        scoreTeamB=0;
        displayScoreForB(scoreTeamB);
        displayScore(scoreTeamA);

    }
    public void showDialog() {
        //Dialog should be declared inside a method

        if (scoreTeamA >= 50 || scoreTeamB >= 50) {
            AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
            alert.setTitle("Results");
            alert.setMessage("Congratulations!");
            if(scoreTeamA >= 50){
            alert.setMessage(" Team A Won");}
            else{
                alert.setMessage("Team B Won");
            }
            alert.setPositiveButton("Ok!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    onReset();


                }
            });
            alert.setNegativeButton("Exit", new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            alert.setNeutralButton("Cancel", new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    onReset();
                }
            });
            alert.create().show();
        }
        }
    public void onReset(){
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayScoreForB(scoreTeamB);
        displayScore(scoreTeamA);
    }


}
