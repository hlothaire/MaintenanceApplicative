package auth;

import action.MenuAction;
import ui.TerminalUI;
import utilisateur.Utilisateur;

public class DeconnexionAction implements MenuAction {
    private final TerminalUI ui;

    public DeconnexionAction(TerminalUI ui) {
        this.ui = ui;
    }

    @Override
    public boolean execute(Utilisateur user) {
        ui.println("Déconnexion...");
        return false;
    }
}

