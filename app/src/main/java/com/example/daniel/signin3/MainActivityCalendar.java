package com.example.daniel.signin3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivityCalendar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_calendar);
        Buttons();
    }

    public void Buttons() {
        findViewById(R.id.calendar).setOnClickListener(buttonClickListener);
    }

    private View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.calendar:
                    startActivity(new Intent(MainActivityCalendar.this, CalendarWorks.class));
                    break;
            }
        }
    };

}
