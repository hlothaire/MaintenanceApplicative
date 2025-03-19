package event;

import java.time.LocalDateTime;

public class EventPeriodique extends Event {

    private final FrequenceEvenement frequence;

    public EventPeriodique(TitreEvenement titre, PropietaireEvenement propietaire,
                           DateEvenement date, DureeEvenement duree, FrequenceEvenement frequence) {
        super(titre,propietaire,date,duree);
        this.frequence = frequence;
    }

    @Override
    public String description() {
        return "Événement périodique : " + title.getTitre() + " tous les " + frequence.getFrequence() + " jours";
    }

    @Override
    public Boolean dansPeriode(DateEvenement debut, DateEvenement fin) {
        DateEvenement current = dateDebut;
        while (current.isBefore(debut)) {
            if (current.isBetween(debut, fin)) return true;
            current = current.plusDays(frequence.getFrequence());
        }
        return false;
    }
}
