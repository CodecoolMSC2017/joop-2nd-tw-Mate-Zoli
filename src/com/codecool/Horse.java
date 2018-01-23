public class Horse {

    private String name;
    private String jockeyName;
    private int speed;
    private int jockeyWeigth;
    private int tripChance;
    private int energyLevel;

    public Horse(String name, String jockeyName, int speed, int jockeyWeigth, int tripChance) {
        this.name = name;
        this.speed = speed;
        this.jockeyName = jockeyName;
        this.jockeyWeigth = jockeyWeigth;
        this.tripChance = tripChance;
        this.energyLevel = 100;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public String getJockeyName() {
        return jockeyName;
    }

    public int getJockeyWeight() {
        return jockeyWeigth;
    }

    public double getTripChance() {
        return tripChance;
    }

    public double getEnergyLevel() {
        return energyLevel;
    }

}