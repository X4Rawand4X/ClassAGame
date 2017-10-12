package com.example.geraltofrivia.classagame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MiransActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mirans);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
/////////////////////////////////////////////////////////////////////////////////////////

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