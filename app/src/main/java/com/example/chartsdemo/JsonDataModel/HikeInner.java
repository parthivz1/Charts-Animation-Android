package com.example.chartsdemo.JsonDataModel;

import java.util.ArrayList;

public class HikeInner {
    private double distanceFromStart;
    private ArrayList<HikeInnerXY> elevation, pace, heartRate;


    public HikeInner(double distanceFromStart, ArrayList<HikeInnerXY> elevation, ArrayList<HikeInnerXY> pace, ArrayList<HikeInnerXY> heartRate) {
        this.distanceFromStart = distanceFromStart;
        this.elevation = elevation;
        this.pace = pace;
        this.heartRate = heartRate;
    }

    public double getDistanceFromStart() {
        return distanceFromStart;
    }

    public void setDistanceFromStart(double distanceFromStart) {
        this.distanceFromStart = distanceFromStart;
    }

    public ArrayList<HikeInnerXY> getElevation() {
        return elevation;
    }

    public void setElevation(ArrayList<HikeInnerXY> elevation) {
        this.elevation = elevation;
    }

    public ArrayList<HikeInnerXY> getPace() {
        return pace;
    }

    public void setPace(ArrayList<HikeInnerXY> pace) {
        this.pace = pace;
    }

    public ArrayList<HikeInnerXY> getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(ArrayList<HikeInnerXY> heartRate) {
        this.heartRate = heartRate;
    }
}
