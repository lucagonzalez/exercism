public class LogLevels {
    
    public static String message(String logLine) {
        final String [] stringArr = logLine.split(":");

        return stringArr[1].trim();
    }

    public static String logLevel(String logLine) {
        final String [] stringArr = logLine.toLowerCase().split(":");

        return stringArr[0].substring(1, stringArr[0].length()-1);
    }

    public static String reformat(String logLine) {

        return message(logLine) + " (" + logLevel(logLine) + ")";
    }
}
