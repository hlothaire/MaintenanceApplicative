package auth;

import ui.TerminalUI;
import utilisateur.Utilisateur;

public class DefaultLoginAction implements LoginAction {
    private final TerminalUI ui;

    public DefaultLoginAction(TerminalUI ui) {
        this.ui = ui;
    }

    @Override
    public Utilisateur execute() {
        ui.println("Choix non reconnu. Réessayez.");
        return null;
    }
}

