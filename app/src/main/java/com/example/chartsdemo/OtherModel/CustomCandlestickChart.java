package com.example.chartsdemo.OtherModel;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.example.chartsdemo.OtherModel.CandlestickData;

import java.util.ArrayList;
import java.util.List;

public class CustomCandlestickChart extends View {
    private List<CandlestickData> candlestickDataList;
    private Paint candlePaint;
    private float candleWidth;
    private float cornerRadius;

    public CustomCandlestickChart(Context context) {
        super(context);
        init();
    }

    public CustomCandlestickChart(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        candlestickDataList = new ArrayList<>();
        candlePaint = new Paint();
        candleWidth = 70f;
        cornerRadius = 100f;
    }

    public void setCandlestickDataList(List<CandlestickData> dataList) {
        candlestickDataList = dataList;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Draw candlestick bars
        for (CandlestickData data : candlestickDataList) {
            float x = data.getX();
            float high = data.getHigh();
            float low = data.getLow();
            float open = data.getOpen();
            float close = data.getClose();

            float left = x - candleWidth / 2;
            float right = x + candleWidth / 2;
//            float top = Math.min(open, close);
//            float bottom = Math.max(open, close);

            // Apply corner radius
            RectF rect = new RectF(left, high, right, low);
            candlePaint.setColor(data.getColor());
            canvas.drawRoundRect(rect, cornerRadius, cornerRadius, candlePaint);

            // Draw high and low lines
            canvas.drawLine(x, high, x, high, candlePaint);
            canvas.drawLine(x, low, x, low, candlePaint);
        }
    }
}