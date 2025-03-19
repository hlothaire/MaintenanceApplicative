package event;

import java.time.LocalDateTime;

public abstract class Event {
    public TitreEvenement title;
    public PropietaireEvenement proprietaire;
    public DateEvenement dateDebut;
    public DureeEvenement dureeMinutes;

    public Event(TitreEvenement title, PropietaireEvenement proprietaire, DateEvenement dateDebut,
                 DureeEvenement dureeMinutes) {
        this.title = title;
        this.proprietaire = proprietaire;
        this.dateDebut = dateDebut;
        this.dureeMinutes = dureeMinutes;
    }

    public boolean conflit(Event e) {
        LocalDateTime thisEnd = this.dureeMinutes.addTo(this.dateDebut);
        LocalDateTime otherEnd = e.dureeMinutes.addTo(e.dateDebut);
        return this.dateDebut.getDateDebut().isBefore(otherEnd) && thisEnd.isAfter(e.dateDebut.getDateDebut());
    }

    public abstract String description();
    public abstract Boolean dansPeriode(DateEvenement debut, DateEvenement fin);
}