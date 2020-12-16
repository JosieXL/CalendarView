package com.example.calendarviewapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    CalendarView calendarView;
    TextView showDate, showWeek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendarView = (CalendarView) findViewById(R.id.calendarView);
        showDate = (TextView) findViewById(R.id.showDate);
        showWeek = (TextView) findViewById(R.id.showWeek);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date = dayOfMonth + "/" + (month + 1) + "/" + year;
                showDate.setText(date);

                Calendar cal = Calendar.getInstance();
                cal.set(year, month, dayOfMonth);
                int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
                String week = "";
                switch (dayOfWeek) {
                    case 1:
                        week = "Sunday";
                        break;
                    case 2:
                        week = "Monday";
                        break;
                    case 3:
                        week = "Tuesday";
                        break;
                    case 4:
                        week = "Wednesday";
                        break;
                    case 5:
                        week = "Thursday";
                        break;
                    case 6:
                        week = "Friday";
                        break;
                    case 7:
                        week = "Saturday";
                        break;
                }
                showWeek.setText(week);
            }
        });
    }
}