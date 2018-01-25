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

    public Horse[] sortHorseArray(Horse[] horses,String sortBy) {
        Horse temp = null;
        for(int i=0; i < horses.length; i++){
            for(int j=1; j < (horses.length-i); j++){
                if (sortBy.equals("time")) {
                    if(horses[j-1].getLapTime() > horses[j].getLapTime()){   
                        temp = horses[j-1];
                        horses[j-1] = horses[j];
                        horses[j] = temp;
                    }
                }
                else if (sortBy.equals("speed")) {
                    if(horses[j-1].getSpeed() > horses[j].getSpeed()){   
                        temp = horses[j-1];
                        horses[j-1] = horses[j];
                        horses[j] = temp;
                    }
                }
                else if (sortBy.equals("win")) {
                    if(horses[j-1].getWinCount() < horses[j].getWinCount()) {
                        temp = horses[j-1];
                        horses[j-1] = horses[j];
                        horses[j] = temp;
                    }
                }
            }
        }
        return horses;

    }

    public void simulationResult() {
        Horse[] horses = simulation.getLoadHorses();
        for(int i = 0; i < horses.length; i += 10) {
            Horse[] tempHorseArray = new Horse[0];
            for(int j = i; j < (i+10); j++) {
                tempHorseArray = addToHorseArray(tempHorseArray, horses[j]);
            }
            sortHorseArray(tempHorseArray,"time");
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
        sortHorseArray(endResult,"time");

        return endResult;
    }

    public Horse getFastestOrSlowestHorse(String speed) {
        Horse[] horses = simulation.getLoadHorses();
        Horse[] slowOrFast = new Horse[0];

        for (int j = 0; j < 10; j++) {
            int actualHorseSpeed = 0;
            for (int i = j; i < horses.length; i += 10) {
                actualHorseSpeed += horses[i].getSpeed();
            }
            horses[j].setSpeed(actualHorseSpeed / simulation.getAmountOfSimulations());
            slowOrFast = addToHorseArray(slowOrFast, horses[j]);
        }
        sortHorseArray(slowOrFast,"speed");
        if (speed.equals("slow")){ 
            return slowOrFast[0];
        }
        else if (speed.equals("fast")){
            return slowOrFast[slowOrFast.length -1];
        }
        return null;
    }

    public Horse[] increaseWinRate() {
        Simulation sample = new Simulation(1);
        sample.horsesFromFile("Horses.csv");
        simulationResult();
        Horse[] horses = sortedHorsesByLapTime;
        Horse[] winnerHorses = sample.getHorses();
        for (int i=0;i < horses.length;i+=10) {
            for (int j = 0; j < winnerHorses.length;j++) {
                if (horses[i].getName().equals(winnerHorses[j].getName())) {
                    winnerHorses[j].setWinCount(1);
                }
            }
        }
        return winnerHorses;
    }

    public Horse[] winners() {
        Horse[] horses = increaseWinRate();
        Horse[] firstThree = new Horse[0];

        horses=sortHorseArray(horses,"win");
        for (int i=0;i < 3;i++) {
            firstThree = addToHorseArray(firstThree,horses[i]);
        }

        return firstThree;
    }


    public Result run() {
        Statistics stat = new Statistics();
        stat.setSlowestHorse(getFastestOrSlowestHorse("slow"));
        stat.setFastestHorse(getFastestOrSlowestHorse("fast"));
        stat.setWinners(winners());
        Result result = new Result(countEndResult(),stat);
        return result; 
    }


}

