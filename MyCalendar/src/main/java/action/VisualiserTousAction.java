package action;

import event.CalendarManager;
import ui.TerminalUI;
import utilisateur.Utilisateur;

public class VisualiserTousAction implements MenuAction {
    private final TerminalUI ui;
    private final CalendarManager calendar;

    public VisualiserTousAction(TerminalUI ui, CalendarManager calendar) {
        this.ui = ui;
        this.calendar = calendar;
    }

    @Override
    public boolean execute(Utilisateur user) {
        calendar.afficherEvenements();
        return true;
    }
}

