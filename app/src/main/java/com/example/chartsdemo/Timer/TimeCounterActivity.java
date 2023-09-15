package com.example.chartsdemo.Timer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.chartsdemo.R;

public class TimeCounterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_counter);

        TextView unlimitedTimerTxt = findViewById(R.id.time_counter_txt);
        TextView reverseTimerTxt = findViewById(R.id.reverse_time_counter_txt);

        UnlimitedTimer unlimitedTimer = new UnlimitedTimer(1000, unlimitedTimerTxt);
        ReverseTimer reverseTimer = new ReverseTimer(3600000, 1000, reverseTimerTxt); // 60 minutes (in milliseconds)

        unlimitedTimer.start();
        reverseTimer.start();


    }
}