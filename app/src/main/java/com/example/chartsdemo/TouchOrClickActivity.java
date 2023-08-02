package com.example.chartsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class TouchOrClickActivity extends AppCompatActivity {
    RelativeLayout mainRelative;
    int cardWidth, cardHeight;

    ArrayList<ArrayList<String>> mainArrayList = new ArrayList<>();
    ArrayList<String> a1 = new ArrayList<>();
    ArrayList<String> a2 = new ArrayList<>();
    ArrayList<String> a3 = new ArrayList<>();
    ArrayList<String> a4 = new ArrayList<>();
    ArrayList<String> a5 = new ArrayList<>();
    ArrayList<String> a6 = new ArrayList<>();
    ArrayList<String> a7 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_or_click);

        mainRelative = findViewById(R.id.touch_or_click_mainRela);
        getDeviceSize();

        mainArrayList.add(a1);
        mainArrayList.add(a2);
        mainArrayList.add(a3);
        mainArrayList.add(a4);
        mainArrayList.add(a5);
        mainArrayList.add(a6);
        mainArrayList.add(a7);

        addElementInArl();

        createTable();

    }

    private void addElementInArl() {
        a1.add("A");

        a2.add("B");
        a2.add("C");

        a3.add("D");
        a3.add("E");
        a3.add("F");

        a4.add("I");
        a4.add("J");
        a4.add("K");
        a4.add("L");

        a5.add("M");
        a5.add("N");
        a5.add("O");
        a5.add("P");
        a5.add("Q");

        a6.add("R");
        a6.add("S");
        a6.add("T");
        a6.add("U");
        a6.add("V");
        a6.add("W");

        a7.add("X");
        a7.add("Y");
        a7.add("Z");
        a7.add("1");
        a7.add("2");
        a7.add("3");
        a7.add("4");
    }

    private void getDeviceSize() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int screenWidth = displayMetrics.widthPixels;
        int screenHeight = displayMetrics.heightPixels;

        cardWidth = screenWidth / 7;
        cardHeight = screenHeight / 10;
    }

    @SuppressLint("ClickableViewAccessibility")
    private void createTable() {
        for (int i = 0; i < mainArrayList.size(); i++) {
            for (int j = 0; j < mainArrayList.get(i).size(); j++) {
                ImageButton imageView = new ImageButton(this);
                imageView.setPadding(10,10,10,10);
                imageView.setImageResource(R.drawable.cardback_blue5);
                imageView.setTag(mainArrayList.get(i).get(j));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

                int xPos = 0, yPos = 0;
                xPos = (i * cardWidth);
                yPos = (int) ((j * cardHeight / 3.5));

                FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(cardWidth, cardHeight);
                params.leftMargin = xPos;
                params.topMargin = yPos;
                imageView.setLayoutParams(params);

                if (i == j){
                    imageView.setImageResource(R.drawable.cardback_red5);
                }
                mainRelative.addView(imageView);

                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(TouchOrClickActivity.this, "Click", Toast.LENGTH_SHORT).show();
                    }
                });

                imageView.setOnTouchListener(new View.OnTouchListener() {
                    private float initialX, initialY;
                    private boolean isMoving = false;
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (v == imageView) {
                            switch (event.getAction()) {
                                case MotionEvent.ACTION_DOWN:
                                    isMoving = false;
                                    initialX = event.getRawX();
                                    initialY = event.getRawY();
                                    break;
                                case MotionEvent.ACTION_MOVE:
                                    float offsetX = event.getRawX() - initialX;
                                    float offsetY = event.getRawY() - initialY;
                                    if (Math.abs(offsetX) > 10 || Math.abs(offsetY) > 10) {
                                        isMoving = true;
                                    }
                                    break;
                                case MotionEvent.ACTION_UP:
                                    if (!isMoving) {
                                        Toast.makeText(TouchOrClickActivity.this, "Click", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(TouchOrClickActivity.this, "Touch", Toast.LENGTH_SHORT).show();
                                    }
                                    isMoving = false;
                                    break;
                            }
                        }
                        return false;
                    }
                });
            }
        }
    }
}