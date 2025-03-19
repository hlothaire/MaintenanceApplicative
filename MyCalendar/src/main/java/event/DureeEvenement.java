package event;

import java.time.LocalDateTime;
import java.time.temporal.TemporalUnit;


public class DureeEvenement {

    private final int duree;

    public DureeEvenement(int duree) {
        this.duree = duree;
    }

    public int getDuree() {
        return duree;
    }
    public LocalDateTime addTo(DateEvenement start) {
        return start.asLocalDateTime().plusMinutes(duree);
    }
}
