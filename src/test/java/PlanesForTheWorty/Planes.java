package PlanesForTheWorty;

public class Planes {
    public String getModel() {
        return model;
    }

    public int getSpeed() {
        return speed;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public int getMaxFlyDistance() {
        return maxFlyDistance;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    public void setMaxFlyDistance(int getMaxFlyDistance) {
        this.maxFlyDistance = getMaxFlyDistance;
    }

    String model;
    int speed;
    int maxHeight;
    int maxFlyDistance;

    @Override
    public String toString() {
        return "Planes{" +
                "model='" + model + '\'' +
                ", speed=" + speed +
                ", maxHeight=" + maxHeight +
                ", maxFlyDistance=" + maxFlyDistance +
                '}';
    }

    public Planes(String model, int speed, int maxHeight, int maxFlyDistance) {
        this.model = model;
        this.speed = speed;
        this.maxHeight = maxHeight;
        this.maxFlyDistance = maxFlyDistance;
    }
}
