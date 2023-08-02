package com.example.chartsdemo;

import android.os.Handler;
import android.view.View;

import java.util.concurrent.atomic.AtomicBoolean;

public abstract class SingleClickListener implements View.OnClickListener {
    private static final long DEFAULT_DEBOUNCE_TIME_MS = 1000; // 1 second
    private final long debounceTimeMs;
    private final AtomicBoolean isClickable = new AtomicBoolean(true);

    public SingleClickListener() {
        debounceTimeMs = DEFAULT_DEBOUNCE_TIME_MS;
    }

    public SingleClickListener(long debounceTimeMs) {
        this.debounceTimeMs = debounceTimeMs;
    }

    @Override
    public void onClick(View view) {
        if (isClickable.compareAndSet(true, false)) {
            onSingleClick(view);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    isClickable.set(true);
                }
            }, debounceTimeMs);
        }
    }

    public abstract void onSingleClick(View view);
}

