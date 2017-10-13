package com.example.TicTaeTo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.geraltofrivia.classagame.R;
import com.example.TicTaeTo.*;

public class Mohammed extends AppCompatActivity {

    private Button pvp,pvc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mohammed);
        pvp = (Button) findViewById(R.id.pvp);
        pvc = (Button)findViewById(R.id.pvc);
    }
    public void onClick(View view)
    {
        if(view==pvp)
        {
            Toast.makeText(this,"PVP", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,PlayerVsPlayer.class);
            startActivity(intent);
        }
        else if(view==pvc)
        {
            Toast.makeText(this,"Player Vs Computer",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,PlayerVsComputer.class);
            startActivity(intent);
        }

    }


}