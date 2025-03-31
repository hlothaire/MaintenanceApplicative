package action;

import event.CalendarManager;
import ui.TerminalUI;
import utilisateur.Utilisateur;

public class VoirEvenementsAction implements MenuAction {
    private final TerminalUI ui;
    private final CalendarManager calendar;

    public VoirEvenementsAction(TerminalUI ui, CalendarManager calendar) {
        this.ui = ui;
        this.calendar = calendar;
    }

    @Override
    public boolean execute(Utilisateur user) {
        ui.println("=== Visualisation des événements ===");
        ui.println("1 - Afficher TOUS les événements");
        ui.println("2 - Afficher les événements d'un MOIS précis");
        ui.println("3 - Afficher les événements d'une SEMAINE précise");
        ui.println("4 - Afficher les événements d'un JOUR précis");
        ui.println("5 - Retour");
        String choix = ui.readLine();
        MenuAction subAction = new VisualisationActionFactory(ui, calendar).getAction(choix);
        subAction.execute(user);
        return true;
    }
}

