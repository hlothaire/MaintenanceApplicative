package event;

public class EventRDV extends Event {

    public EventRDV(TitreEvenement titre, PropietaireEvenement propietaire,
                    DateEvenement date, DureeEvenement duree) {
        super(titre,propietaire,date,duree);
    }

    @Override
    public String description() {
        return "RDV : " + title.getTitre() + " à " + dateDebut.getDateDebut().toString();
    }

    @Override
    public Boolean dansPeriode(DateEvenement debut, DateEvenement fin) {
        return dateDebut.isBetween(debut, fin);
    }
}
