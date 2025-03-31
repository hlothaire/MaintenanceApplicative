package action;

import event.*;
import ui.TerminalUI;
import utilisateur.Utilisateur;

import java.time.LocalDateTime;


public class AjouterReunionAction implements MenuAction {
    private final TerminalUI ui;
    private final CalendarManager calendar;

    public AjouterReunionAction(TerminalUI ui, CalendarManager calendar) {
        this.ui = ui;
        this.calendar = calendar;
    }

    @Override
    public boolean execute(Utilisateur user) {
        String titre = ui.saisirChaine("Titre de l'événement :");
        LocalDateTime dateDebut = ui.saisirDateHeure("Saisir la date et l'heure de début :");
        int duree = ui.saisirEntier("Durée (en minutes) :");
        String lieu = ui.saisirChaine("Lieu :");
        calendar.ajouterEvent(new EventReunion(
                new TitreEvenement(titre),
                new PropietaireEvenement(user.getNom().toString()),
                new DateEvenement(dateDebut),
                new DureeEvenement(duree),
                new LieuEvenement(lieu),
                new ParticipantsEvenement(user.getNom().toString()))
        );
        ui.println("Événement ajouté.");
        return true;
    }
}

