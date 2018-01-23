package com.codecool;

public class Main {

    public static void main(String[] args) {
        Simulation verseny = new Simulation(Integer.parseInt(args[0]));

        for(int i = 0; i < verseny.getAmountOfSimulations(); i++) {
            verseny.horsesFromFile("Horses.csv");
            for (int j = 0; j < verseny.getHorses().length; j++) {
                //System.out.println(verseny.getHorses()[i].getSpeed());
                //verseny.countSpeed(verseny.getHorses()[i]);
                //System.out.println(verseny.getHorses()[i].getSpeed());
                //System.out.println("countlaptime: " + verseny.countLapTime(verseny.getHorses()[i]));
                //System.out.println("countrip: " + verseny.tripCount(verseny.getHorses()[i]));
                //System.out.println((verseny.getHorses()[i].getName()) + "    " + verseny.countLapTime(verseny.getHorses()[i]));
                verseny.countLapTime(verseny.getHorses()[j]);
                System.out.println(verseny.getHorses()[j]);
                System.out.println("\n\n");
            }
        }

        verseny.generateData();

        verseny.load();

        for (int j = 0; j < verseny.getLoadHorses().length; j++) {
            //System.out.println(verseny.getHorses()[i].getSpeed());
            //verseny.countSpeed(verseny.getHorses()[i]);
            //System.out.println(verseny.getHorses()[i].getSpeed());
            //System.out.println("countlaptime: " + verseny.countLapTime(verseny.getHorses()[i]));
            //System.out.println("countrip: " + verseny.tripCount(verseny.getHorses()[i]));
            //System.out.println((verseny.getHorses()[i].getName()) + "    " + verseny.countLapTime(verseny.getHorses()[i]));
            System.out.println(verseny.getLoadHorses()[j]);
            System.out.println("\n\n");
            }
    }
}