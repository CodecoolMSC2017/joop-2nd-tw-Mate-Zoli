package com.codecool;

public class Horse {

    private String name;
    private String jockeyName;
    private int speed;
    private int jockeyWeigth;
    private int tripChance;
    private int energyLevel;
    private double lapTime;

    public Horse(String name, String jockeyName, int speed, int jockeyWeigth, int tripChance,int energyLevel) {
        this.name = name;
        this.jockeyName = jockeyName;
        this.speed = speed;
        this.jockeyWeigth = jockeyWeigth;
        this.tripChance = tripChance;
        this.energyLevel = energyLevel;
        this.lapTime = 0;
    }

    public Horse(String name, String jockeyName, int speed, int jockeyWeigth, int tripChance,int energyLevel, double lapTime) {
        this.name = name;
        this.jockeyName = jockeyName;
        this.speed = speed;
        this.jockeyWeigth = jockeyWeigth;
        this.tripChance = tripChance;
        this.energyLevel = energyLevel;
        this.lapTime = lapTime;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed=speed;
    }

    public String getJockeyName() {
        return jockeyName;
    }

    public int getJockeyWeight() {
        return jockeyWeigth;
    }

    public void setJockeyWeight(int weightChange) {
        jockeyWeigth += weightChange;
    }

    public int getTripChance() {
        return tripChance;
    }

    public int getEnergyLevel() {
        return energyLevel;
    }

    public double getLapTime() {
        return lapTime;
    }

    public void setLapTime(double lapTime) {
        this.lapTime = lapTime;
    }

    @Override
    public String toString() {
        return "Horse's name: " + name 
                + ", Horse's speed: " + speed
                + ", Jockey's name: " + jockeyName
                + ", Jockey's weigth: " + jockeyWeigth
                + ", Trip chance: " + tripChance
                + ", Horse's energylevel: " + energyLevel
                + ", Horse's lap time: " + lapTime;
    }

}