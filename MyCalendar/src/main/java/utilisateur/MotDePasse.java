package utilisateur;

public final class MotDePasse {
    private final String value;

    public MotDePasse(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Mot de passe invalide");
        }
        this.value = value;
    }

    public boolean correspond(MotDePasse autre) {
        return this.value.equals(autre.value);
    }

}
