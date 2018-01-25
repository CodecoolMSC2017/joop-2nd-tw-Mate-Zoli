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
        Logger logger = new Logger();

        Simulator simulator = new Simulator(s, logger);

        for(int i = 0; i < simulator.countEndResult().length; i++) {
            System.out.println(simulator.countEndResult()[i]);
        }

        Result res = simulator.run();
        System.out.println("\n\n" + res.getStatistics().getFastestHorse());
        System.out.println("\n\n" + res.getStatistics().getSlowestHorse());
        System.out.println("\n\n" + res.getStatistics().getWinners()[0].getName()+ "win: " + res.getStatistics().getWinners()[0].getWinCount());
        System.out.println("\n\n" + res.getStatistics().getWinners()[1].getName()+ "win: " + res.getStatistics().getWinners()[1].getWinCount());
        System.out.println("\n\n" + res.getStatistics().getWinners()[2].getName()+ "win: " + res.getStatistics().getWinners()[2].getWinCount());
        System.out.println("\n\n" + res.getStatistics().getWinners()[3].getName()+ "win: " + res.getStatistics().getWinners()[3].getWinCount());
        




    }
}