package com.codecool;

public class Simulator {

    private Simulation simulation;
    private Logger logger;
    private Horse[] sortedHorsesByLapTime;

    public Simulator(Simulation simulation, Logger logger) {
        this.simulation = simulation;
        this.logger = logger;
        sortedHorsesByLapTime = new Horse[0];
    }

    public Simulation getSimulation() {
        return simulation;
    }

    public Logger getLogger() {
        return logger;
    }

    public Horse[] getSortedHorsesByLapTime() {
        return sortedHorsesByLapTime;
    }

    public Horse[] addToHorseArray(Horse[] horses, Horse horse) {
        Horse[] tempArray = new Horse[horses.length + 1];
        for (int i = 0; i < horses.length; i++) {
            tempArray[i] = horses[i];
        }
        tempArray[tempArray.length - 1] = horse;
        horses = tempArray;
        return horses;
    }

    public void sortHorseArray(Horse[] horses) {
        Horse temp = null;
        for(int i=0; i < horses.length; i++){
            for(int j=1; j < (horses.length-i); j++){
                if(horses[j-1].getLapTime() > horses[j].getLapTime()){   
                    temp = horses[j-1];
                    horses[j-1] = horses[j];
                    horses[j] = temp;
                }
            }
        }
    }

    public void simulationResult() {
        Horse[] horses = simulation.getLoadHorses();
        for(int i = 0; i < horses.length; i += 10) {
            Horse[] tempHorseArray = new Horse[0];
            for(int j = i; j < (i+10); j++) {
                tempHorseArray = addToHorseArray(tempHorseArray, horses[j]);
            }
            sortHorseArray(tempHorseArray);
            for(int x = 0; x < tempHorseArray.length; x++) {
                sortedHorsesByLapTime = addToHorseArray(sortedHorsesByLapTime, tempHorseArray[x]);
            }
        }
    }

    public Horse[] countEndResult() {
        Horse[] horses = simulation.getLoadHorses();
        Horse[] endResult = new Horse[0];

        for (int j = 0; j < 10; j++) {
            double actualHorseTime = 0.0;
            for (int i = j; i < horses.length; i += 10) {
                actualHorseTime += horses[i].getLapTime();
            }
            horses[j].setLapTime(actualHorseTime / simulation.getAmountOfSimulations());
            endResult = addToHorseArray(endResult, horses[j]);
        }
        sortHorseArray(endResult);

        return endResult;
    }

    public Result run() {
        Result result = new Result(countEndResult());
        return result; 
    }


}