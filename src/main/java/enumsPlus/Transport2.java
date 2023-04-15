package enumsPlus;

public enum Transport2 {
    CAR(65, "land"), TRUCK(55, "land"), AIRPLANE(600, "air"), TRAIN(70, "land"), BOAT(22, "water");

    private int speed; // Typical speed of each transport type
    private String terrain;

    // Constructor
    Transport2(int s, String terr){
        speed = s;
        terrain = terr;
    }

    public int getSpeed() {
        return speed;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
