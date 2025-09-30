import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class AppointmentScheduler {
    public LocalDateTime schedule(String appointmentDateDescription) {
        String[] dateTimeArr = appointmentDateDescription.split(" ");

        String[] monthDayYearArr = dateTimeArr[0].split("/");

        StringBuilder newString = new StringBuilder();

        newString.append(monthDayYearArr[2])
                .append("-")
                .append(monthDayYearArr[0])
                .append("-")
                .append(monthDayYearArr[1])
                .append("T")
                .append(dateTimeArr[1]);


        return LocalDateTime.parse(newString, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    public boolean hasPassed(LocalDateTime appointmentDate) {
        return appointmentDate.isBefore(LocalDateTime.now());
    }

    public boolean isAfternoonAppointment(LocalDateTime appointmentDate) {
        LocalTime localTime = appointmentDate.toLocalTime();

        LocalTime afternoonStart = LocalTime.of(11, 59, 59);
        LocalTime afternoonEnd = LocalTime.of(18, 0);
        return localTime.isAfter(afternoonStart) && localTime.isBefore(afternoonEnd);
    }

    public String getDescription(LocalDateTime appointmentDate) {
        LocalDate localDate = appointmentDate.toLocalDate();
        LocalTime localTime = appointmentDate.toLocalTime();

        String formattedDate = localDate.format(DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy,"));
        String formattedTime = localTime.format(DateTimeFormatter.ofPattern("h:mm "));
        String formattedAMPM = localTime.format(DateTimeFormatter.ofPattern("a")).toUpperCase();

        return "You have an appointment on " + formattedDate + " at " + formattedTime + formattedAMPM + ".";
    }

    public LocalDate getAnniversaryDate() {
        int currYear = LocalDate.now().getYear();
        return LocalDate.of(currYear, 9, 15);
    }
}
