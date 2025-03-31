package action;

import event.CalendarManager;
import event.DateEvenement;
import ui.TerminalUI;
import utilisateur.Utilisateur;

import java.time.LocalDateTime;

public class VisualiserJourAction implements MenuAction {
    private final TerminalUI ui;
    private final CalendarManager calendar;

    public VisualiserJourAction(TerminalUI ui, CalendarManager calendar) {
        this.ui = ui;
        this.calendar = calendar;
    }

    @Override
    public boolean execute(Utilisateur user) {
        int annee = ui.saisirEntier("Entrez l'année (AAAA) :");
        int mois = ui.saisirEntier("Entrez le mois (1-12) :");
        int jour = ui.saisirEntier("Entrez le jour (1-31) :");
        LocalDateTime debut = LocalDateTime.of(annee, mois, jour, 0, 0);
        LocalDateTime fin = debut.plusDays(1).minusSeconds(1);
        calendar.eventsDansPeriode(new DateEvenement(debut), new DateEvenement(fin)).afficher();
        return true;
    }
}

