package com.codecool;

import java.io.*;
import java.util.Random;
import java.lang.Math;

public class Simulation {
    private Horse[] horses;
    private int amountOfSimulations;
    private static final double TRACK_LENGTH_KM = 1.0;
    private static Random random = new Random();

    public Simulation(int amountOfSimulations) {
        this.amountOfSimulations = amountOfSimulations;
        horses = new Horse[0];
    }

    public void horsesFromFile(String filename) {
        String line = "";
        try(BufferedReader br = new BufferedReader(new FileReader("../data/" + filename))){
            while((line = br.readLine()) != null) {
                String[] horse = line.split(",");
                int energyLevel = 100 - random.nextInt(20);
                Horse newHorse = new Horse(horse[0], horse[1],Integer.parseInt(horse[2]), Integer.parseInt(horse[3]), Integer.parseInt(horse[4]),energyLevel);
                addToHorseArray(newHorse);
            }
        }catch (IOException e) {
            e.printStackTrace();

        }
    }

    public void addToHorseArray(Horse horse) {
        Horse[] tempArray = new Horse[horses.length + 1];
        for (int i = 0; i < horses.length; i++) {
            tempArray[i] = horses[i];
        }
        tempArray[tempArray.length - 1] = horse;
        horses = tempArray;
    }

    public void countSpeed(Horse horse) {
        double newSpeed = ((horse.getSpeed()) * (horse.getEnergyLevel()/90))*(jockeyWeightChangePercentage(horse));
        horse.setSpeed((int)Math.round(newSpeed));
    }

    public double countLapTime(Horse horse) {
        countSpeed(horse);
        double time = (TRACK_LENGTH_KM / horse.getSpeed()) * 3600;
        return time + tripCount(horse);
    }

    public int tripCount(Horse horse) {
        int occurences = (int)(TRACK_LENGTH_KM/0.1);
        int penaltySeconds = 0;
        for(int i = 0; i < occurences; i++) {
            int rand = random.nextInt(101) + 1;
            if (rand <= horse.getTripChance()) {
                penaltySeconds++;
            }
        }
        return penaltySeconds;
    }

    public Horse[] getHorses() {
        return horses;
    }

    public double jockeyWeightChangePercentage(Horse horse) {
        int weightChange = (-3+random.nextInt(7));
        int oldWeight = horse.getJockeyWeight();
        horse.setJockeyWeight(weightChange);
        return  (1 - (((horse.getJockeyWeight() - oldWeight)/100)*2));
    }

    
}