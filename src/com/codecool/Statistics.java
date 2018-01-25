package com.codecool;

public class Statistics {

    private Horse fastesHorse;
    private Horse slowestHorse;
    private Horse[] winners;

    public Statistics () {}

    public Horse getFastestHorse() {
        return fastesHorse;
    }

    public void setFastestHorse(Horse fastesHorse) {
        this.fastesHorse = fastesHorse;
    }

    public Horse getSlowestHorse() {
        return slowestHorse;
    }

    public void setSlowestHorse(Horse slowestHorse) {
        this.slowestHorse = slowestHorse;
    }


    public Horse[] getWinners() {
        return winners;
    }

    public void setWinners(Horse[] horses) {
        this.winners = horses;
    }

}