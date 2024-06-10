package radioMonteCarlo.model;

import java.util.ArrayList;

public class Statistique {
	static Statistique calculerStats(Spectacle spec) {
		return new Statistique(spec);
	}
	
	Spectacle spectacle;
	private String nomSpectacle; // valeur récupérée
	private int nbRepresentation; // valeur récupérée
	private int nbBillet=0; // valeur calculée
	private float moyBillet=0; // valeur calculée
	
	private Statistique(Spectacle spectacle) {
		this.nomSpectacle=spectacle.getNom();
		
		this.update();
		
		this.moyBillet=moyenneBillet(spectacle);
	}
	
	public void update() {
		this.nbRepresentation=spectacle.getRepresentations().size();
		this.nbBillet=nombreBillet(spectacle);
	}

	private int nombreBillet(Spectacle spectacle){
		int nb=0;
		
		for(Representation i : spectacle.getRepresentations()){
			nb+=i.getNbBilletVendu();
		}
		
		return nb;
	}	

	private int moyenneBillet(Spectacle spectacle){
		this.update();
		return nbBillet/nbRepresentation;
	
	}

}