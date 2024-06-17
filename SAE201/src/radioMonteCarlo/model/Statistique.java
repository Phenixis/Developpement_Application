package radioMonteCarlo.model;

import java.util.ArrayList;
import javafx.beans.property.*;
import javafx.fxml.FXML;

public class Statistique {
	static public ArrayList<Statistique> liste = new ArrayList<>();
	
	private Spectacle spectacle;
	private Representation repr;
	StringProperty dateRepr;
	StringProperty heureRepr;
	StringProperty nomSpec; // valeur récupérée
	IntegerProperty nbBilletRepr;
	IntegerProperty nbRepr; // valeur récupérée
	IntegerProperty nbBilletTotal; // valeur calculée
	FloatProperty moyBillet; // valeur calculée
	
	public Statistique(Spectacle spectacle, Representation repr) {
		this.spectacle=spectacle;
		this.repr=repr;
		this.nomSpec= new SimpleStringProperty(spectacle.getNom());
		this.dateRepr= new SimpleStringProperty(repr.getDate());
		this.heureRepr= new SimpleStringProperty(repr.getHeure());
		this.nbBilletRepr= new SimpleIntegerProperty(repr.getNbBilletVendu());
		this.update();
		
		this.moyBillet=new SimpleFloatProperty(moyenneBillet());
		
		Statistique.liste.add(this);
	}
	
	public void update() {
		this.nbRepr=new SimpleIntegerProperty(spectacle.getRepresentations().size());
		this.nbBilletTotal= new SimpleIntegerProperty(nombreBillet());
	}

	private int nombreBillet(){
		int nb=0;
		
		for(Representation i : this.spectacle.getRepresentations()){
			nb+=i.getNbBilletVendu();
		}
		
		return nb;
	}	

	private float moyenneBillet(){
		this.update();
		return nbBilletTotal.getValue()/nbRepr.getValue();
	}
	
	// Accesseurs
	public String getDateRepr() {
		return dateRepr.getValue();
	}
	
	public StringProperty dateReprProperty() {
		return dateRepr;
	}

	public String getHeureRepr() {
		return heureRepr.getValue();
	}
	
	public StringProperty heureReprProperty() {
		return heureRepr;
	}
	
	public String getNomSpec() {
		return nomSpec.getValue();
	}
	
	public StringProperty nomSpecProperty() {
		return nomSpec;
	}
	
	public int getNbRepr() {
		return nbRepr.getValue();
	}

	public IntegerProperty nbReprProperty() {
		this.update();
		return nbRepr;
	}
	
	public int getNbBilletTotal() {
		return nbBilletTotal.getValue();
	}

	public IntegerProperty nbBilletTotalProperty() {
		this.update();
		return nbBilletTotal;
	}
	
	public int getNbBilletRepr() {
		return nbBilletRepr.getValue();
	}

	public IntegerProperty nbBilletReprProperty() {
		this.update();
		return nbBilletRepr;
	}
	
	public float getMoyBillet() {
		this.moyBillet = new SimpleFloatProperty(moyenneBillet());
		return moyBillet.getValue();
	}

	public FloatProperty moyBilletProperty() {
		this.moyBillet = new SimpleFloatProperty(moyenneBillet());
		return moyBillet;
	}

	@Override
	public String toString() {
		return "Statistique [spectacle=" + spectacle + ", nomSpectacle=" + nomSpec + ", nbRepresentation="
				+ nbRepr + ", nbBillet=" + nbBilletTotal + ", moyBillet=" + moyBillet + "]";
	}
	
	
}