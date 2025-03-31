package utilisateur;

public final class NomUtilisateur {
    private final String value;

    public NomUtilisateur(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Nom utilisateur invalide");
        }
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
