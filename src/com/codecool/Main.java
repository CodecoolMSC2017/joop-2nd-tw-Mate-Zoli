package com.codecool;

public class Main {

    public static void main(String[] args) {
        Simulation verseny = new Simulation(Integer.parseInt(args[0]));

        for(int i = 0; i < verseny.getAmountOfSimulations(); i++) {
            verseny.horsesFromFile("Horses.csv");
            for (int j = 0; j < verseny.getHorses().length; j++) {
                verseny.countLapTime(verseny.getHorses()[j]);
                System.out.println(verseny.getHorses()[j]);
                System.out.println("\n\n");
            }
        }

        verseny.generateData();



        System.out.println("\n\n\n\n\n fityma");
        verseny.loadHorsesFromFile("generateData.csv");

        for (int j = 0; j < verseny.getLoadHorses().length; j++) {
            System.out.println(verseny.getLoadHorses()[j]);
            System.out.println("\n\n");
            }
    }
}