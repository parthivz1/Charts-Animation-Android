package com.example.chartsdemo;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.Touch;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chartsdemo.JsonDataModel.HikeInner;
import com.example.chartsdemo.JsonDataModel.HikeInnerXY;
import com.example.chartsdemo.JsonDataModel.HikeOuter;
import com.example.chartsdemo.Timer.TimeCounterActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button allChartsBtn, jsonChartsBtn, timeCounterBtn, touchOrClickBtn;

    static ArrayList<HikeOuter> OuterArl;
    ArrayList<HikeInner> InnerArl;
    ArrayList<HikeInnerXY> elevationXYArl;
    ArrayList<HikeInnerXY> heartRateXYArl;
    ArrayList<HikeInnerXY> paceXYArl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        allChartsBtn = findViewById(R.id.all_charts_btn);
        allChartsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AllChartsActivity.class));
            }
        });

        jsonChartsBtn = findViewById(R.id.json_chart_btn);
        jsonChartsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, JsonChartsActivity.class));
            }
        });

        timeCounterBtn = findViewById(R.id.time_counter_btn);
        timeCounterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TimeCounterActivity.class));
            }
        });

        touchOrClickBtn = findViewById(R.id.touch_or_click_btn);
        touchOrClickBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TouchOrClickActivity.class));
            }
        });

        getJsonData();
    }

    private String getJsonData() {

        String json = null;
        try {
            InputStream is = getAssets().open("hikeData.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, StandardCharsets.UTF_8);

            JSONArray jsonArray = new JSONArray(json);

            OuterArl = new ArrayList<>();
            InnerArl = new ArrayList<>();
            elevationXYArl = new ArrayList<>();
            paceXYArl = new ArrayList<>();
            heartRateXYArl = new ArrayList<>();
            for (int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
//                String observations = jsonObject.getString("observations");
                String name = jsonObject.getString("name");
                double distance = jsonObject.getDouble("distance");
                int difficulty = jsonObject.getInt("difficulty");
                int id = jsonObject.getInt("id");
                HikeOuter outerData = new HikeOuter( name, id, difficulty, distance, InnerArl);
                OuterArl.add(outerData);

                JSONArray observArray = jsonObject.getJSONArray("observations");

//                System.out.println("aq observArray" + observArray.length());

                for (int j = 0; j < observArray.length(); j++) {
                    JSONObject observObject = observArray.getJSONObject(j);
                    double distanceFromStart = observObject.getDouble("distanceFromStart");
//                    String elevation = observObject.getString("elevation");
//                    String pace = observObject.getString("pace");
//                    String heartRate = observObject.getString("heartRate");

//                    System.out.println("aqq J ======> " + j);
//                    System.out.println("aqq distanceFromStart ======> " + distanceFromStart);

//                    System.out.println("aq observObject " + observObject.length());
//                    System.out.println("aq observObject j " + observArray.getJSONObject(j).length());

                    JSONArray xyArray = observObject.getJSONArray("elevation");
                    double startY = xyArray.getDouble(0);
                    double endY = xyArray.getDouble(1);
                    HikeInnerXY hikeInnerXY = new HikeInnerXY(startY, endY);
                    elevationXYArl.add(hikeInnerXY);

                    JSONArray xyArray1 = observObject.getJSONArray("pace");
                    double startY1 = xyArray1.getDouble(0);
                    double endY1 = xyArray1.getDouble(1);
                    HikeInnerXY hikeInnerXY1 = new HikeInnerXY(startY1, endY1);
                    paceXYArl.add(hikeInnerXY1);

                    JSONArray xyArray2 = observObject.getJSONArray("heartRate");
                    double startY2 = xyArray2.getDouble(0);
                    double endY2 = xyArray2.getDouble(1);
                    HikeInnerXY hikeInnerXY2 = new HikeInnerXY(startY2, endY2);
                    heartRateXYArl.add(hikeInnerXY2);

                    HikeInner innerData = new HikeInner(distanceFromStart, elevationXYArl, paceXYArl, heartRateXYArl);
                    InnerArl.add(innerData);
                }
            }
//            System.out.println("aqq elevation size = " + MainActivity.OuterArl.get(0).getObservations().get(0).getElevation().size());
//
//            for (int i = 0; i< MainActivity.OuterArl.get(0).getObservations().get(0).getElevation().size(); i++){
//                if (i > 12){
//                    MainActivity.OuterArl.get(0).getObservations().get(0).getElevation().remove(i);
//                    System.out.println("aq elevation size = "+ i + " ==> " + MainActivity.OuterArl.get(0).getObservations().get(0).getElevation().size());
//                    System.out.println("aq elevation size = "+ i + " ==> " + MainActivity.OuterArl.get(0).getObservations().get(0).getElevation().toString());
//                }
//            }
//            System.out.println("aq elevation size = " + MainActivity.OuterArl.get(0).getObservations().get(0).getElevation().get(13).getStartY());

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return json;
    }
}