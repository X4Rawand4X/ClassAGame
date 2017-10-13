package com.example.geraltofrivia.classagame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MiransActivity extends AppCompatActivity {

    Button randBtn;
    TextView randNumberTxt;
    TextView randNumberTxt2;
    TextView betWon;
    EditText getBetN;
    Random randNum1 = new Random();
    String betNumber;

    int randomNumber1;
    int randomNumber2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mirans);
        randNumberTxt = (TextView) findViewById(R.id.randNumberTxt);
        randNumberTxt2 = (TextView) findViewById(R.id.randNumberTxt2);
        betWon = (TextView) findViewById(R.id.betWon);
        randBtn =(Button) findViewById(R.id.randBtn);
        getBetN =(EditText) findViewById(R.id.getBetN);
        randBtn.setOnClickListener(generate);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
/////////////////////////////////////////////////////////////////////////////////////////


    View.OnClickListener generate = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.randBtn:
                     randomNumber1 = (randNum1.nextInt(6) +1 ) ;
                     randomNumber2 = (randNum1.nextInt(6) +1 ) ;
                    randNumberTxt.setText(String.valueOf(randomNumber1));
                    randNumberTxt2.setText(String.valueOf(randomNumber2));

                    betNumber =getBetN.getText().toString();

                    int betNumberInteger = Integer.parseInt(betNumber);

                    int number1 = betNumberInteger + 10;
                    int number2= betNumberInteger - 10 ;
                    if(randomNumber1 > randomNumber2){
                        betWon.setText("" +number1);
                        break;
                    }else {
                        betWon.setText( "" + number2);
                    }
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