package com.example.TicTaeTo;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.geraltofrivia.classagame.R;

import java.util.Random;

public class PlayerVsComputer extends AppCompatActivity {
    Button[][] buttons;
    TextView turn;
    GameEngine check;
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board);
        buttons =new Button[3][3];
        buttons[0][0] = (Button) findViewById(R.id.b1);
        buttons[0][1] = (Button) findViewById(R.id.b2);
        buttons[0][2] = (Button) findViewById(R.id.b3);
        buttons[1][0] = (Button) findViewById(R.id.b4);
        buttons[1][1] = (Button) findViewById(R.id.b5);
        buttons[1][2] = (Button) findViewById(R.id.b6);
        buttons[2][0] = (Button) findViewById(R.id.b7);
        buttons[2][1] = (Button) findViewById(R.id.b8);
        buttons[2][2] = (Button) findViewById(R.id.b9);
        check = new GameEngine(buttons);
        turn = (TextView) findViewById(R.id.turn);

    }

    public void onClick(View view)
    {
        for(int i=0; i<buttons.length; i++)
        {
            for(int j=0; j<buttons[i].length; j++)
                if (view == buttons[i][j]) {
                    if (buttons[i][j].getText().toString().equals("")) {
                        turn.setText("O");
                        buttons[i][j].setText("X");
                        check.setButtons(buttons);
                        if (check.isWin()) {

                            showAlert("X", R.raw.win);
                            break;
                        }

                        if (check.isDraw()) {
                            Toast.makeText(this, "Its a Tie! Sit Down!", Toast.LENGTH_SHORT).show();
                            buttons = check.clear();
                            break;
                        }
                        ///// the following code is to return two indexes for the
                        /// computer user to place the O on the board

                        check.setButtons(buttons);

                        Runnable r = new Runnable() {
                            @Override
                            public void run() {

                                int imp2;
                                int imp1;
                                Random rand = new Random();
                                /////check if both return move index is available for attack and defense

                                if (check.computerMove("OO")[0] != -1 && check.computerMove("OO")[1] != -1) /// if two OOs are found
                                {
                                    //// setting O for attack
                                    imp1 = check.computerMove("OO")[0];
                                    imp2 = check.computerMove("OO")[1];
                                } else {
                                    if (check.computerMove("XX")[0] != -1 && check.computerMove("XX")[1] != -1) // if two XXs are found																/// then checking for the two consecutive Xs
                                    {
                                        imp1 = check.computerMove("XX")[0];
                                        imp2 = check.computerMove("XX")[1];
                                    }


                                    // if the code reaches here means there is no threat on me
                                    else { /// randomally chosing a box
                                        do {
                                            imp1 = rand.nextInt(3);
                                            imp2 = rand.nextInt(3);
                                        }
                                        while (!buttons[imp1][imp2].getText().toString().equals(""));

                                    }
                                }
                                buttons[imp1][imp2].setText("O");
                                turn.setText("X");
                                ///// again setting the new buttons to prepare for next Tests
                                check.setButtons(buttons);
                                // checking for the winner again after setting O
                                if (check.isWin()) {
                                    showAlert("O", R.raw.loss);
                                } else {
                                    ///// again checking for draw after setting O
                                    if (check.isDraw()) {
                                        Toast.makeText(getApplicationContext(), "Its a Tie! Sit Down!", Toast.LENGTH_SHORT).show();
                                        buttons = check.clear();

                                    }
                                }

                            }
                        };

                        Handler h = new Handler();
                        h.postDelayed(r, 1000); // <-- the "1000" is the delay time in miliseconds.
                    }
                }
        }
    }
    public  void showAlert(String winner,int i)
    {
        mp = MediaPlayer.create(this,i);
        mp.start();
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage("Do you want to play again?")
                .setTitle(winner+" Won!")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                buttons = check.clear();
                            }
                        }
                )
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                finish();

                            }
                        }
                ).show();
    }

}