package com.codecool;

public class Horse {

    private String name;
    private String jockeyName;
    private int speed;
    private int jockeyWeigth;
    private int tripChance;
    private int energyLevel;
    private double lapTime;
    private int winCount;
    private static Logger logger = new Logger();

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
        this.winCount = 0;
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

    public int getWinCount() {
        return winCount;
    }

    public void setWinCount(int win) {
        winCount += win;
    }

    @Override
    public String toString() {
        return "Horse's name: " + name 
                + ", Jockey's name: " + jockeyName
                + ", Horse's average lap time: " + logger.printTime(lapTime);
    }

}