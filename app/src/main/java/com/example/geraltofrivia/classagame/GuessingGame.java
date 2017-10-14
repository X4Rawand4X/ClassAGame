package com.example.geraltofrivia.classagame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class GuessingGame extends AppCompatActivity {

    TextView NumberOfTries;
    EditText UserInput;
    Button Submit;
    Button Reset;
    ImageView Up;
    ImageView Down;

    int RandomNumber;
    int NoOfTries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guessing_game);

        GenerateRandom();

        NumberOfTries = (TextView) findViewById(R.id.NomberOfTries);
        UserInput = (EditText) findViewById(R.id.UserInput);
        Submit = (Button) findViewById(R.id.SubmitButton);
        Reset = (Button) findViewById(R.id.ResetButton);
        Up = (ImageView) findViewById(R.id.UpArrow);
        Down = (ImageView) findViewById(R.id.DownArrow);
        NoOfTries = 0;


    }


    public void onCheck(View view) {

        String ValueUserInput = UserInput.getText().toString();
        Up.setImageResource(R.drawable.ic_arrow_upward_black_24dp);
        Down.setImageResource(R.drawable.ic_arrow_downward_black_100dp);

        if (Integer.valueOf(ValueUserInput) > RandomNumber) {
            Down.setImageResource(R.drawable.ic_arrow_downward_red_100dp);
            NoOfTries++;
            NumberOfTries.setText("You tried ( " + NoOfTries + " ) times ");
        } else if (Integer.valueOf(ValueUserInput) < RandomNumber) {
            Up.setImageResource(R.drawable.ic_arrow_upward_red_24dp);
            NoOfTries++;
            NumberOfTries.setText("You tried ( " + NoOfTries + " ) times ");

        } else {
            NumberOfTries.setText("You Won, with ( " + NoOfTries + " ) times ");
        }
        UserInput.setText("");
    }

    public void onReset(View view) {
        NumberOfTries.setText("You tried ( 0 ) times ");
        NoOfTries = 0;
        GenerateRandom();
        Up.setImageResource(R.drawable.ic_arrow_upward_black_24dp);
        Down.setImageResource(R.drawable.ic_arrow_downward_black_100dp);
        UserInput.setText("");
    }

    public void GenerateRandom() {
        RandomNumber = 1 + (int) (Math.random() * 100);
    }


}
