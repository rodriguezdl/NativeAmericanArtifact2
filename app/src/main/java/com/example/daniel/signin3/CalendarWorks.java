package com.example.daniel.signin3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Button;
import android.widget.Toast;

public class CalendarWorks extends AppCompatActivity {

    DatePicker simpleDatePicker;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_works);
        simpleDatePicker = (DatePicker) findViewById(R.id.date);
        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String day = "Day = " + simpleDatePicker.getDayOfMonth();
                String month = "Month = " + (simpleDatePicker.getMonth() + 1);
                String year = "Year = " + simpleDatePicker.getYear();
                Toast.makeText(getApplicationContext(), "Artifacts collection event"+ "\n"+"\n" + month + "\n" + day + "\n" + year, Toast.LENGTH_LONG).show();
            }
        });
    }
}
