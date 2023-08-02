package com.example.chartsdemo;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chartsdemo.OtherModel.CustomCandlestickChart;
import com.example.chartsdemo.OtherModel.CandlestickData;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.CandleStickChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.data.CandleDataSet;
import com.github.mikephil.charting.data.CandleEntry;

import java.util.ArrayList;
import java.util.List;

public class JsonChartsActivity extends AppCompatActivity {
    private CandleStickChart candleStickChart, elevationChart, paceChart, heartRateChart;
    private ImageView showImg;
    private TextView nameTxt, distanceTxt, elevationTxt, heartRateTxt, paceTxt;
    private CustomCandlestickChart mainChart;

    private boolean isCheckImg = true;

    float[] arr = {0f, 0.375f, 0.75f, 1.125f, 1.5f, 1.875f, 2.25f, 2.265f, 3f, 3.375f, 3.75f, 4.125f};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_charts);

//        getCandleStickChart();

        showImg = findViewById(R.id.main_show_arrow_img);
        nameTxt = findViewById(R.id.main_name_txt);
        distanceTxt = findViewById(R.id.main_distance_txt);

        mainChart = findViewById(R.id.main_chart1);
        RelativeLayout relativeLayout = findViewById(R.id.change_chart_rela);

        elevationChart = findViewById(R.id.elevation_chart1);
        heartRateChart = findViewById(R.id.heartRate_chart1);
        paceChart = findViewById(R.id.pace_chart1);

        elevationTxt = findViewById(R.id.main_elevation_txt);
        heartRateTxt = findViewById(R.id.main_heartrate_txt);
        paceTxt = findViewById(R.id.main_pace_txt);

        nameTxt.setText(MainActivity.OuterArl.get(0).getName());
        distanceTxt.setText(MainActivity.OuterArl.get(0).getDistance() + " km");

        getElevation();
        getHeartRate();
        getPace();

        showImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isCheckImg){
                    elevationTxt.setTextColor(Color.WHITE);
//                    getElevationData();
                    getElevationChart();
                    Animation animation = AnimationUtils.loadAnimation(JsonChartsActivity.this, R.anim.slide_in);
                    mainChart.startAnimation(animation);
                    relativeLayout.startAnimation(animation);

                    heartRateTxt.setTextColor(Color.rgb(2,136,209));
                    paceTxt.setTextColor(Color.rgb(2,136,209));

                    mainChart.setVisibility(View.VISIBLE);
                    elevationTxt.setVisibility(View.VISIBLE);
                    heartRateTxt.setVisibility(View.VISIBLE);
                    paceTxt.setVisibility(View.VISIBLE);
                    showImg.setImageResource(R.drawable.arrow_down);
                    isCheckImg = false;
                }else {
                    Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);
                    mainChart.setAnimation(animation);

                    mainChart.setVisibility(View.INVISIBLE);
                    elevationTxt.setVisibility(View.INVISIBLE);
                    heartRateTxt.setVisibility(View.INVISIBLE);
                    paceTxt.setVisibility(View.INVISIBLE);
                    showImg.setImageResource(R.drawable.arrow_right);
                    isCheckImg = true;
                }
            }
        });

        elevationTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                elevationTxt.setTextColor(Color.WHITE);
                heartRateTxt.setTextColor(Color.rgb(2,136,209));
                paceTxt.setTextColor(Color.rgb(2,136,209));
                getElevationChart();
            }
        });

        heartRateTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                heartRateTxt.setTextColor(Color.WHITE);
                elevationTxt.setTextColor(Color.rgb(2,136,209));
                paceTxt.setTextColor(Color.rgb(2,136,209));
                getHeartRateChart();
            }
        });

        paceTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paceTxt.setTextColor(Color.WHITE);
                elevationTxt.setTextColor(Color.rgb(2,136,209));
                heartRateTxt.setTextColor(Color.rgb(2,136,209));
                getPaceChart();
            }
        });
    }

    private void getElevation() {

        elevationChart.getDescription().setEnabled(false);
        elevationChart.getLegend().setEnabled(false);

        ArrayList<CandleEntry> entries = new ArrayList<>();

        for (int i = 0; i < MainActivity.OuterArl.get(0).getObservations().get(0).getElevation().size(); i++){

            if (i < 12){
                entries.add(new CandleEntry(i, (float) MainActivity.OuterArl.get(0).getObservations().get(0).getElevation().get(i).getEndY(), (float) MainActivity.OuterArl.get(0).getObservations().get(0).getElevation().get(i).getStartY(), (float) MainActivity.OuterArl.get(0).getObservations().get(0).getElevation().get(i).getStartY(),(float) MainActivity.OuterArl.get(0).getObservations().get(0).getElevation().get(i).getEndY()));
            }

        }

        CandleDataSet dataSet = new CandleDataSet(entries, "Elevation Data");
        dataSet.setDecreasingColor(Color.rgb(130,130,132));
        dataSet.setDecreasingPaintStyle(Paint.Style.FILL_AND_STROKE);
        dataSet.setIncreasingColor(Color.rgb(130,130,132));
        dataSet.setIncreasingPaintStyle(Paint.Style.FILL_AND_STROKE);
        dataSet.setDrawValues(false);

        CandleData candleData = new CandleData(dataSet);
        elevationChart.setData(candleData);
        elevationChart.setScaleEnabled(false);
        elevationChart.setTouchEnabled(false);

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.waves);
        elevationChart.startAnimation(animation);

        elevationChart.animateX(800);

        elevationChart.setDoubleTapToZoomEnabled(false);

        XAxis xAxis = elevationChart.getXAxis();
        YAxis yAxisLeft = elevationChart.getAxisLeft();
        YAxis yAxisRight = elevationChart.getAxisRight();
        xAxis.setEnabled(false);
        yAxisRight.setEnabled(false);
        yAxisLeft.setEnabled(false);
    }

    private void getHeartRate() {

        heartRateChart.getDescription().setEnabled(false);
        heartRateChart.getLegend().setEnabled(false);

        ArrayList<CandleEntry> entries = new ArrayList<>();

        for (int i = 0; i < MainActivity.OuterArl.get(0).getObservations().get(0).getHeartRate().size(); i++){

            if (i < 12){
                entries.add(new CandleEntry(i, (float) MainActivity.OuterArl.get(0).getObservations().get(0).getHeartRate().get(i).getEndY(), (float) MainActivity.OuterArl.get(0).getObservations().get(0).getHeartRate().get(i).getStartY(), (float) MainActivity.OuterArl.get(0).getObservations().get(0).getHeartRate().get(i).getStartY(),(float) MainActivity.OuterArl.get(0).getObservations().get(0).getHeartRate().get(i).getEndY()));
            }

        }

        CandleDataSet dataSet = new CandleDataSet(entries, "Heart Rate Data");
        dataSet.setDecreasingColor(Color.rgb(171,75,76));
        dataSet.setDecreasingPaintStyle(Paint.Style.FILL_AND_STROKE);
        dataSet.setIncreasingColor(Color.rgb(171,75,76));
        dataSet.setIncreasingPaintStyle(Paint.Style.FILL_AND_STROKE);
        dataSet.setDrawValues(false);

        CandleData candleData = new CandleData(dataSet);
        heartRateChart.setData(candleData);

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce1);
        heartRateChart.startAnimation(animation);
        heartRateChart.animateX(1000);

        heartRateChart.setScaleEnabled(false);
        heartRateChart.setTouchEnabled(false);

        heartRateChart.setDoubleTapToZoomEnabled(false);

        XAxis xAxis = heartRateChart.getXAxis();
        YAxis yAxisLeft = heartRateChart.getAxisLeft();
        YAxis yAxisRight = heartRateChart.getAxisRight();
        xAxis.setEnabled(false);
        yAxisRight.setEnabled(false);
        yAxisLeft.setEnabled(false);
    }

    private void getPace()  {

        paceChart.getDescription().setEnabled(false);
        paceChart.getLegend().setEnabled(false);

        ArrayList<CandleEntry> entries = new ArrayList<>();

        for (int i = 0; i < MainActivity.OuterArl.get(0).getObservations().get(0).getPace().size(); i++){

            if (i < 12){
                entries.add(new CandleEntry(i, (float) MainActivity.OuterArl.get(0).getObservations().get(0).getPace().get(i).getEndY(),
                        (float) MainActivity.OuterArl.get(0).getObservations().get(0).getPace().get(i).getStartY(),
                        (float) MainActivity.OuterArl.get(0).getObservations().get(0).getPace().get(i).getStartY(),
                        (float) MainActivity.OuterArl.get(0).getObservations().get(0).getPace().get(i).getEndY()));
            }

        }

        CandleDataSet dataSet = new CandleDataSet(entries, "Pace Data");
        dataSet.setDecreasingColor(Color.rgb(109,95,171));
        dataSet.setDecreasingPaintStyle(Paint.Style.FILL_AND_STROKE);
        dataSet.setIncreasingColor(Color.rgb(109,95,171));
        dataSet.setIncreasingPaintStyle(Paint.Style.FILL_AND_STROKE);
        dataSet.setDrawValues(false);

        CandleData candleData = new CandleData(dataSet);
        paceChart.setData(candleData);

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
        paceChart.startAnimation(animation);
        paceChart.animateX(1000, Easing.EaseOutBounce);

        paceChart.setScaleEnabled(false);
        paceChart.setTouchEnabled(false);

        paceChart.setDoubleTapToZoomEnabled(false);

        XAxis xAxis = paceChart.getXAxis();
        YAxis yAxisLeft = paceChart.getAxisLeft();
        YAxis yAxisRight = paceChart.getAxisRight();
        xAxis.setEnabled(false);
        yAxisRight.setEnabled(false);
        yAxisLeft.setEnabled(false);
    }

    private void getElevationChart() {

        CustomCandlestickChart elevationChart = findViewById(R.id.main_chart1);

        List<CandlestickData> candleDataList1 = new ArrayList<>();

//        for (int i = 0; i < MainActivity.OuterArl.get(0).getObservations().get(0).getPace().size(); i++){
//
//            if (i < 12){
//                int x = i * 80;
//                float high = (float) MainActivity.OuterArl.get(0).getObservations().get(0).getElevation().get(i).getEndY() - 80;
//                float low = (float) MainActivity.OuterArl.get(0).getObservations().get(0).getElevation().get(i).getStartY() - 130;
//
//                candleDataList1.add(new CandlestickData(x,
//                        high,
//                        low,
//                        high,
//                        low,
//                        Color.GREEN));
//
////                System.out.println("Candle Stick " + i + " ==> X = " + x);
////                System.out.println("Candle Stick ==> Bar Width = " + 80f);
////                System.out.println("Candle Stick ==> Bar Lowest = " + (float) MainActivity.OuterArl.get(0).getObservations().get(0).getElevation().get(i).getStartY());
////                System.out.println("Candle Stick ==> Bar Highest = " + (float) MainActivity.OuterArl.get(0).getObservations().get(0).getElevation().get(i).getEndY());
////                System.out.println("Candle Stick ==> Bar Color = " + Color.GRAY);
////                System.out.println("Candle Stick ==> Bar Radius = " + 50f);
////                System.out.println("----------------END-------------------");
//            }else {
//                break;
//            }
//        }

        candleDataList1.add(new CandlestickData(40, 281f - 200, 304f - 150, 290,550, Color.GRAY));
        candleDataList1.add(new CandlestickData(120, 289f - 180, 312f - 130, 290,550, Color.GRAY));
        candleDataList1.add(new CandlestickData(200, 300f - 185, 320f - 130, 290,550, Color.GRAY));
        candleDataList1.add(new CandlestickData(280, 310f - 175, 340f - 125, 290,550, Color.GRAY));
        candleDataList1.add(new CandlestickData(360, 350f - 150, 400f - 90, 290,550, Color.GRAY));
        candleDataList1.add(new CandlestickData(440, 350f - 145, 380f - 85, 290,550, Color.GRAY));
        candleDataList1.add(new CandlestickData(520, 340f - 155, 360f - 90, 290,550, Color.GRAY));
        candleDataList1.add(new CandlestickData(600, 340f - 150, 490f, 290,550, Color.GRAY));
        candleDataList1.add(new CandlestickData(680, 480f, 530f + 80, 290,550, Color.GRAY));
        candleDataList1.add(new CandlestickData(760, 470f - 30, 530f + 40, 290,550, Color.GRAY));
        candleDataList1.add(new CandlestickData(840, 330f - 160, 460f - 20, 290,550, Color.GRAY));
        candleDataList1.add(new CandlestickData(920, 300f - 190, 330f - 140, 290,550, Color.GRAY));

        elevationChart.setCandlestickDataList(candleDataList1);
        elevationChart.setCameraDistance(500);
        elevationChart.setRotationX(180);

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce1);
        elevationChart.startAnimation(animation);

//        elevationChart.getDescription().setEnabled(false);
//        elevationChart.getLegend().setEnabled(false);
//
//        ArrayList<CandleEntry> entries = new ArrayList<>();
//
//        for (int i = 0; i < MainActivity.OuterArl.get(0).getObservations().get(0).getElevation().size(); i++){
//            if (i < 12){
//                entries.add(new CandleEntry(i, (float) MainActivity.OuterArl.get(0).getObservations().get(0).getElevation().get(i).getEndY(), (float) MainActivity.OuterArl.get(0).getObservations().get(0).getElevation().get(i).getStartY(), (float) MainActivity.OuterArl.get(0).getObservations().get(0).getElevation().get(i).getStartY(),(float) MainActivity.OuterArl.get(0).getObservations().get(0).getElevation().get(i).getEndY()));
//            }
//        }
//
//        CandleDataSet dataSet = new CandleDataSet(entries, "OHLC Data");
////        dataSet.setColors(Color.GREEN);
////        dataSet.setShadowColor(Color.DKGRAY);
////        dataSet.setGradientColor(Color.rgb(239,126,211), Color.rgb(239,172,121));
////        dataSet.setShadowWidth(0.7f);
//        dataSet.setDecreasingColor(Color.rgb(142,142,147));
////        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
//        dataSet.setDecreasingPaintStyle(Paint.Style.FILL_AND_STROKE);
//        dataSet.setIncreasingColor(Color.rgb(142,142,147));
//        dataSet.setIncreasingPaintStyle(Paint.Style.FILL_AND_STROKE);
//
////        dataSet.setNeutralColor(Color.BLUE);
//
//        dataSet.setDrawValues(false);
//
//
//
//        dataSet.setShowCandleBar(true);
//
//        CandleData candleData = new CandleData(dataSet);
//        elevationChart.setData(candleData);
//
////        candleStickChart.setFitBars(true);
////        candleStickChart.getDescription().setText("Bar Report Demo");
////        elevationChart.animateY(2000);
//
//        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce1);
//        elevationChart.startAnimation(animation);
//        elevationChart.animateX(500);
//
////        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.infinity);
////        animator.setTarget(elevationChart);
////        animator.start();
//
//
////        dataSet.setShadowColorSameAsCandle(true);
////        dataSet.setBarSpace(0.33f); //bar space
////        elevationChart.scheduleDrawable(elevationChart , this::getElevationChart, 500).setDrawValueAboveBar(true);
//
////        elevationChart.getAxisLeft().setStartAtZero(false);
////        elevationChart.getAxisRight().setStartAtZero(false);
//
////        elevationChart.setScaleEnabled(Efalse); // Enable scaling on both axes
////        elevationChart.getDescription().setEnabled(false); // Disable chart description
////        elevationChart.setDrawGridBackground(false); // Disable grid background
////        elevationChart.setHighlightPerDragEnabled(true); // Enable highlight per drag
////        elevationChart.setPinchZoom(true); // Enable pinch zoom
////        elevationChart.setDragEnabled(true); // Enable chart dragging
////        elevationChart.setAutoScaleMinMaxEnabled(true); // Enable auto scaling of axis minimum and maximum values
////        elevationChart.setDrawBorders(true); //border
////        elevationChart.requestDisallowInterceptTouchEvent(true);
//        elevationChart.setDoubleTapToZoomEnabled(false);
//
//        elevationChart.setTouchEnabled(false);
//
////        elevationChart.setBackgroundResource(R.drawable.shape); //background
//
//        XAxis xAxis = elevationChart.getXAxis();
//        YAxis yAxisLeft = elevationChart.getAxisLeft();
//        YAxis yAxisRight = elevationChart.getAxisRight();
//        xAxis.setEnabled(false);
//        yAxisRight.setEnabled(false);
//        yAxisLeft.setEnabled(false);
//        elevationChart.setScaleEnabled(false);
//
//        xAxis.setDrawGridLines(false);// disable x axis grid lines scale
////        xAxis.setDrawLabels(false);
////        yAxisRight.setTextColor(Color.WHITE);
////        yAxis.setDrawLabels(false);
////        xAxis.setGranularity(1f);
////        xAxis.setGranularityEnabled(true);
////        xAxis.setAvoidFirstLastClipping(true);
//
////        Legend l = candleStickChart.getLegend();
////        l.setEnabled(false);
    }

    private void getHeartRateChart()  {

//        heartRateChart = findViewById(R.id.heartRate_chart1);
//
//        heartRateChart.getDescription().setEnabled(false);
//        heartRateChart.getLegend().setEnabled(false);
//
//        ArrayList<CandleEntry> entries = new ArrayList<>();
//
//        for (int i = 0; i < MainActivity.OuterArl.get(0).getObservations().get(0).getHeartRate().size(); i++){
//
//            if (i < 12){
//                entries.add(new CandleEntry(i, (float) MainActivity.OuterArl.get(0).getObservations().get(0).getHeartRate().get(i).getEndY(), (float) MainActivity.OuterArl.get(0).getObservations().get(0).getHeartRate().get(i).getStartY(), (float) MainActivity.OuterArl.get(0).getObservations().get(0).getHeartRate().get(i).getStartY(),(float) MainActivity.OuterArl.get(0).getObservations().get(0).getHeartRate().get(i).getEndY()));
//            }
//
//        }

        CustomCandlestickChart heartRateChart = findViewById(R.id.main_chart1);

        List<CandlestickData> candleDataList1 = new ArrayList<>();

        candleDataList1.add(new CandlestickData(35, 117.16352f + 80, 121.95815f, 117.16352f, 121.95815f, Color.rgb(171,75,76)));
        candleDataList1.add(new CandlestickData(110, 117.64109f + 85, 124.82185f + 5, 117.64109f, 124.82185f, Color.rgb(171,75,76)));
        candleDataList1.add(new CandlestickData(185, 121.52696f + 40, 127.315254f + 120, 121.52696f, 127.315254f, Color.rgb(171,75,76)));
        candleDataList1.add(new CandlestickData(260, 123.75909f + 55, 132.77069f + 150, 123.75909f, 132.77069f, Color.rgb(171,75,76)));
        candleDataList1.add(new CandlestickData(340, 130.82352f + 120, 140.557f + 230, 130.82352f, 140.557f, Color.rgb(171,75,76)));
        candleDataList1.add(new CandlestickData(420, 131.54561f + 130, 134.65985f + 210, 131.54561f, 134.65985f, Color.rgb(171,75,76)));
        candleDataList1.add(new CandlestickData(500, 125.19497f + 50, 131.31354f + 120, 125.19497f, 131.31354f, Color.rgb(171,75,76)));
        candleDataList1.add(new CandlestickData(580, 131.6781f + 100, 154.26779f + 330, 131.6781f, 154.26779f, Color.rgb(171,75,76)));
        candleDataList1.add(new CandlestickData(660, 151.36398f + 300, 166.20454f + 460, 151.36398f, 166.20454f, Color.rgb(171,75,76)));
        candleDataList1.add(new CandlestickData(740, 134.41798f + 140, 151.90887f + 300, 134.41798f, 151.90887f, Color.rgb(171,75,76)));
        candleDataList1.add(new CandlestickData(820, 129.97754f + 95, 138.13531f + 180, 129.97754f, 138.13531f, Color.rgb(171,75,76)));
        candleDataList1.add(new CandlestickData(900, 127.723045f + 70, 133.26323f + 140, 127.723045f, 133.26323f, Color.rgb(171,75,76)));

        heartRateChart.setCandlestickDataList(candleDataList1);
        heartRateChart.setCameraDistance(500);
        heartRateChart.setRotationX(180);

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.waves);
        heartRateChart.startAnimation(animation);
//        CandleDataSet dataSet = new CandleDataSet(entries, "OHLC Data");
////        dataSet.setColors(Color.GREEN);
////        dataSet.setShadowColor(Color.DKGRAY);
////        dataSet.setShadowWidth(0.7f);
//        dataSet.setDecreasingColor(Color.rgb(142,142,147));
////        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
//        dataSet.setDecreasingPaintStyle(Paint.Style.FILL_AND_STROKE);
//        dataSet.setIncreasingColor(Color.rgb(142,142,147));
//        dataSet.setIncreasingPaintStyle(Paint.Style.FILL_AND_STROKE);
////        dataSet.setNeutralColor(Color.BLUE);
//        dataSet.setDrawValues(false);
//
//        CandleData candleData = new CandleData(dataSet);
//        heartRateChart.setData(candleData);
//        heartRateChart.setTouchEnabled(false);
//
////        heartRateChart.setFitBars(true);
////        heartRateChart.getDescription().setText("Bar Report Demo");
////        heartRateChart.animateY(2000);
//
//        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.waves);
//        heartRateChart.startAnimation(animation);
//        heartRateChart.animateX(500);
//
////        heartRateChart.getAxisLeft().setStartAtZero(false);
////        heartRateChart.getAxisRight().setStartAtZero(false);
//
//        heartRateChart.setDoubleTapToZoomEnabled(false);
//
//        XAxis xAxis = heartRateChart.getXAxis();
//        YAxis yAxisLeft = heartRateChart.getAxisLeft();
//        YAxis yAxisRight = heartRateChart.getAxisRight();
//        xAxis.setEnabled(false);
//        yAxisRight.setEnabled(false);
//        yAxisLeft.setEnabled(false);
    }

    private void getPaceChart()  {
        CustomCandlestickChart paceChart = findViewById(R.id.main_chart1);

        List<CandlestickData> candleDataList1 = new ArrayList<>();

        candleDataList1.add(new CandlestickData(40, 396.0871648190873f + 245, 403.6893787352523f + 160, 396.0871648190873f, 403.6893787352523f, Color.rgb(109,95,171)));
        candleDataList1.add(new CandlestickData(100, 380.19020240756623f + 195, 395.3978319010256f + 100, 380.19020240756623f, 395.3978319010256f, Color.rgb(109,95,171)));
        candleDataList1.add(new CandlestickData(180, 380.55927782266116f + 200, 397.60789726832775f + 100, 380.55927782266116f, 397.60789726832775f, Color.rgb(109,95,171)));
        candleDataList1.add(new CandlestickData(260, 357.9411642125853f + 195, 398.0750288648062f - 10, 357.9411642125853f, 398.0750288648062f, Color.rgb(109,95,171)));
        candleDataList1.add(new CandlestickData(340, 335.073851493927f + 210, 397.8267438187581f - 100, 335.073851493927f, 397.8267438187581f, Color.rgb(109,95,171)));
        candleDataList1.add(new CandlestickData(420, 395.16168913839374f + 240, 404.6029406652756f + 155, 395.16168913839374f, 404.6029406652756f, Color.rgb(109,95,171)));
        candleDataList1.add(new CandlestickData(500, 340.8230304133908f + 250, 404.71689228682374f - 40, 340.8230304133908f, 404.71689228682374f, Color.rgb(109,95,171)));
        candleDataList1.add(new CandlestickData(580, 261.2762914881602f + 50, 331.68516208719467f - 270, 261.2762914881602f, 331.68516208719467f, Color.rgb(109,95,171)));
        candleDataList1.add(new CandlestickData(660, 296.0529864411209f + 260, 401.140929677324f - 200, 296.0529864411209f, 401.140929677324f, Color.rgb(109,95,171)));
        candleDataList1.add(new CandlestickData(740, 395.5083066351401f + 250, 401.6783791754359f + 165, 395.5083066351401f, 401.6783791754359f, Color.rgb(109,95,171)));
        candleDataList1.add(new CandlestickData(820, 395.3116048797518f + 240, 404.49550455974907f + 155, 395.3116048797518f, 404.49550455974907f, Color.rgb(109,95,171)));
        candleDataList1.add(new CandlestickData(900, 395.02844559698116f + 240, 402.65878340653796f + 155, 395.02844559698116f, 402.65878340653796f, Color.rgb(109,95,171)));

        paceChart.setCandlestickDataList(candleDataList1);
        paceChart.setCameraDistance(500);
        paceChart.setRotationX(180);

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
        paceChart.startAnimation(animation);

//        paceChart = findViewById(R.id.pace_chart1);
//
//        paceChart.getDescription().setEnabled(false);
//        paceChart.getLegend().setEnabled(false);
//
//        ArrayList<CandleEntry> entries = new ArrayList<>();
//
//        for (int i = 0; i < MainActivity.OuterArl.get(0).getObservations().get(0).getPace().size(); i++){
//
//            if (i < 12){
//                entries.add(new CandleEntry(i, (float) MainActivity.OuterArl.get(0).getObservations().get(0).getPace().get(i).getEndY(), (float) MainActivity.OuterArl.get(0).getObservations().get(0).getPace().get(i).getStartY(), (float) MainActivity.OuterArl.get(0).getObservations().get(0).getPace().get(i).getStartY(),(float) MainActivity.OuterArl.get(0).getObservations().get(0).getPace().get(i).getEndY()));
//            }
//
//        }
//
//        CandleDataSet dataSet = new CandleDataSet(entries, "OHLC Data");
////        dataSet.setColors(Color.GREEN);
////        dataSet.setShadowColor(Color.DKGRAY);
////        dataSet.setShadowWidth(0.7f);
//        dataSet.setDecreasingColor(Color.rgb(142,142,147));
////        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
//        dataSet.setDecreasingPaintStyle(Paint.Style.FILL_AND_STROKE);
//        dataSet.setIncreasingColor(Color.rgb(142,142,147));
//        dataSet.setIncreasingPaintStyle(Paint.Style.FILL_AND_STROKE);
////        dataSet.setNeutralColor(Color.BLUE);
//        dataSet.setDrawValues(false);
//
//        CandleData candleData = new CandleData(dataSet);
//        paceChart.setData(candleData);
//        paceChart.setTouchEnabled(false);
//
////        paceChart.setFitBars(true);
////        paceChart.getDescription().setText("Bar Report Demo");
////        paceChart.animateY(2000);
//        paceChart.animateX(500);
//
//        paceChart.setDoubleTapToZoomEnabled(false);
////        paceChart.getAxisLeft().setStartAtZero(false);
////        paceChart.getAxisRight().setStartAtZero(false);
//
//        XAxis xAxis = paceChart.getXAxis();
//        YAxis yAxisLeft = paceChart.getAxisLeft();
//        YAxis yAxisRight = paceChart.getAxisRight();
//        xAxis.setEnabled(false);
//        yAxisRight.setEnabled(false);
//        yAxisLeft.setEnabled(false);
    }

    private void getCandleStickChart() {
        candleStickChart = findViewById(R.id.elevation_chart1);

        // Configure chart settings
        candleStickChart.getDescription().setEnabled(false);
        candleStickChart.getLegend().setEnabled(false);

        ArrayList<CandleEntry> entries = new ArrayList<>();
//        entries.add(new CandleEntry(0, 25f, 10f, 25f, 10f));
//        entries.add(new CandleEntry(1, 35f, 20f, 35f, 20f));
//        entries.add(new CandleEntry(2, 40f, 25f, 40f, 25f));
//        entries.add(new CandleEntry(3, 45f, 30f, 45f, 30f));
//        entries.add(new CandleEntry(4, 50f, 35f, 50f, 35f));
//        entries.add(new CandleEntry(5, 40f, 25f, 40f, 25f));
//        entries.add(new CandleEntry(6, 35f, 20f, 35f, 20f));
//        entries.add(new CandleEntry(7, 30f, 25f, 30f, 25f));
//        entries.add(new CandleEntry(8, 40f, 25f, 40f, 25f));
//        entries.add(new CandleEntry(9, 45f, 30f, 45f, 30f));
//        entries.add(new CandleEntry(10, 35f, 20f, 35f, 20f));

//        entries.add(new BarEntry(0,new float[] {20f, 25f}));
//        entries.add(new BarEntry(1, new float[]{35f, 20f}));
//        entries.add(new BarEntry(2,new float[] {30f, 40f}));
//        entries.add(new BarEntry(3,new float[] {45f, 30f}));
//        entries.add(new BarEntry(4, new float[] {10f, 25f}));

//        entries.add(new CandleEntry(1, 309f, 291f, 291.65263635636268f,309.26016677925196f));
//        entries.add(new CandleEntry(2, 317f, 299f, 299.24001936628116f,317.44584350790012f));
//        entries.add(new CandleEntry(3, 336f, 303f, 303.62145464574394f,336.05569457646544f));
//        entries.add(new CandleEntry(4, 346f, 319f, 319.90393365162629f,346.26966025518789f));
//        entries.add(new CandleEntry(5, 403f, 354f, 354.17104439267905f,403.57031216972939f));
//        entries.add(new CandleEntry(6, 385f, 357f, 357.42992871175124f,385.92155620623635f));
//        entries.add(new CandleEntry(7, 363f, 345f, 345.47736721935661f,363.18776661379422f));
//        entries.add(new CandleEntry(8, 497f, 346f, 346.23343025200535f,497.23376445462401f));
//        entries.add(new CandleEntry(9, 547f, 491f, 491.57378483134391f,547.49535224251053f));
//        entries.add(new CandleEntry(10, 531f, 472f, 472.06803233416338f,531.92570520228401f));
//        entries.add(new CandleEntry(11, 461f, 3390f, 339.81419476005283f,461.03832527824829f));
//        entries.add(new CandleEntry(12, 342f, 303f, 303.1495508565697f,342.3532820173541f));

//        entries.add(new CandleEntry(0, 281f, 304f, 291.65263635636268f,309.26016677925196f));
//        entries.add(new CandleEntry(0.375f, 289f, 312f, 299.24001936628116f,317.44584350790012f));
//        entries.add(new CandleEntry(0.75f, 300f, 320f, 303.62145464574394f,336.05569457646544f));
//        entries.add(new CandleEntry(1.125f, 310f, 340f, 319.90393365162629f,346.26966025518789f));
//        entries.add(new CandleEntry(1.5f, 350f, 400f, 354.17104439267905f,403.57031216972939f));
//        entries.add(new CandleEntry(1.875f, 350f, 380f, 357.42992871175124f,385.92155620623635f));
//        entries.add(new CandleEntry(2.25f, 340f, 360f, 345.47736721935661f,363.18776661379422f));
//        entries.add(new CandleEntry(2.625f, 340f, 490f, 346.23343025200535f,497.23376445462401f));
//        entries.add(new CandleEntry(3, 480f, 530f, 491.57378483134391f,547.49535224251053f));
//        entries.add(new CandleEntry(3.375f, 470f, 530f, 472.06803233416338f,531.92570520228401f));
//        entries.add(new CandleEntry(3.75f, 330f, 4600f, 339.81419476005283f,461.03832527824829f));
//        entries.add(new CandleEntry(4.125f, 300f, 330f, 303.1495508565697f,342.3532820173541f));

        CandleDataSet dataSet = new CandleDataSet(entries, "OHLC Data");
//        dataSet.setColors(Color.GREEN);
//        dataSet.setShadowColor(Color.DKGRAY);
//        dataSet.setShadowWidth(0.7f);
        dataSet.setDecreasingColor(R.drawable.shape);
//        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        dataSet.setDecreasingPaintStyle(Paint.Style.FILL_AND_STROKE);
        dataSet.setIncreasingColor(R.drawable.shape);
        dataSet.setIncreasingPaintStyle(Paint.Style.FILL_AND_STROKE);
//        dataSet.setNeutralColor(Color.BLUE);
        dataSet.setDrawValues(false);

        CandleData candleData = new CandleData(dataSet);
        candleStickChart.setData(candleData);

//        candleStickChart.setFitBars(true);
//        candleStickChart.getDescription().setText("Bar Report Demo");
//        candleStickChart.animateY(2000);
//        candleStickChart.animateX(2000);

//        candleStickChart.getAxisLeft().setStartAtZero(false);
//        candleStickChart.getAxisRight().setStartAtZero(false);

        XAxis xAxis = candleStickChart.getXAxis();
        YAxis yAxisLeft = candleStickChart.getAxisLeft();
        YAxis yAxisRight = candleStickChart.getAxisRight();
//        yAxisLeft.setStartAtZero(false);

//        xAxis.setLabelCount(6, true);
//        xAxis.setGranularity(1f);
//        xAxis.setDrawGridLines(false);
        xAxis.setEnabled(false);
//        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
//        xAxis.setAvoidFirstLastClipping(true);
//        yAxisLeft.setPosition(YAxis.YAxisLabelPosition.INSIDE_CHART);
//        yAxisLeft.setDrawLabels(true);
//        yAxisLeft.setSpaceBottom(60);
//        yAxisLeft.setDrawGridLines(true);
//        yAxisLeft.setLabelCount(3, true);
//        yAxisLeft.setCenterAxisLabels(true);
//        yAxisLeft.setDrawGridLines(false);
//        yAxisRight.setDrawGridLines(false);
        yAxisRight.setEnabled(false);
        yAxisLeft.setEnabled(false);
//        xAxis.setAvoidFirstLastClipping(true);
//        dataSet.setColor(Color.GRAY);
//        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);


//        candleStickChart.isFullyZoomedOut();
//        candleStickChart.animate();
//        candleStickChart.getDescription().setEnabled(false); // Disable chart description
//        candleStickChart.setDrawGridBackground(false); // Disable grid background
//        candleStickChart.setHighlightPerDragEnabled(false); // Enable highlight per drag
//        candleStickChart.setPinchZoom(false); // Enable pinch zoom
//        candleStickChart.setDragEnabled(false); // Enable chart dragging
//        candleStickChart.setScaleEnabled(false); // Enable scaling on both axes
//        candleStickChart.setAutoScaleMinMaxEnabled(false); // Enable auto scaling of axis minimum and maximum values
//        candleStickChart.invalidate();
//        candleStickChart.animate();
    }
}