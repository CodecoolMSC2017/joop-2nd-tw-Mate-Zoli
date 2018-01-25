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
        double argsDouble = Double.parseDouble(args[0]);

        Simulator simulator = new Simulator(s, logger);

        logger.log("Results over " + args[0] + "simulations: ","\n");
        for(int i = 0; i < simulator.countEndResult().length; i++) {
            logger.log("\t" + (i+1) + ".Place",simulator.countEndResult()[i].getName());
            logger.log("\tAverage time:",logger.printTime(simulator.countEndResult()[i].getLapTime()));
        }

        Result res = simulator.run();
        logger.log("\nStatistics over " + args[0] + " simulations:","\n");

        logger.log("\tFastest horse:",res.getStatistics().getFastestHorse().getName());
        logger.log("\tAverage speed:",res.getStatistics().getFastestHorse().getSpeed() + "Km/h \n");

        logger.log("\tSlowest horse:",res.getStatistics().getSlowestHorse().getName());
        logger.log("\tAverage speed:",res.getStatistics().getSlowestHorse().getSpeed() + "Km/h \n");
        
        
        logger.log("1st most rounds won by horse:",res.getStatistics().getWinners()[0].getName());
        logger.log("\tJockey name:",res.getStatistics().getWinners()[0].getJockeyName());
        logger.log("\tRounds won:",Integer.toString(res.getStatistics().getWinners()[0].getWinCount()));
        logger.log("\tWins in percentage:",String.valueOf((res.getStatistics().getWinners()[0].getWinCount() / argsDouble)*100) + "%\n");

        logger.log("2nd most rounds won by horse:",res.getStatistics().getWinners()[1].getName());
        logger.log("\tJockey name:",res.getStatistics().getWinners()[1].getJockeyName());
        logger.log("\tRounds won:",Integer.toString(res.getStatistics().getWinners()[1].getWinCount()));
        logger.log("\tWins in percentage:",String.valueOf((res.getStatistics().getWinners()[1].getWinCount() / argsDouble)*100) + "%\n");

        logger.log("3rd most rounds won by horse:",res.getStatistics().getWinners()[2].getName());
        logger.log("\tJockey name:",res.getStatistics().getWinners()[2].getJockeyName());
        logger.log("\tRounds won:",Integer.toString(res.getStatistics().getWinners()[2].getWinCount()));
        logger.log("\tWins in percentage:",String.valueOf((res.getStatistics().getWinners()[2].getWinCount() / argsDouble)*100) + "%\n");
        
        




    }
}