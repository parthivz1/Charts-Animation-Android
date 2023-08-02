package com.example.chartsdemo.Timer;

import android.os.CountDownTimer;
import android.widget.TextView;

import java.util.Locale;

public class UnlimitedTimer extends CountDownTimer {
    private TextView textViewTimer;

    public UnlimitedTimer(long interval, TextView textViewTimer) {
        super(Long.MAX_VALUE, interval);
        this.textViewTimer = textViewTimer;
    }

    @Override
    public void onTick(long millisUntilFinished) {
        // This method will be called every 'interval' milliseconds.
        // Update the UI to show the elapsed time.
        long secondsElapsed = (Long.MAX_VALUE - millisUntilFinished) / 1000;
        textViewTimer.setText(String.format(Locale.getDefault(), "%02d:%02d",
                secondsElapsed / 60, secondsElapsed % 60));
    }

    @Override
    public void onFinish() {
        // This method will not be called as the timer is set to Long.MAX_VALUE.
    }
}
