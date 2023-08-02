package com.example.chartsdemo.JsonDataModel;

public class HikeInnerXY {
    private double startY, endY;

    public HikeInnerXY(double startY, double endY) {
        this.startY = startY;
        this.endY = endY;
    }

    public double getStartY() {
        return startY;
    }

    public void setStartY(double startY) {
        this.startY = startY;
    }

    public double getEndY() {
        return endY;
    }

    public void setEndY(double endY) {
        this.endY = endY;
    }
}
