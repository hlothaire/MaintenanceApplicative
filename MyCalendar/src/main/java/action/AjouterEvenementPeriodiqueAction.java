package action;

import event.*;
import ui.TerminalUI;
import utilisateur.Utilisateur;

import java.time.LocalDateTime;

public class AjouterEvenementPeriodiqueAction implements MenuAction {
    private final TerminalUI ui;
    private final CalendarManager calendar;

    public AjouterEvenementPeriodiqueAction(TerminalUI ui, CalendarManager calendar) {
        this.ui = ui;
        this.calendar = calendar;
    }

    @Override
    public boolean execute(Utilisateur user) {
        String titre = ui.saisirChaine("Titre de l'événement :");
        LocalDateTime dateDebut = ui.saisirDateHeure("Saisir la date et l'heure de début :");
        int frequence = ui.saisirEntier("Fréquence (en jours) :");
        calendar.ajouterEvent(new EventPeriodique(
                new TitreEvenement(titre),
                new PropietaireEvenement(user.getNom().toString()),
                new DateEvenement(dateDebut),
                new DureeEvenement(0),
                new FrequenceEvenement(frequence)
        ));
        ui.println("Événement ajouté.");
        return true;
    }
}

