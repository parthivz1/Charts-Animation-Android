package com.example.chartsdemo;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.CycleInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;

import java.util.Random;
import java.util.concurrent.Executor;

public class AnimationActivity extends AppCompatActivity {
    private ImageView animationImg;
    private Button bounceBtn, bounce1Btn, blinkBtn, crossFadeBtn, clockWiseBtn, antiClockWiseBtn,
            fadeInBtn, fadeOutBtn, slideUpBtn, slideDownBtn,
            slideLeftBtn, slideRightBtn, zoomInBtn, zoomOutBtn,scaleInBtn, scaleOutBtn, sequentialBtn, waveBtn, fogBtn;

    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        animationImg = findViewById(R.id.animation_img);

        bounceBtn = findViewById(R.id.bounce_btn);
        bounce1Btn = findViewById(R.id.bounce1_btn);

        blinkBtn = findViewById(R.id.blink_btn);
        crossFadeBtn = findViewById(R.id.cross_fade_btn);

        clockWiseBtn = findViewById(R.id.clock_wise_btn);
        antiClockWiseBtn = findViewById(R.id.anti_clock_wise_btn);

        fadeInBtn = findViewById(R.id.fade_in_btn);
        fadeOutBtn = findViewById(R.id.fade_out_btn);

        slideUpBtn = findViewById(R.id.slide_up_btn);
        slideDownBtn = findViewById(R.id.slide_down_btn);

        slideLeftBtn = findViewById(R.id.slide_left_btn);
        slideRightBtn = findViewById(R.id.slide_right_btn);

        zoomInBtn = findViewById(R.id.zoom_in_btn);
        zoomOutBtn = findViewById(R.id.zoom_out_btn);

        sequentialBtn = findViewById(R.id.sequential_btn);
        waveBtn = findViewById(R.id.wave_btn);

        scaleInBtn = findViewById(R.id.scale_in_btn);
        scaleOutBtn = findViewById(R.id.scale_out_btn);

        fogBtn = findViewById(R.id.fog_btn);

        bounceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
                animationImg.startAnimation(animation);
            }
        });

        bounce1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce1);
                animationImg.startAnimation(animation);
            }
        });

        blinkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
                animationImg.startAnimation(animation);
            }
        });

        crossFadeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.cross_fade);
                animationImg.startAnimation(animation);
            }
        });

        clockWiseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.clock_wise);
                animationImg.startAnimation(animation);
            }
        });

        antiClockWiseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anti_clock_wise);
                animationImg.startAnimation(animation);
            }
        });

        fadeInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
                animationImg.startAnimation(animation);
            }
        });

        fadeOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);
                animationImg.startAnimation(animation);
            }
        });

        slideUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
                animationImg.startAnimation(animation);
            }
        });

        slideDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down);
                animationImg.startAnimation(animation);
            }
        });

        slideLeftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_left);
                animationImg.startAnimation(animation);
            }
        });

        slideRightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_right);
                animationImg.startAnimation(animation);
            }
        });

        zoomInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                animationImg.startAnimation(animation);
            }
        });

        zoomOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_out);
                animationImg.startAnimation(animation);
            }
        });

        scaleInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale_in);
                animationImg.startAnimation(animation);
            }
        });

        scaleOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale_out);
                animationImg.startAnimation(animation);
            }
        });

        sequentialBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.sequential);
                animationImg.startAnimation(animation);
            }
        });

        waveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.waves);
                animationImg.startAnimation(animation);
            }
        });

        fogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startFireworksAnimation();
            }
        });

        txt = findViewById(R.id.fingerprint);
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BiometricPrompt.PromptInfo promptInfo = new BiometricPrompt.PromptInfo.Builder()
                        .setTitle("Please Verify")
                        .setDescription("User Authentication")
                        .setNegativeButtonText("Cancel")
                        .build();
                getPrompt().authenticate(promptInfo);
            }
        });
    }

    private void startFireworksAnimation() {

        final int numParticles = 50; // Number of particles for the fireworks
        final long duration = 2000; // Duration of the animation

        // Create a ViewGroup to hold the particle drawables
        final ViewGroup container = findViewById(R.id.container); // Replace with your container ID

        // Create an AnimatorSet to manage the animation
        AnimatorSet animatorSet = new AnimatorSet();

        // Create and add ObjectAnimator for each particle
        for (int i = 0; i < numParticles; i++) {
            // Create the particle drawable
//            Drawable drawable = getResources().getDrawable(R.drawable.cardback_blue1);

            // Create the ImageView to display the particle drawable
            ImageView particleView = new ImageView(this);
            particleView.setImageDrawable(animationImg.getDrawable());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(200,200);
            particleView.setLayoutParams(layoutParams);
            layoutParams.setMargins(50,50,50,50);

            // Add the particle ImageView to the container
            container.addView(particleView);

            // Create the ObjectAnimator for the particle's translation and alpha
            ObjectAnimator translationXAnimator = ObjectAnimator.ofFloat(particleView, "translationX", 0, getRandomOffset());
            ObjectAnimator translationYAnimator = ObjectAnimator.ofFloat(particleView, "translationY", 0, getRandomOffset());
            ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(particleView, "alpha", 1f, 0f);

            // Set the duration and interpolator for each animator
            translationXAnimator.setDuration(duration);
            translationYAnimator.setDuration(duration);
            alphaAnimator.setDuration(duration);

            translationXAnimator.setInterpolator(new AccelerateInterpolator());
            translationYAnimator.setInterpolator(new AccelerateInterpolator());

            // Add the animators to the AnimatorSet
            animatorSet.playTogether(translationXAnimator, translationYAnimator, alphaAnimator);
        }

        // Start the animation
        animatorSet.start();
    }

    private float getRandomOffset() {
        float minOffset = -100f;
        float maxOffset = 100f;

        // Calculate a random offset within the specified range
        Random random = new Random();
        return minOffset + random.nextFloat() * (maxOffset - minOffset);
    }

    private BiometricPrompt getPrompt() {
        Executor executor = ContextCompat.getMainExecutor(this);
        BiometricPrompt.AuthenticationCallback callback = new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
                Toast.makeText(AnimationActivity.this,errString, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);

                Toast.makeText(AnimationActivity.this, "Verified", Toast.LENGTH_SHORT).show();
                Animation animation = new RotateAnimation(0, 360,
                        Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f);
                animation.setDuration(1000);
                animation.setInterpolator(new CycleInterpolator(2));
                animationImg.startAnimation(animation);
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
                Toast.makeText(AnimationActivity.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
            }
        };
        BiometricPrompt biometricPrompt = new BiometricPrompt(this,executor,callback);
        return biometricPrompt;
    }
}