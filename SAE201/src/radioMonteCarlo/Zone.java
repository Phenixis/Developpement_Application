package radioMonteCarlo;

public class Zone {

    private String nomZone;
    private int nbPlaces;
    private double prixUnitaire;

    public Zone(String nomZone, int nbPlaces, double prixUnitaire) {
        this.nomZone = nomZone;
        this.nbPlaces = nbPlaces;
        this.prixUnitaire = prixUnitaire;
    }

    public String getNomZone() {
        return nomZone;
    }

    public void setNomZone(String nomZone) {
        this.nomZone = nomZone;
    }

    public int getNbPlaces() {
        return nbPlaces;
    }

    public void setNbPlaces(int nbPlaces) {
        this.nbPlaces = nbPlaces;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }
}
