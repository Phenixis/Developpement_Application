package radioMonteCarlo;

public class Information {

    private int annee;
    private String nomSpectacle;
    private int nbRepresentation=0;
    private int totalBilletVendu=0;
    private Spectacle spectacle;
    
	public Information(Spectacle spectacle) {
		this.spectacle=spectacle;
		spectacle.ajoutInformation(this);
		
		this.nomSpectacle=this.spectacle.getNom();
	}

    
	public void misajour(Representation representation) {
		
			this.totalBilletVendu+=representation.getNbBilletVendu();
			this.nbRepresentation+=1;
			
		
	}


	
    
}
