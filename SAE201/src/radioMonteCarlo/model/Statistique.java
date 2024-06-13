package radioMonteCarlo.model;

import java.util.ArrayList;

public class Statistique {
	static public ArrayList<Statistique> liste = new ArrayList<>();
	
	private Spectacle spectacle;
	String dateRepr="test";
	String heureRepr="test";
	String nomSpec="test"; // valeur récupérée
	int nbRepr=0; // valeur récupérée
	int nbBilletTotal=0; // valeur calculée
	int nbBilletRepr=0;
	float moyBillet=0; // valeur calculée
	
	public Statistique(Spectacle spectacle) {
		this.nomSpec=spectacle.getNom();
		this.spectacle=spectacle;
		this.update();
		
		this.moyBillet=moyenneBillet();
		
		Statistique.liste.add(this);
	}
	
	public void update() {
		this.nbRepr=spectacle.getRepresentations().size();
		this.nbBilletTotal=nombreBillet();
	}

	private int nombreBillet(){
		int nb=0;
		
		for(Representation i : this.spectacle.getRepresentations()){
			nb+=i.getNbBilletVendu();
		}
		
		return nb;
	}	

	private int moyenneBillet(){
		this.update();
		return nbBilletTotal/nbRepr;
	}
	
	// Accesseurs
	public String getNomSpectacle() {
		return nomSpec;
	}

	public int getNbRepresentation() {
		this.update();
		return nbRepr;
	}

	public int getNbBillet() {
		this.update();
		return nbBilletTotal;
	}

	public float getMoyBillet() {
		this.moyBillet = moyenneBillet();
		return moyBillet;
	}
	
	

	@Override
	public String toString() {
		return "Statistique [spectacle=" + spectacle + ", nomSpectacle=" + nomSpec + ", nbRepresentation="
				+ nbRepr + ", nbBillet=" + nbBilletTotal + ", moyBillet=" + moyBillet + "]";
	}
	
	
}