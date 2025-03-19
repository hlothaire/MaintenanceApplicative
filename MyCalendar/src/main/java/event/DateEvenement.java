package event;

import java.time.LocalDateTime;

public class DateEvenement {

    private final LocalDateTime dateDebut;

    public DateEvenement(LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public LocalDateTime asLocalDateTime() {
        return dateDebut;
    }

    public DateEvenement plusDays(long days) {
        return new DateEvenement(dateDebut.plusDays(days));
    }
    public boolean isBefore(DateEvenement other) {
        return dateDebut.isBefore(other.dateDebut);
    }

    public boolean isAfter(DateEvenement other) {
        return dateDebut.isAfter(other.getDateDebut());
    }

    public boolean isBetween(DateEvenement start, DateEvenement end) {
        return !isBefore(start) && !isAfter(end);
    }
}
