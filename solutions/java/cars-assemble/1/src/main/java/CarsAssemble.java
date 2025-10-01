public class CarsAssemble {
    //0 the production is off
    //221 cars/hr at 1 speed (Goes linearly up to 10)
    //1 to 4 speed: 100% success rate
    //5 to 8 speed: 90% success rate
    //9 speed: 80% success rate
    //10 speed: 77% success rate
    final int minCarsPerHr = 221;

    public double productionRatePerHour(int speed) {
        return carsPerHr(speed, successRate(speed));
    }

    private double carsPerHr(int speed, double successRate) {
        return (minCarsPerHr * speed) * successRate;
    }

    private static double successRate(int speed) {
        switch (speed) {
            case 5, 6, 7, 8 -> {
                return 0.9;
            }
            case 9 -> {
                return 0.8;
            }
            case 10 -> {
                return 0.77;
            }
            default -> {
                return 1;
            }
        }
    }

    public int workingItemsPerMinute(int speed) {
        return (int) (productionRatePerHour(speed) / 60);
    }
}
