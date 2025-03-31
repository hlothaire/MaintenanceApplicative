package utilisateur;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurRepository {
    private final List<Utilisateur> utilisateurs = new ArrayList<>();

    public void add(Utilisateur user) {
        utilisateurs.add(user);
    }

    public Utilisateur findByNomAndPassword(NomUtilisateur nom, MotDePasse mdp) {
        return utilisateurs.stream()
                .filter(u -> u.getNom().toString().equals(nom.toString()) && u.authentifier(mdp))
                .findFirst()
                .orElse(null);
    }
}

