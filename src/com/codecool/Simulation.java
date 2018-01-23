import java.io.*;

public class Simulation {
    private Horse[] horses;
    private int amountOfSimulations;

    public Simulation(int amountOfSimulations) {
        this.amountOfSimulations = amountOfSimulations;
        horses = new Horse[0];
    }

    public void horsesFromFile(String filename) {
        String line = "";
        try(BufferedReader br = new BufferedReader(new FileReader("../data/" + filename))){
            while((line = br.readLine()) != null) {
                String[] horse = line.split(",");
                Horse newHorse = new Horse(horse[0], horse[1],Integer.parseInt(horse[2]), Integer.parseInt(horse[3]), Integer.parseInt(horse[4]));
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
}