package com.codecool;

import java.io.*;
import java.util.Random;
import java.lang.Math;

public class Simulation {

    private Horse[] horses;
    private Horse[] loadHorses;
    private int amountOfSimulations;
    private static final double TRACK_LENGTH_KM = 1.0;
    private static Random random = new Random();
    private static StringBuilder builder = new StringBuilder();

    public Simulation(int amountOfSimulations) {
        this.amountOfSimulations = amountOfSimulations;
        horses = new Horse[0];
        loadHorses = new Horse[0];
    }

    public Horse[] getHorses() {
        return horses;
    }

    public Horse[] getLoadHorses() {
        return loadHorses;
    }

    public int getAmountOfSimulations() {
        return amountOfSimulations;
    }

    public void horsesFromFile(String filename) {
        horses = new Horse[0];
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

    public void loadHorsesFromFile(String filename) {
        String line = "";
        try(BufferedReader br = new BufferedReader(new FileReader("../data/" + filename))){
            while((line = br.readLine()) != null) {
                String[] horse = line.split(",");
                Horse newLoadHorse = new Horse(horse[0], horse[1], Integer.parseInt(horse[2]), Integer.parseInt(horse[3]), Integer.parseInt(horse[4]), Integer.parseInt(horse[5]), Double.parseDouble(horse[6]));
                addToLoadHorseArray(newLoadHorse);
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

    public void addToLoadHorseArray(Horse horse) {
        Horse[] tempArray = new Horse[loadHorses.length + 1];
        for (int i = 0; i < loadHorses.length; i++) {
            tempArray[i] = loadHorses[i];
        }
        tempArray[tempArray.length - 1] = horse;
        loadHorses = tempArray;
    }

    public double countRaceEnergy(Horse horse) {
        return (horse.getEnergyLevel()/90.0);
    }

    public void countSpeed(Horse horse) {
        double newSpeed = (horse.getSpeed()) * (countRaceEnergy(horse))*(jockeyWeightChangePercentage(horse));
        horse.setSpeed((int)Math.round(newSpeed));
    }

    public void countLapTime(Horse horse) {
        countSpeed(horse);
        double time = (TRACK_LENGTH_KM / horse.getSpeed()) * 3600;
        horse.setLapTime((time + tripCount(horse)));
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

    public double jockeyWeightChangePercentage(Horse horse) {
        int weightChange = (-3+random.nextInt(7));
        double oldWeight = horse.getJockeyWeight();
        horse.setJockeyWeight(weightChange);
        return (1 - (((horse.getJockeyWeight() - oldWeight)/100)*2));
    }

    public void generateData() {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new File("../data/generateData.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for(int i = 0; i < horses.length; i++) {
            builder.append(horses[i].getName());
            builder.append(',');
            builder.append(horses[i].getJockeyName());
            builder.append(',');
            builder.append(horses[i].getSpeed());
            builder.append(',');
            builder.append(horses[i].getJockeyWeight());
            builder.append(',');
            builder.append(horses[i].getTripChance());
            builder.append(',');
            builder.append(horses[i].getEnergyLevel());
            builder.append(',');
            builder.append(horses[i].getLapTime());
            builder.append('\n');
        }
        pw.write(builder.toString());
        pw.close();
    }

    public void load() {
        horsesFromFile("generateData.csv");
    }
}