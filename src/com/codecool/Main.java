package com.codecool;

public class Main {

    public static void main(String[] args) {
        Simulation verseny = new Simulation(Integer.parseInt(args[0]));

        verseny.horsesFromFile("Horses.csv");
        for (int i = 0;i < verseny.getHorses().length;i++) {
            //System.out.println(verseny.getHorses()[i].getSpeed());
            //verseny.countSpeed(verseny.getHorses()[i]);
            //System.out.println(verseny.getHorses()[i].getSpeed());
            System.out.println("countlaptime: " + verseny.countLapTime(verseny.getHorses()[i]));
            System.out.println("countrip: " + verseny.tripCount(verseny.getHorses()[i]));
            System.out.println((verseny.getHorses()[i].getName()) + "    " + verseny.countLapTime(verseny.getHorses()[i]));
            System.out.println("\n\n");
        }
    }
}