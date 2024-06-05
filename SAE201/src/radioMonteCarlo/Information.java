package radioMonteCarlo;

public class Information {

    private String nom;
    private Spectacle spectacle;

    public Information(String nom, Spectacle spectacle) {
        this.nom = nom;
        this.spectacle = spectacle;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Spectacle getSpectacle() {
        return spectacle;
    }

    public void setSpectacle(Spectacle spectacle) {
        this.spectacle = spectacle;
    }
}
