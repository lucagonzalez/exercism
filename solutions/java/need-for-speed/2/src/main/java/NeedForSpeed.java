class NeedForSpeed {
    int speed;
    int batteryDrain;
    int distanceDriven;
    int battery;

    NeedForSpeed(int speed, int batteryDrain) {
        this.speed = speed;
        this.batteryDrain = batteryDrain;
        this.distanceDriven = 0;
        this.battery = 100;
    }

    public boolean batteryDrained() {
        return battery - batteryDrain < 0;
    }

    public int distanceDriven() {
        return distanceDriven;
    }

    public void drive() {
        if (battery > 0) {
            distanceDriven += speed;
            battery -= batteryDrain;
        }
    }

    public static NeedForSpeed nitro() {
        return new NeedForSpeed(50, 4);
    }
}

class RaceTrack {
    int distance;

    RaceTrack(int distance) {
        this.distance = distance;
    }

    public boolean canFinishRace(NeedForSpeed car) {
        double driveRequired = (double) distance / car.speed;
        final double batteryDrain = driveRequired * car.batteryDrain;
        return batteryDrain <= car.battery;
    }
}
