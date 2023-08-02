package com.example.chartsdemo;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.BubbleChart;
import com.github.mikephil.charting.charts.CandleStickChart;
import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.charts.ScatterChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.BubbleData;
import com.github.mikephil.charting.data.BubbleDataSet;
import com.github.mikephil.charting.data.BubbleEntry;
import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.data.CandleDataSet;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.data.ScatterDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class AllChartsActivity extends AppCompatActivity {

    BarChart barChart;
    LineChart lineChart;
    PieChart pieChart;
    BubbleChart bubbleChart;
    CandleStickChart candleStickChart;
    RadarChart radarChart;
    CombinedChart combinedChart;
    ScatterChart scatterChart;
    HorizontalBarChart horizontalBarChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_charts);

        getBarchart();
        getLineChart();
        getPieChart();
        getBubbleChart();
        getCandleStickChart();
        getRadarChart();
        getCombinedChart();
        getScatterChart();
        getHorizontalBarChart();
    }

    private void getBarchart() {
        barChart = (BarChart)findViewById(R.id.barchart);

        ArrayList<BarEntry> information=new ArrayList<>();

        information.add(new BarEntry(2010,1000));
        information.add(new BarEntry(2011,1200));
        information.add(new BarEntry(2012,1400));
        information.add(new BarEntry(2013,1700));
        information.add(new BarEntry(2014,1300));
        information.add(new BarEntry(2015,1100));
        information.add(new BarEntry(2016,1000));
        information.add(new BarEntry(2017,1700));
        information.add(new BarEntry(2018,1900));
        information.add(new BarEntry(2019,2200));

        BarDataSet dataset=new BarDataSet(information,"Report");
        dataset.setColors(ColorTemplate.MATERIAL_COLORS);
        dataset.setValueTextColor(Color.BLACK);
        dataset.setValueTextSize(20f);

        BarData barData=new BarData(dataset);

        barChart.setFitBars(true);
        barChart.setData(barData);
        barChart.getDescription().setText("Bar Report Demo");
        barChart.animateX(2000);
        barChart.animateY(2000);
    }

    private void getLineChart() {
        lineChart=(LineChart)findViewById(R.id.linechart);
        ArrayList<Entry> information=new ArrayList<>();

//        for (int i = 0; i < MainActivity.OuterArl.size(); i++){
//            information.add(new Entry((float) MainActivity.OuterArl.get(i).getObservations().get(i).getElevation().get(i).getX(), (float) MainActivity.OuterArl.get(i).getObservations().get(i).getElevation().get(i).getY()));
//        }

        information.add(new Entry(10,80));
        information.add(new Entry(50,90));
        information.add(new Entry(100,110));
        information.add(new Entry(150,80));
        information.add(new Entry(500,130));

        LineDataSet lineDataSet=new LineDataSet(information,"Information");
        lineDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        lineDataSet.setValueTextColor(Color.BLACK);
        lineDataSet.setValueTextSize(20f);
        LineData lineData=new LineData(lineDataSet);
        lineChart.setData(lineData);
        lineChart.animateX(2000);
        lineChart.animateY(2000);
    }

    private void getPieChart() {
        pieChart = (PieChart)findViewById(R.id.piechart);

        ArrayList<PieEntry> records=new ArrayList<>();

        records.add(new PieEntry(32,"Quarter1"));
        records.add(new PieEntry(14,"Quarter2"));
        records.add(new PieEntry(34,"Quarter3"));
        records.add(new PieEntry(38,"Quarter4"));

        PieDataSet dataSet=new PieDataSet(records,"Pie Chart Report");
        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        dataSet.setValueTextColor(Color.BLACK);
        dataSet.setValueTextSize(22f);

        PieData pieData=new PieData(dataSet);
        pieChart.setData(pieData);
        pieChart.getDescription().setEnabled(true);
        pieChart.setCenterText("Quarterly Revenue");
        pieChart.animate();
        pieChart.animateX(2000);
        pieChart.animateY(2000);
    }

    private void getBubbleChart() {
        bubbleChart = findViewById(R.id.bubblechart);

        bubbleChart.getDescription().setEnabled(false);
        bubbleChart.setDrawGridBackground(false);
        bubbleChart.getAxisRight().setEnabled(false);

        ArrayList<BubbleEntry> information=new ArrayList<>();

        information.add(new BubbleEntry(0, 15f, 25f));
        information.add(new BubbleEntry(1, 25f, 15f));
        information.add(new BubbleEntry(2, 20f, 40f));
        information.add(new BubbleEntry(3, 35f, 25f));
        information.add(new BubbleEntry(4, 50f, 30f));

        BubbleDataSet dataSet = new BubbleDataSet(information, "Bubble Data");
        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        dataSet.setDrawValues(true);

        BubbleData bubbleData = new BubbleData(dataSet);
        bubbleChart.setData(bubbleData);
        bubbleChart.invalidate();
        bubbleChart.animateX(2000);
        bubbleChart.animateY(2000);
    }

    private void getCandleStickChart() {
        candleStickChart = findViewById(R.id.candleStickchart);

        // Configure chart settings
        candleStickChart.getDescription().setEnabled(false);
        candleStickChart.getLegend().setEnabled(false);

        ArrayList<CandleEntry> entries = new ArrayList<>();
        entries.add(new CandleEntry(0, 20f, 10f, 30f, 15f));
        entries.add(new CandleEntry(1, 25f, 15f, 35f, 20f));
        entries.add(new CandleEntry(2, 30f, 20f, 40f, 25f));
        entries.add(new CandleEntry(3, 35f, 25f, 45f, 30f));
        entries.add(new CandleEntry(4, 40f, 30f, 50f, 35f));

        CandleDataSet dataSet = new CandleDataSet(entries, "OHLC Data");
        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        dataSet.setShadowColor(Color.DKGRAY);
        dataSet.setShadowWidth(0.7f);
        dataSet.setDecreasingColor(Color.RED);
        dataSet.setDecreasingPaintStyle(Paint.Style.FILL);
        dataSet.setIncreasingColor(Color.GREEN);
        dataSet.setIncreasingPaintStyle(Paint.Style.FILL);
        dataSet.setNeutralColor(Color.BLUE);
        dataSet.setDrawValues(false);

        CandleData candleData = new CandleData(dataSet);
        candleStickChart.setData(candleData);
        candleStickChart.invalidate();

        candleStickChart.animateX(2000);
        candleStickChart.animateY(2000);
    }

    private void getRadarChart() {
        radarChart = findViewById(R.id.radarchart);

        List<RadarEntry> entries = new ArrayList<>();
        entries.add(new RadarEntry(4f));
        entries.add(new RadarEntry(5f));
        entries.add(new RadarEntry(6f));
        entries.add(new RadarEntry(3f));
        entries.add(new RadarEntry(7f));

        RadarDataSet dataSet = new RadarDataSet(entries, "Radar Chart");
        dataSet.setColor(Color.BLUE);
        dataSet.setDrawFilled(true);

        RadarData radarData = new RadarData(dataSet);

        radarChart.setData(radarData);
        radarChart.getDescription().setEnabled(false);
        radarChart.getLegend().setEnabled(false);
        radarChart.setWebColor(Color.LTGRAY);
        radarChart.setWebColorInner(Color.LTGRAY);
        radarChart.setTouchEnabled(false);
        radarChart.invalidate();

        radarChart.animateX(2000);
        radarChart.animateY(2000);
    }

    private void getCombinedChart() {
        combinedChart = findViewById(R.id.combinedchart);

        List<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(0, 3f));
        barEntries.add(new BarEntry(1, 5f));
        barEntries.add(new BarEntry(2, 2f));

        BarDataSet barDataSet = new BarDataSet(barEntries, "Bar Data");
        barDataSet.setColor(Color.RED);
        barDataSet.setDrawValues(true);

        BarData barData = new BarData(barDataSet);

        List<Entry> lineEntries = new ArrayList<>();
        lineEntries.add(new Entry(0, 1f)); // Line Entry 1
        lineEntries.add(new Entry(1, 3f)); // Line Entry 2
        lineEntries.add(new Entry(2, 2f)); // Line Entry 3

        LineDataSet lineDataSet = new LineDataSet(lineEntries, "Line Data");
        lineDataSet.setColor(Color.BLUE);
        lineDataSet.setDrawValues(true);

        LineData lineData = new LineData(lineDataSet);

        CombinedData combinedData = new CombinedData();
        combinedData.setData(barData);
        combinedData.setData(lineData);

        combinedChart.setData(combinedData);
        combinedChart.getDescription().setEnabled(false);
        combinedChart.getLegend().setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        combinedChart.invalidate();

        combinedChart.animateX(2000);
        combinedChart.animateY(2000);
    }

    private void getScatterChart() {
        scatterChart = findViewById(R.id.scatterchart);

        List<Entry> scatterEntries = new ArrayList<>();
        scatterEntries.add(new Entry(0, 1));
        scatterEntries.add(new Entry(1, 3));
        scatterEntries.add(new Entry(2, 2));
        scatterEntries.add(new Entry(3, 5));
        scatterEntries.add(new Entry(4, 4));

        ScatterDataSet scatterDataSet = new ScatterDataSet(scatterEntries, "Scatter Data");
        scatterDataSet.setColor(Color.RED);
        scatterDataSet.setScatterShape(ScatterChart.ScatterShape.SQUARE);
        scatterDataSet.setScatterShapeSize(10f);

        ScatterData scatterData = new ScatterData(scatterDataSet);

        scatterChart.setData(scatterData);
        scatterChart.getDescription().setEnabled(false);
        scatterChart.getLegend().setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        scatterChart.invalidate();

        scatterChart.animateX(2000);
        scatterChart.animateY(2000);
    }

    private void getHorizontalBarChart() {
        horizontalBarChart = findViewById(R.id.horizontalbarchart);

        List<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(0f, 10f));
        barEntries.add(new BarEntry(1f, 20f));
        barEntries.add(new BarEntry(2f, 15f));
        barEntries.add(new BarEntry(3f, 25f));
        barEntries.add(new BarEntry(4f, 30f));

        BarDataSet barDataSet = new BarDataSet(barEntries, "Bar Data");
        barDataSet.setColor(Color.BLUE);

        BarData barData = new BarData(barDataSet);

        horizontalBarChart.setData(barData);
        horizontalBarChart.getDescription().setEnabled(false);

        XAxis xAxis = horizontalBarChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);

        YAxis yAxisLeft = horizontalBarChart.getAxisLeft();
        yAxisLeft.setDrawGridLines(false);

        YAxis yAxisRight = horizontalBarChart.getAxisRight();
        yAxisRight.setEnabled(false);

        horizontalBarChart.invalidate();

        horizontalBarChart.animateX(2000);
        horizontalBarChart.animateY(2000);
    }
}