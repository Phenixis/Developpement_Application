package radioMonteCarlo;

public class Statistique {

    private List<Information> informations;

    public Statistique() {
        this.informations = new ArrayList<>();
    }

    public void trierParNom() {
        Collections.sort(informations, new Comparator<Information>() {
            @Override
            public int compare(Information information1, Information information2) {
                return information1.getNom().compareTo(information2.getNom());
            }
        });
    }

    public void trierParDate() {
        Collections.sort(informations, new Comparator<Information>() {
            @Override
            public int compare(Information information1, Information information2) {
                return information1.getAnnee().compareTo(information2.getAnnee());
            }
        });
    }

    public List<Information> getInformations() {
        return informations;
    }

    public void setInformations(List<Information> informations) {
        this.informations = informations;
    }
}