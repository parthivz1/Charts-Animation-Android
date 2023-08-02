package com.example.chartsdemo.JsonDataModel;

import java.util.ArrayList;

public class HikeOuter {
    private String name;
    private int id, difficulty;
    private double distance;
    private ArrayList<HikeInner> observations;

    public HikeOuter(String name, int id, int difficulty, double distance, ArrayList<HikeInner> observations) {
        this.name = name;
        this.id = id;
        this.difficulty = difficulty;
        this.distance = distance;
        this.observations = observations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public ArrayList<HikeInner> getObservations() {
        return observations;
    }

    public void setObservations(ArrayList<HikeInner> observations) {
        this.observations = observations;
    }
}

