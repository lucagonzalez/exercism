public class LogLine {
    final LogLevel level;
    final String message;

    public LogLine(String logLine) {
        String logLvlStr = logLine.substring(1, 4);
        this.level = switch (logLvlStr) {
            case "TRC" -> LogLevel.TRACE;
            case "DBG" -> LogLevel.DEBUG;
            case "INF" -> LogLevel.INFO;
            case "WRN" -> LogLevel.WARNING;
            case "ERR" -> LogLevel.ERROR;
            case "FTL" -> LogLevel.FATAL;
            default -> LogLevel.UNKNOWN;
        };
        this.message = logLine.substring(7);
    }

    public LogLevel getLogLevel() {
        return level;
    }

    public String getOutputForShortLog() {
        return String.format("%s:%s",level.getErrorCode(),message);
    }
}
