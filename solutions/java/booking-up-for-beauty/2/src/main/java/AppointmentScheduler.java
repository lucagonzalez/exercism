import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Locale;

class AppointmentScheduler {
    public LocalDateTime schedule(String appointmentDateDescription) {
        return LocalDateTime.parse(appointmentDateDescription, DateTimeFormatter.ofPattern("MM/dd/yyyy kk:mm:ss"));
    }

    public boolean hasPassed(LocalDateTime appointmentDate) {
        return LocalDateTime.now().isAfter(appointmentDate);
    }

    public boolean isAfternoonAppointment(LocalDateTime appointmentDate) {
        return appointmentDate.getHour() >= 12 && appointmentDate.getHour() < 18;
    }

    public String getDescription(LocalDateTime appointmentDate) {
        LocalDate localDate = appointmentDate.toLocalDate();
        LocalTime localTime = appointmentDate.toLocalTime();

        String formattedDate = localDate.format(DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy,"));
        String formattedTime = localTime.format(DateTimeFormatter.ofPattern("K:mm a", Locale.forLanguageTag("en")));

        return "You have an appointment on " + formattedDate + " at " + formattedTime + ".";
    }

    public LocalDate getAnniversaryDate() {
        int currYear = LocalDate.now().getYear();
        return LocalDate.of(currYear, 9, 15);
    }
}
