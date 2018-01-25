package com.codecool;

public class Result {

    private Statistics statistics;
    private Horse[] endResult;

    public Result(Horse[] endResult,Statistics statistics) {
        this.endResult = endResult;
        this.statistics = statistics;
    }
    
    
    public Statistics getStatistics() {
        return statistics;
    }
    

    public Horse[] getEndResult() {
        return endResult;
    }

    
} 