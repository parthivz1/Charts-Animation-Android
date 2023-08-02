package com.example.chartsdemo.OtherModel;

public class CandlestickData {
    private float x;
    private float high;
    private float low;
    private float open;
    private float close;
    private int color;

    // Constructor and getter/setter methods

    public CandlestickData(float x,float low, float high, float open, float close, int color) {
        this.x = x;
        this.low = low;
        this.high = high;
        this.open = open;
        this.close = close;
        this.color = color;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getHigh() {
        return high;
    }

    public void setHigh(float high) {
        this.high = high;
    }

    public float getLow() {
        return low;
    }

    public void setLow(float low) {
        this.low = low;
    }

    public float getOpen() {
        return open;
    }

    public void setOpen(float open) {
        this.open = open;
    }

    public float getClose() {
        return close;
    }

    public void setClose(float close) {
        this.close = close;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}

