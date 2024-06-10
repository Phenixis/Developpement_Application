package radioMonteCarlo.model;

import java.util.ArrayList;

public class Spectacle {
	static public ArrayList<Spectacle> list = new ArrayList<>();

    private String nom;
    private int duree;
    private String genre;
    private int nbreMaxSpect;
    private ArrayList<Representation> listeRepresentations=new ArrayList<>();
    private Information information;
    private ArrayList<Artiste> listeArtiste=new ArrayList<>();
    
    public Spectacle(String nom, int duree, String genre, int nbreMaxSpect) {
        this.nom = nom;
        this.duree = duree;
        this.genre = genre;
        this.nbreMaxSpect = nbreMaxSpect;
        this.information = new Information(this);
        
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

	public Information getInformation() {
		return information;
	}

	public void setInformation(Information information) {
		this.information = information;
	}

	public ArrayList<Artiste> getListeArtiste() {
		return listeArtiste;
	}

	public void setListeArtiste(ArrayList<Artiste> listeArtiste) {
		this.listeArtiste = listeArtiste;
	}

	public void ajoutRepresentation(Representation representation){
		this.listeRepresentations.add(representation);
		representation.ajoutSpectacle(this);
		
		this.information.misajour(representation);
	}
	
	public void removeRepresentation(Representation representation) {
		if(this.listeRepresentations.size()!=1) {
		    if (this.listeRepresentations.contains(representation)) {
		        this.listeRepresentations.remove(representation);
		    } else {
		        System.out.println("Erreur : representation spécifié n'est pas présent dans la liste.");
		    }
		}else {
			System.out.println("Erreur : minimum 1 representation");
		}	
	}
	
	
	public void ajoutInformation(Information information){
		this.information=information;
	}
	
	
	
	
	public void ajoutArtiste(Artiste artiste){
		this.listeArtiste.add(artiste);
	}
	
	public void retirerArtiste(Artiste artiste) {
		if(this.listeArtiste.size()!=1) {
		    if (this.listeArtiste.contains(artiste)) {
		        this.listeArtiste.remove(artiste);
		    } else {
		        System.out.println("Erreur : artiste spécifié n'est pas présent dans la liste.");
		    }
		}else {
			System.out.println("Erreur : minimum 1 artiste");
		}	
	}
	
	
	
    
	
	

    
}
