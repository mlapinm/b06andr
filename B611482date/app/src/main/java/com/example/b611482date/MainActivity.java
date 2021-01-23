package com.example.b611482date;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.squareup.timessquare.CalendarPickerView;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Date today = new Date();
        Calendar nextYear = Calendar.getInstance();
        nextYear.add(Calendar.YEAR, 1);
        CalendarPickerView datePicker = findViewById(R.id.calendar);
        datePicker.init(today, nextYear.getTime())
                .inMode(CalendarPickerView.SelectionMode.RANGE)
                .withSelectedDate(today);

        datePicker.setOnDateSelectedListener(new CalendarPickerView.OnDateSelectedListener() {
            @Override
            public void onDateSelected(Date date) {

                List<Date> list = datePicker.getSelectedDates();

                String selectedDate = DateFormat.getDateInstance(DateFormat.FULL).format(date);

                Calendar calSelected = Calendar.getInstance();
                calSelected.setTime(date);

                selectedDate = "" + calSelected.get(Calendar.DAY_OF_MONTH) + "."
                        + (calSelected.get(Calendar.MONTH) + 1) + "."
                        + calSelected.get(Calendar.YEAR) + "\n"
                        + calSelected.get(Calendar.DAY_OF_WEEK_IN_MONTH) + "\n"
                        + calSelected.get(Calendar.DAY_OF_WEEK) + "\n"
                        + "list length: " + list.size();

                Toast.makeText(MainActivity.this, selectedDate, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDateUnselected(Date date) {

            }
        });
    }
}