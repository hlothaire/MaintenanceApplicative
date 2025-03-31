package action;

import event.CalendarManager;
import event.DateEvenement;
import ui.TerminalUI;
import utilisateur.Utilisateur;

import java.time.LocalDateTime;

public class VisualiserSemaineAction implements MenuAction {
    private final TerminalUI ui;
    private final CalendarManager calendar;

    public VisualiserSemaineAction(TerminalUI ui, CalendarManager calendar) {
        this.ui = ui;
        this.calendar = calendar;
    }

    @Override
    public boolean execute(Utilisateur user) {
        LocalDateTime debut = ui.saisirDebutSemaine("Saisissez la semaine souhaitée :");
        LocalDateTime fin = debut.plusDays(7).minusSeconds(1);
        calendar.eventsDansPeriode(new DateEvenement(debut), new DateEvenement(fin)).afficher();
        return true;
    }
}

