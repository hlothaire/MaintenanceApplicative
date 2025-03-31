package auth;

import ui.TerminalUI;
import utilisateur.MotDePasse;
import utilisateur.NomUtilisateur;
import utilisateur.Utilisateur;
import utilisateur.UtilisateurRepository;

public class CreerCompteAction implements LoginAction {
    private final TerminalUI ui;
    private final UtilisateurRepository userRepo;

    public CreerCompteAction(TerminalUI ui, UtilisateurRepository userRepo) {
        this.ui = ui;
        this.userRepo = userRepo;
    }

    @Override
    public Utilisateur execute() {
        NomUtilisateur nom = new NomUtilisateur(ui.saisirChaine("Nom d'utilisateur :"));
        MotDePasse mdp = new MotDePasse(ui.saisirChaine("Mot de passe :"));
        MotDePasse confirmation = new MotDePasse(ui.saisirChaine("Répéter mot de passe :"));
        userRepo.add(new Utilisateur(nom, mdp));
        ui.println("Compte créé avec succès.");
        return userRepo.findByNomAndPassword(nom, mdp);
    }
}

