package event;

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

    public abstract String description();

}