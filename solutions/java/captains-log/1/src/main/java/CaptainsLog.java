import java.util.Random;

class CaptainsLog {

    private static final char[] PLANET_CLASSES = new char[]{'D', 'H', 'J', 'K', 'L', 'M', 'N', 'R', 'T', 'Y'};

    private final Random random;

    CaptainsLog(Random random) {
        this.random = random;
    }

    char randomPlanetClass() {
        return PLANET_CLASSES[random.nextInt(0, PLANET_CLASSES.length)];
    }

    String randomShipRegistryNumber() {
        int number = random.nextInt(1000, 10000);
        return "NCC-".concat(String.valueOf(number));
    }

    double randomStardate() {
        return 41000.0 + 1000.0 * random.nextDouble();
    }
}
