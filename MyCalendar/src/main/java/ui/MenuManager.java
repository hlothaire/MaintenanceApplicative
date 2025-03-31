package ui;

import action.*;
import auth.DeconnexionAction;
import event.CalendarManager;
import utilisateur.Utilisateur;

import java.util.HashMap;
import java.util.Map;

public class MenuManager {
    private final TerminalUI ui;
    private final CalendarManager calendar;
    private final Map<String, MenuAction> actions;
    private final MenuAction defaultAction;

    public MenuManager(TerminalUI ui, CalendarManager calendar) {
        this.ui = ui;
        this.calendar = calendar;
        this.actions = new HashMap<>();
        actions.put("1", new VoirEvenementsAction(ui, calendar));
        actions.put("2", new AjouterRdvAction(ui, calendar));
        actions.put("3", new AjouterReunionAction(ui, calendar));
        actions.put("4", new AjouterEvenementPeriodiqueAction(ui, calendar));
        actions.put("5", new DeconnexionAction(ui));
        this.defaultAction = new DefaultMenuAction(ui);
    }

    public MenuAction getAction(String key) {
        return actions.getOrDefault(key, defaultAction);
    }

    public void runSession(Utilisateur user) {
        boolean sessionActive = true;
        while (sessionActive) {
            ui.println("\nBonjour, " + user.getNom());
            ui.println("=== Menu Gestionnaire d'Événements ===");
            ui.println("1 - Voir les événements");
            ui.println("2 - Ajouter un rendez-vous personnel");
            ui.println("3 - Ajouter une réunion");
            ui.println("4 - Ajouter un événement périodique");
            ui.println("5 - Se déconnecter");
            ui.println("Votre choix : ");
            String choix = ui.readLine();
            MenuAction action = getAction(choix);
            sessionActive = action.execute(user);
            ui.pause();
        }
    }
}

