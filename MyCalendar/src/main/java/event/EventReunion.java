package event;

import java.time.LocalDateTime;

public class EventReunion extends Event {

    private final LieuEvenement lieu;
    private final ParticipantsEvenement participants;

    public EventReunion(TitreEvenement titre, PropietaireEvenement propietaire,
                        DateEvenement date, DureeEvenement duree, LieuEvenement lieu,
                        ParticipantsEvenement participants) {
        super(titre,propietaire,date,duree);
        this.lieu = lieu;
        this.participants = participants;
    }

    @Override
    public String description() {
        return "Réunion : " + title.getTitre() + " à " + lieu.getLieu() + " avec " + participants.getParticipant();
    }

    @Override
    public Boolean dansPeriode(DateEvenement debut, DateEvenement fin) {
        return dateDebut.isBetween(debut, fin);
    }
}
