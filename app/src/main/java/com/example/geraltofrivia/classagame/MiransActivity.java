package com.example.geraltofrivia.classagame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MiransActivity extends AppCompatActivity {

    Button randBtn;
    TextView randNumberTxt;
    TextView randNumberTxt2;
    Random randNum1 = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mirans);
        randNumberTxt = (TextView) findViewById(R.id.randNumberTxt);
        randNumberTxt2 = (TextView) findViewById(R.id.randNumberTxt2);
        randBtn =(Button) findViewById(R.id.randBtn);
        randBtn.setOnClickListener(generate);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
/////////////////////////////////////////////////////////////////////////////////////////


    View.OnClickListener generate = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.randBtn:
                    int randomNumber1 = (randNum1.nextInt(6) +1 ) ;
                    int randomNumber2 = (randNum1.nextInt(6) +1 ) ;
                    randNumberTxt.setText(String.valueOf(randomNumber1));
                    randNumberTxt2.setText(String.valueOf(randomNumber2));

            }
        }
    };
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
//////////////////////////////////////////////////////////////////////