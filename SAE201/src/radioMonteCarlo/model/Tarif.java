package radioMonteCarlo.model;

public class Tarif {
	Spectacle spectacle;
	Zone zone;
	int tarifZone;
	double PleinTarif;
	
	public Tarif(Spectacle spectacle, Zone zone,int tarifZone) {
		this.spectacle=spectacle;
		this.zone = zone;
		this.tarifZone=tarifZone;
	}
	
	
}