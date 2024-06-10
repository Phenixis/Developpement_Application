package radioMonteCarlo.model;

import java.util.ArrayList;

public class Spectacle {
	static public ArrayList<Spectacle> list = new ArrayList<>();

    private String nom;
    private int duree;
    private String genre;
    private int nbreMaxSpect;
    
    // Relation avec Représentation
    private ArrayList<Representation> listeRepresentations=new ArrayList<>();
    
    // Relation avec Artiste
    private ArrayList<Artiste> listeArtiste=new ArrayList<>();
    
    public Spectacle(String nom, int duree, String genre, int nbreMaxSpect) {
        this.nom = nom;
        this.duree = duree;
        this.genre = genre;
        this.nbreMaxSpect = nbreMaxSpect;
        
    }
    
    
    // Accesseurs
    
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public String getGenre() {
		return genre;
	}

	private void setGenre(String genre) {
		this.genre = genre;
	}
	
	public void mettreGenre(String genre)  {
		if (!Genre.contains(genre)) {
			System.out.println("La valeur de genre donnée (" + genre + ") n'est pas dans la liste des genre enregistrés.");
		} else {
			this.setGenre(genre);
		}
	}

	public int getNbreMaxSpect() {
		return nbreMaxSpect;
	}

	public void setNbreMaxSpect(int nbreMaxSpect) {
		this.nbreMaxSpect = nbreMaxSpect;
	}
	
    // Relation avec Représentation
	private void addRepresentation(Representation representation) {
		this.listeRepresentations.add(representation);
	}

	public void ajoutRepresentation(Representation representation) {
		if (representation.getSpectacle().equals(this)) { // set le spectacle dans Représentation avant de le mettre dans Spectacle
			this.addRepresentation(representation);			
		}
	}

	public void annulerRepresentation(Representation representation) {
		if (this.listeRepresentations.size() != 1) {
			if (this.listeRepresentations.contains(representation)) {
				if (representation.getSpectacle().equals(this)) {
					representation.annuler();
				} else {
					System.out.println("Erreur : la représentation ne correspond pas au spectacle.");
				}
			} else {
				System.out.println("Erreur : la représentation spécifiée n'est pas présente dans la liste.");
			}
		} else {
			System.out.println("Erreur : il doit y avoir au minimum 1 représentation par spectacle");
		}
	}
	
	// Relation avec Artiste
	public void addArtiste(Artiste artiste) {
		this.listeArtiste.add(artiste);
	}

	public void removeArtiste(Artiste artiste) {
		this.listeArtiste.remove(artiste);
	}

	public boolean ajoutArtiste(Artiste artiste) {
		this.addArtiste(artiste);
		return true;
	}

	public boolean retirerArtiste(Artiste artiste) {
		if (this.listeArtiste.size() != 1) {
			if (this.listeArtiste.contains(artiste)) {
				if (artiste.retirerSpectacle(this)) {
					this.removeArtiste(artiste);
					return true;
				}
			} else {
				System.out.println("Erreur : l'artiste spécifié n'est pas présent dans la liste.");
			}
		} else {
			System.out.println("Erreur : il doit y avoir au minimum 1 artiste");
		}
		return false;
	}
}
