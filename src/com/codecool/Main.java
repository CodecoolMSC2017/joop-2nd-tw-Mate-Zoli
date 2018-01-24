package com.codecool;

public class Main {

    public static Simulation generateSimulation(int round) {
        Simulation simulation = new Simulation(round);
        for (int i = 0; i < round; i++) {
            simulation.horsesFromFile("Horses.csv");
            for (int j = 0; j < simulation.getHorses().length; j++) {
                    simulation.countLapTime(simulation.getHorses()[j]);
                }
            simulation.generateData();
        }
        simulation.loadHorsesFromFile("generateData.csv");

        return simulation;
    }

    public static void main(String[] args) {
        Simulation s = generateSimulation(Integer.parseInt(args[0]));
        for(int i = 0; i < s.getLoadHorses().length; i++) {
            System.out.println(s.getLoadHorses()[i]);
        }

    }
}