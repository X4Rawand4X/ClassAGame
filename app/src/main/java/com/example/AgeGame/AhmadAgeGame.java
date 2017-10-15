package com.example.AgeGame;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.example.geraltofrivia.classagame.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AhmadAgeGame extends AppCompatActivity {
    EditText edittext;
    Button cal;
    TextView theAge;

    private void updateLabel() {
        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        edittext.setText(sdf.format(myCalendar.getTime()));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ahmad_age_game);

        edittext = (EditText) findViewById(R.id.Birthday);
        cal = (Button) findViewById(R.id.caculate);
        theAge = (TextView) findViewById(R.id.theAge);
        edittext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                new DatePickerDialog(AhmadAgeGame.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int year = myCalendar.getInstance().get(Calendar.YEAR);
                int month = myCalendar.getInstance().get(Calendar.MONTH);
                int day = myCalendar.getInstance().get(Calendar.DAY_OF_MONTH);

                day = (day - myCalendar.get(Calendar.DAY_OF_MONTH)) + 30;
                month = (((month - myCalendar.get(Calendar.MONTH)) - 1) + 12) + (day / 30);
                year = ((year - myCalendar.get(Calendar.YEAR)) - 1) + (month / 12);

                theAge.setText("\t\t\t\t\t\t\t\t\t\tYou are: " + "\n\nYear: " + year + " \tMonth: " + month % 12 + " Day: " + day % 30 + "\n\n\t\t\t\t\t\t\t\t\t\tYears old");
            }
        });
    }

    Calendar myCalendar = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {

            // TODO Auto-generated method stub
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }
    };
}
