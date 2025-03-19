import event.*;

import java.util.List;

public class CalendarManager {
    public Evenements evenements;

    public CalendarManager() {
        this.evenements = new Evenements();
    }

    public void ajouterEvent(Event event) {
        this.evenements.ajouterEvenement(event);
    }

    public List<Event> eventsDansPeriode(DateEvenement debut, DateEvenement fin) {
        return evenements.eventDansPeriode(debut,fin);
    }

    public boolean conflit(Event e1, Event e2) {
        return e1.conflit(e2);
    }

    public void afficherEvenements() {
        evenements.afficher();
    }
}