package com.codecool;

public class Statstics {

    private Horse fastesHorse;
    private Horse slowestHorse;
    private Horse fattestJockey;

    public Statstics () {}

    public Horse getFastesHorse() {
        return fastesHorse;
    }

    public void setFastesHorse(Horse fastesHorse) {
        this.fastesHorse = fastesHorse;
    }

    public Horse getSlowestHorse() {
        return slowestHorse;
    }

    public void setSlowestHorse(Horse slowestHorse) {
        this.slowestHorse = slowestHorse;
    }

    public Horse getFattestJockey() {
        return fattestJockey;
    }

    public void setFattestJockey(Horse fattestJockey) {
        this.fattestJockey = fattestJockey;
    }


}