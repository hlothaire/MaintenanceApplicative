import java.time.LocalDateTime;

public class Event {
    public String type; // "RDV_PERSONNEL", "REUNION", "PERIODIQUE"
    public TitreEvenement title;
    public PropietaireEvenement proprietaire;
    public DateEvenement dateDebut;
    public DureeEvenement dureeMinutes;
    public LieuEvenement lieu; // utilisé seulement pour REUNION
    public ParticipantsEvenement participants; // séparés par virgules (pour REUNION uniquement)
    public FrequenceEvenement frequenceJours; // uniquement pour PERIODIQUE

    public Event(String type, TitreEvenement title, PropietaireEvenement proprietaire, DateEvenement dateDebut,
                 DureeEvenement dureeMinutes, LieuEvenement lieu, ParticipantsEvenement participants,
                 FrequenceEvenement frequenceJours) {
        this.type = type;
        this.title = title;
        this.proprietaire = proprietaire;
        this.dateDebut = dateDebut;
        this.dureeMinutes = dureeMinutes;
        this.lieu = lieu;
        this.participants = participants;
        this.frequenceJours = frequenceJours;
    }

    public String description() {
        String desc = "";
        if (type.equals("RDV_PERSONNEL")) {
            desc = "RDV : " + title + " à " + dateDebut.toString();
        } else if (type.equals("REUNION")) {
            desc = "Réunion : " + title + " à " + lieu + " avec " + participants;
        } else if (type.equals("PERIODIQUE")) {
            desc = "Événement périodique : " + title + " tous les " + frequenceJours + " jours";
        }
        return desc;
    }
}