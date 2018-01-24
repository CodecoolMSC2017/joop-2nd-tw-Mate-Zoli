package com.codecool;

public class Result {

    private Simulation simulation;
    //private Statistics statistics;
    private Horse[] sortedHorsesByLapTime;

    public Result(Simulation simulation) {
        this.simulation = simulation;
        //this.statistics = statistics;
        sortedHorsesByLapTime = new Horse[0];
    }

    public Simulation getSimulation() {
        return simulation;
    }

    /*
    public Statistics getStatistics() {
        return statistics;
    }
    */

    public Horse[] getSortedHorsesByLapTime() {
        return sortedHorsesByLapTime;
    }

    public void addToHorseArray(Horse[] horses, Horse horse) {
        Horse[] tempArray = new Horse[horses.length + 1];
        for (int i = 0; i < horses.length; i++) {
            tempArray[i] = horses[i];
        }
        tempArray[tempArray.length - 1] = horse;
        horses = tempArray;
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
                addToHorseArray(tempHorseArray, horses[j]);
            }
            System.out.println("tempHorseArray length: " + tempHorseArray.length);
            sortHorseArray(tempHorseArray);
            for(int x = 0; x < tempHorseArray.length; x++) {
                addToHorseArray(sortedHorsesByLapTime, tempHorseArray[x]);
            }
        }
    }
} 