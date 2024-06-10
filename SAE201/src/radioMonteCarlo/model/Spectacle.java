package radioMonteCarlo.model;

import java.util.ArrayList;

public class Spectacle {
	static public ArrayList<Spectacle> list = new ArrayList<>();

    private String nom;
    private int duree;
    private String genre;
    private int nbreMaxSpect;
    private ArrayList<Representation> listeRepresentations=new ArrayList<>();
    private ArrayList<Artiste> listeArtiste=new ArrayList<>();
    
    public Spectacle(String nom, int duree, String genre, int nbreMaxSpect) {
        this.nom = nom;
        this.duree = duree;
        this.genre = genre;
        this.nbreMaxSpect = nbreMaxSpect;
        
    }

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

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getNbreMaxSpect() {
		return nbreMaxSpect;
	}

	public void setNbreMaxSpect(int nbreMaxSpect) {
		this.nbreMaxSpect = nbreMaxSpect;
	}
	
    
	
	public ArrayList<Representation> getListeRepresentations() {
		return listeRepresentations;
	}

	public void setListeRepresentations(ArrayList<Representation> listeRepresentations) {
		this.listeRepresentations = listeRepresentations;
	}

	

	public ArrayList<Artiste> getListeArtiste() {
		return listeArtiste;
	}

	public void setListeArtiste(ArrayList<Artiste> listeArtiste) {
		this.listeArtiste = listeArtiste;
	}


	private void addSpectacle(Spectacle spectacle) {
		list.add(spectacle);
	}

	private void removeSpectacle(Spectacle spectacle) {
		list.remove(spectacle);
	}

	private void ajoutSpectacle(Spectacle spectacle) {
		this.addSpectacle(spectacle);
	}

	private void retirerSpectacle(Spectacle spectacle) {
		if(this.list.size()!=1) {
		    if (this.list.contains(spectacle)) {
		        this.removeSpectacle(spectacle);
		    }
			else {
		        System.out.println("Erreur : representation spécifié n'est pas présent dans la liste.");
		    }
		}else {
			System.out.println("Erreur : minimum 1 representation");
		}	
	}
	

	public void addRepresentation(Representation representation) {
		this.listeRepresentations.add(representation);
	}

	public void removeRepresentation(Representation representation) {
		this.listeRepresentations.remove(representation);
	}

	public void ajoutRepresentation(Representation representation) {
		this.addRepresentation(representation);
	}

	public void retirerRepresentation(Representation representation) {
		if (this.listeRepresentations.size() != 1) {
			if (this.listeRepresentations.contains(representation)) {
				this.removeRepresentation(representation);
			} else {
				System.out.println("Erreur : représentation spécifiée n'est pas présente dans la liste.");
			}
		} else {
			System.out.println("Erreur : minimum 1 représentation");
		}
	}
	
	
	
	
	public void addArtiste(Artiste artiste) {
		this.listeArtiste.add(artiste);
	}

	public void removeArtiste(Artiste artiste) {
		this.listeArtiste.remove(artiste);
	}

	public void ajoutArtiste(Artiste artiste) {
		this.addArtiste(artiste);
	}

	public void retirerArtiste(Artiste artiste) {
		if (this.listeArtiste.size() != 1) {
			if (this.listeArtiste.contains(artiste)) {
				this.removeArtiste(artiste);
			} else {
				System.out.println("Erreur : artiste spécifié n'est pas présent dans la liste.");
			}
		} else {
			System.out.println("Erreur : minimum 1 artiste");
		}
	}
	
	
	
    
	
	

    
}
