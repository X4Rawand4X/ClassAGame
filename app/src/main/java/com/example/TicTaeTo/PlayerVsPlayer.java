package com.example.TicTaeTo;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.example.TicTaeTo.GameEngine;
import com.example.geraltofrivia.classagame.R;

public class PlayerVsPlayer extends AppCompatActivity {

    Button[][] buttons;
    GameEngine check;
    char playTurn = 'X';
    TextView turn;
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
            for(int j=0; j<buttons.length; j++)
            {
                if(view==buttons[i][j])
                {
                    if(buttons[i][j].getText().toString().equals(""))
                    {
                        if(playTurn=='X')
                        {
                            buttons[i][j].setText("X");
                            mp = MediaPlayer.create(this,R.raw.writex);
                            mp.start();


                            playTurn = 'O';
                            turn.setText("O");
                            check.setButtons(buttons);
                            if(check.isWin())
                            {

                                showAlert("X");

                                break;
                            }
                            else if(check.isDraw())
                            {
                                Toast.makeText(getApplicationContext(),"Its a Tie Sit Down!",Toast.LENGTH_LONG).show();
                                Toast.makeText(this,"Playing Again....",Toast.LENGTH_LONG).show();
                                buttons = check.clear();
                            }
                        }
                        else if(playTurn=='O')
                        {
                            buttons[i][j].setText("O");
                            mp = MediaPlayer.create(this,R.raw.writeo);
                            mp.start();


                            playTurn = 'X';
                            turn.setText("X");
                            check.setButtons(buttons);
                            if(check.isWin())
                            {
                                showAlert("O");
                                break;
                            }
                        }


                        if(check.isDraw())
                        {
                            Toast.makeText(getApplicationContext(),"Its a Tie Sit Down!",Toast.LENGTH_LONG).show();
                            Toast.makeText(this,"Playing Again....",Toast.LENGTH_LONG).show();
                            buttons = check.clear();

                        }

                    }
                }

            }
        }

    }

    public  void showAlert(String winner)
    {
        mp = MediaPlayer.create(this,R.raw.win);

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
//                                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
//                                startActivity(intent);
                            }
                        }
                ).show();
    }
}