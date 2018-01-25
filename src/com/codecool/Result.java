package com.codecool;

public class Result {

    //private Statistics statistics;
    private Horse[] endResult;

    public Result(Horse[] endResult) {
        //this.statistics = statistics;
        this.endResult = endResult;
    }
    
    /*
    public Statistics getStatistics() {
        return statistics;
    }
    */

    public Horse[] getEndResult() {
        return endResult;
    }

    
} 