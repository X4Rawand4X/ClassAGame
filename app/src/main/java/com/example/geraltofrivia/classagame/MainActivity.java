package com.example.geraltofrivia.classagame;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.TicTaeTo.Mohammed;

public class MainActivity extends AppCompatActivity {

    Button btnMiran2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMiran2 = (Button) findViewById(R.id.btnMiran2);
    }

    //////////////////////////////////////////////////////
    public void btnMiran1(View view) {
        Intent intentMiran = new Intent(this, MiransActivity.class);
        startActivity(intentMiran);
    }
///////////////////////////////////////////////////////////////////////


    public void btnMohammed(View view)
    {
        Intent intent = new Intent(this,Mohammed.class);
        startActivity(intent);

    }
}
