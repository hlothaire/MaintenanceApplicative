package action;

import ui.TerminalUI;
import utilisateur.Utilisateur;

public class DefaultMenuAction implements MenuAction {
    private final TerminalUI ui;

    public DefaultMenuAction(TerminalUI ui) {
        this.ui = ui;
    }

    @Override
    public boolean execute(Utilisateur user) {
        ui.println("Choix non reconnu.");
        return true;
    }
}

