public class JedliksToyCar {
    public int battery;
    public int distance;

    public JedliksToyCar() {
        this.battery=100;
        this.distance=0;
    }

    public static JedliksToyCar buy() {
        return new JedliksToyCar();
    }

    public String distanceDisplay() {
        return "Driven "+ distance + " meters";
    }

    public String batteryDisplay() {
        if(battery <= 0){
            return "Battery empty";
        }
        return "Battery at " + battery + "%";
    }

    public void drive() {
        if(battery <= 0){
            return;
        }
        distance+=20;
        battery-=1;
    }
}
