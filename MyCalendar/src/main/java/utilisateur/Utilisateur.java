package utilisateur;

public final class Utilisateur {
    private final NomUtilisateur nom;
    private final MotDePasse motDePasse;

    public Utilisateur(NomUtilisateur nom, MotDePasse motDePasse) {
        this.nom = nom;
        this.motDePasse = motDePasse;
    }

    public NomUtilisateur getNom() {
        return nom;
    }

    public boolean authentifier(MotDePasse mdp) {
        return motDePasse.correspond(mdp);
    }
}
