package com.example.chartsdemo;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;

public class WaveAnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wave_animation);

        View waterView = findViewById(R.id.waterView);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.wave_animation);
        waterView.startAnimation(animation);

    }

}
