package auth;

import ui.TerminalUI;
import utilisateur.Utilisateur;
import utilisateur.UtilisateurRepository;

import java.util.HashMap;
import java.util.Map;

public class LoginManager {
    private final TerminalUI ui;
    private final UtilisateurRepository userRepo;
    private final Map<String, LoginAction> actions;
    private final LoginAction defaultAction;

    public LoginManager(TerminalUI ui, UtilisateurRepository userRepo) {
        this.ui = ui;
        this.userRepo = userRepo;
        this.actions = new HashMap<>();
        this.actions.put("1", new ConnecterAction(ui, userRepo));
        this.actions.put("2", new CreerCompteAction(ui, userRepo));
        this.defaultAction = new DefaultLoginAction(ui);
    }

    public Utilisateur execute() {
        ui.afficherBanniere();
        ui.println("1 - Se connecter");
        ui.println("2 - Créer un compte");
        ui.println("Choix : ");
        String choix = ui.readLine();
        LoginAction action = actions.getOrDefault(choix, defaultAction);
        return action.execute();
    }

    public Utilisateur executeUntilSuccess() {
        Utilisateur user = null;
        while (user == null) {
            user = execute();
            ui.pause();
        }
        return user;
    }
}
