package com.example.AgeGame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.geraltofrivia.classagame.R;

public class Ahmad extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ahmad);
    }


    public void GoToPlay(View view) {
        Intent ahmadIntent= new Intent(this, AhmadAgeGame.class);
        startActivity(ahmadIntent);
    }
}
