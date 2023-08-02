package com.example.chartsdemo.Timer;

import android.os.CountDownTimer;
import android.widget.TextView;

import java.util.Locale;

public class ReverseTimer extends CountDownTimer {
    private TextView textViewTimer;

    public ReverseTimer(long totalTime, long interval, TextView textViewTimer) {
        super(totalTime, interval);
        this.textViewTimer = textViewTimer;
    }

    @Override
    public void onTick(long millisUntilFinished) {
        // This method will be called every 'interval' milliseconds.
        // Update the UI to show the time remaining.
        long secondsRemaining = millisUntilFinished / 1000;
        textViewTimer.setText(String.format(Locale.getDefault(), "%02d:%02d",
                secondsRemaining / 60, secondsRemaining % 60));
    }

    @Override
    public void onFinish() {
        // This method will be called when the countdown is finished.
        // Perform any action you want to take when the timer completes.
        textViewTimer.setText("00:00");
        // Reverse timer finished, do something.
    }
}

